#include <iostream>
#include <fstream>
#include <string>
#include <sstream>
#include <limits>
#include <windows.h>
using namespace std;

/*****************************************************
* FUNCION PARA EL POSICIONAMIENTO EN X, Y COORDENADA *
******************************************************/
void posicion(int x, int y) {
    HANDLE miManejador = GetStdHandle(STD_OUTPUT_HANDLE);
    COORD dwPos;
    dwPos.X = x;
    dwPos.Y = y;
    SetConsoleCursorPosition(miManejador, dwPos);
}

// Estructura para representar productos
struct Producto {
    string codigo;
    float precio;
    int cantidad;
    string nombreProducto;
    Producto* siguiente;  // Para manejo en lista enlazada
};

// Función para eliminar los espacios al principio y al final de una cadena
string trim(const string& str) {
    size_t start = str.find_first_not_of(" \t\n\r");
    size_t end = str.find_last_not_of(" \t\n\r");
    return (start == string::npos) ? "" : str.substr(start, end - start + 1);
}

void liberarLista(Producto*& lista) {
    Producto* actual = lista;
    while (actual != nullptr) {
        Producto* temp = actual;
        actual = actual->siguiente;
        delete temp;
    }
    lista = nullptr;
}


// Función para cargar los productos desde el archivo a la lista enlazada
void cargarInventario(Producto*& lista) {
    ifstream archivo("INVENTARIO.txt");

    if (!archivo.is_open()) {
        cout << "No se pudo abrir el archivo INVENTARIO.txt.\n";
        return;
    }

    Producto* nuevoProducto;
    string codigo, nombreProducto;
    int cantidad;
    float precio;

    // Limpiar la lista antes de cargar los productos
    liberarLista(lista);

    while (getline(archivo, codigo, ',') && getline(archivo, nombreProducto, ',') && archivo >> cantidad && archivo.ignore() && archivo >> precio) {
        archivo.ignore();  // Ignorar el salto de línea

        // Crear un nuevo producto
        nuevoProducto = new Producto;
        nuevoProducto->codigo = codigo;
        nuevoProducto->nombreProducto = nombreProducto;
        nuevoProducto->cantidad = cantidad;
        nuevoProducto->precio = precio;

        // Insertar al inicio de la lista enlazada
        nuevoProducto->siguiente = lista;
        lista = nuevoProducto;
    }

    archivo.close();
}
// Función para ingresar el precio del producto
float ingresarPrecio() {
    float precio;
    while (true) {
        cout << "Ingrese el precio del producto: ";
        cin >> precio;
        if (precio > 0) {
            break;
        } else {
            cout << "El precio debe ser un valor positivo. Intente de nuevo." << endl;
        }
    }
    return precio;
}

// Función para guardar el inventario en un archivo
void guardarListaInventario(Producto* lista) {
    ofstream archivo("INVENTARIO.txt");

    if (!archivo.is_open()) {
        cout << "\nOcurrió un error al generar la lista\n";
        return;
    }

    Producto* actual = lista;
    while (actual != nullptr) {
        archivo << actual->codigo << ", "
                << actual->nombreProducto << ", "
                << actual->cantidad << ", "
                << actual->precio << "\n";
        actual = actual->siguiente;
    }

    archivo.close();
    cout << "Inventario guardado exitosamente. Presione una tecla para volver al menú.";
    cin.ignore(); // Pausa para el usuario
}
// Función para agregar un nuevo producto al archivo sin sobrescribir todo
void guardarProducto(Producto* producto) {
    ofstream archivo("INVENTARIO.txt", ios::app);  // Abre el archivo en modo agregar

    if (!archivo.is_open()) {
        cout << "\nOcurrió un error al generar la lista\n";
        return;
    }

    archivo << producto->codigo << ","
            << producto->nombreProducto << ","
            << producto->cantidad << ","
            << producto->precio << "\n";  // Evitar espacios adicionales

    archivo.close();
    cout << "Producto guardado exitosamente.\n";
}

// Modificar la función para agregar productos
void agregarProducto(Producto*& lista) {
    Producto* nuevoProducto = new Producto;
    cout << "Ingrese el codigo del producto: ";
    cin >> nuevoProducto->codigo;
    cin.ignore();  // Ignorar el salto de línea dejado por cin
    cout << "Ingrese el nombre del producto: ";
    getline(cin, nuevoProducto->nombreProducto);  // Permite ingresar nombres con espacios
    nuevoProducto->precio = ingresarPrecio();  // Llamada a la función ingresarPrecio
    cout << "Ingrese la cantidad del producto: ";
    cin >> nuevoProducto->cantidad;

    // Insertar al inicio de la lista enlazada
    nuevoProducto->siguiente = lista;
    lista = nuevoProducto;
    cout << "Producto agregado con exito.\n";

    // Guardar el nuevo producto en el archivo
    guardarProducto(nuevoProducto);
    cin.ignore(); // Pausa para el usuario
}

// Función para leer el inventario desde el archivo y mostrarlo
void leerInventario() {
    ifstream archivo("INVENTARIO.txt");

    if (!archivo.is_open()) {
        cout << "No se pudo abrir el archivo INVENTARIO.txt.\n";
        return;
    }

    string codigo, nombreProducto;
    int cantidad;
    float precio;

    cout << "\n=== Inventario desde archivo ===\n";
    while (getline(archivo, codigo, ',') && getline(archivo, nombreProducto, ',') && archivo >> cantidad && archivo.ignore() && archivo >> precio) {
        archivo.ignore();  // Ignorar el salto de línea después de cada precio
        cout << "Codigo: " << codigo << "\n";
        cout << "Nombre: " << nombreProducto << "\n";
        cout << "Cantidad: " << cantidad << "\n";
        cout << "Precio: $" << precio << "\n";
        cout << "-------------------------\n";
    }

    archivo.close();
    cout << "Fin del inventario.\n";
    cin.ignore(); // Pausa para el usuario
}

void eliminarProducto(Producto*& lista) {
    cargarInventario(lista);    // Cargar productos al iniciar
    if (lista == nullptr) {
        cout << "No hay productos en el inventario.\n";
        return;
    }

    string codigo;
    cout << "Ingrese el código del producto que desea eliminar: ";
    cin >> codigo;

    Producto* actual = lista;
    Producto* anterior = nullptr;
    bool encontrado = false;

    while (actual != nullptr) {
        if (actual->codigo == codigo) {
            // Si el producto está en el inicio de la lista
            if (anterior == nullptr) {
                lista = actual->siguiente;
            } else {
                // Si el producto está en medio o final de la lista
                anterior->siguiente = actual->siguiente;
            }

            delete actual;
            encontrado = true;
            cout << "Producto eliminado con éxito.\n";
            break;
        }
        anterior = actual;
        actual = actual->siguiente;
    }

    if (!encontrado) {
        cout << "Producto no encontrado.\n";
        return;
    }

    // Guardar los productos restantes en el archivo después de la eliminación
    ofstream archivo("INVENTARIO.txt", ios::trunc);  // Usar ios::trunc para asegurarse de sobreescribir el archivo

    if (!archivo.is_open()) {
        cout << "Ocurrió un error al abrir el archivo INVENTARIO.txt.\n";
        return;
    }

    Producto* temp = lista;
    bool esPrimero = true;  // Usamos esta bandera para evitar saltos de línea innecesarios

    while (temp != nullptr) {
        if (!esPrimero) {
            archivo << "\n";  // Solo agregar salto de línea si no es el primer producto
        }
        archivo << temp->codigo << ","
                << temp->nombreProducto << ","
                << temp->cantidad << ","
                << temp->precio;
        temp = temp->siguiente;
        esPrimero = false;  // Después de la primera iteración, permitimos los saltos de línea
    }

    archivo.close();
    cout << "Inventario actualizado exitosamente.\n";
    cin.ignore();  // Pausa para el usuario
}



// Modificar stock de un producto
void modificarStock(Producto*& lista) {
	cargarInventario(lista);    // Cargar productos al iniciar
    if (lista == nullptr) {
        cout << "No hay productos en el inventario.\n";
        return;
    }

    cargarInventario(lista);  // Cargar la lista desde el archivo

    string codigo;
    cout << "Ingrese el código del producto cuyo stock desea modificar: ";
    cin >> codigo;

    Producto* actual = lista;
    bool encontrado = false;

    while (actual != nullptr) {
        if (actual->codigo == codigo) {
            cout << "Producto encontrado. Ingrese la nueva cantidad: ";
            cin >> actual->cantidad;
            encontrado = true;
            break;
        }
        actual = actual->siguiente;
    }

    if (encontrado) {
        // Modificar el archivo directamente
        ifstream archivoEntrada("INVENTARIO.txt");
        ofstream archivoTemporal("TEMPORAL.txt"); // Archivo temporal para escribir los cambios

        if (!archivoEntrada.is_open() || !archivoTemporal.is_open()) {
            cout << "No se pudo abrir los archivos para modificar el stock.\n";
            return;
        }

        string codigoProducto, nombreProducto;
        int cantidad;
        float precio;

        // Leer el archivo original y escribir los datos al archivo temporal
        while (getline(archivoEntrada, codigoProducto, ',') &&
               getline(archivoEntrada, nombreProducto, ',') &&
               archivoEntrada >> cantidad &&
               archivoEntrada.ignore() && archivoEntrada >> precio) {

            archivoEntrada.ignore(); // Ignorar salto de línea

            if (codigoProducto == codigo) {
                // Actualizar la cantidad del producto si coincide con el código
                archivoTemporal << codigoProducto << ","
                                << nombreProducto << ","
                                << actual->cantidad << ","
                                << precio << "\n";
            } else {
                // Escribir el producto sin cambios
                archivoTemporal << codigoProducto << ","
                                << nombreProducto << ","
                                << cantidad << ","
                                << precio << "\n";
            }
        }
        // Cerrar los archivos
        archivoEntrada.close();
        archivoTemporal.close();

        // Eliminar el archivo original y renombrar el temporal
        remove("INVENTARIO.txt");
        rename("TEMPORAL.txt", "INVENTARIO.txt");

        cout << "Stock modificado con éxito y archivo actualizado.\n";
    } else {
        cout << "Producto no encontrado.\n";
    }
}
void registrarVenta(Producto*& lista) {
    cargarInventario(lista);
    string codigo;
    int cantidadVendida;
    bool encontrado = false;

    // Solicitar el código del producto
    cout << "Ingrese el codigo del producto que desea vender: ";
    cin >> codigo;
    codigo = trim(codigo);  // Limpiar espacios antes y después del código ingresado

    // Buscar el producto en el inventario
    Producto* actual = lista;
    while (actual != nullptr) {
        if (trim(actual->codigo) == codigo) {  // Limpiar el código del inventario antes de comparar
            encontrado = true;
            // Verificar si hay suficiente cantidad en el inventario
            cout << "Nombre del producto: " << actual->nombreProducto << endl;
            cout << "Cantidad disponible: " << actual->cantidad << endl;
            cout << "Ingrese la cantidad a vender: ";

            while (!(cin >> cantidadVendida) || cantidadVendida <= 0) {
                cout << "Cantidad no valida. Intente de nuevo: ";
                cin.clear();
                cin.ignore(numeric_limits<streamsize>::max(), '\n');
            }

            if (cantidadVendida > actual->cantidad) {
                cout << "No hay suficiente stock disponible." << endl;
            } else {
                // Actualizar la cantidad en el inventario
                actual->cantidad -= cantidadVendida;

                // Registrar la venta en un archivo
                ofstream archivoVentas("VENTAS.txt", ios::app);  // Abrir archivo en modo agregar

                if (archivoVentas.is_open()) {
                    // Calcular el total de la venta (cantidad * precio)
                    float totalVenta = cantidadVendida * actual->precio;
                    archivoVentas << actual->codigo << ", "
                                  << actual->nombreProducto << ", "
                                  << cantidadVendida << ", "
                                  << totalVenta << "\n";
                    archivoVentas.close();
                    cout << "Venta registrada con exito. Stock actualizado." << endl;
                } else {
                    cout << "Error al abrir el archivo de ventas." << endl;
                }

                // Actualizar el archivo INVENTARIO.txt con la nueva cantidad de productos
                ofstream archivoInventario("INVENTARIO.txt", ios::trunc);  // Usar ios::trunc para sobrescribir

                if (!archivoInventario.is_open()) {
                    cout << "No se pudo abrir el archivo INVENTARIO.txt.\n";
                    return;
                }

                Producto* temp = lista;
                while (temp != nullptr) {
                    archivoInventario << temp->codigo << ","
                                      << temp->nombreProducto << ","
                                      << temp->cantidad << ","
                                      << temp->precio << "\n";
                    temp = temp->siguiente;
                }

                archivoInventario.close();  // Cerrar el archivo
            }
            break;
        }
        actual = actual->siguiente;
    }

    if (!encontrado) {
        cout << "Producto no encontrado." << endl;
    }

    cin.ignore(); // Pausa para el usuario
}

// Función para ver las ventas registradas
void verVentas() {
    ifstream archivoVentas("VENTAS.txt");

    if (!archivoVentas.is_open()) {
        cout << "No se pudo abrir el archivo de ventas.\n";
        return;
    }

    string linea;
    string codigo, nombreProducto;
    int cantidadVendida;

    cout << "\n=== Ventas registradas ===\n";
    while (getline(archivoVentas, linea)) {
        stringstream ss(linea);
        getline(ss, codigo, ',');
        getline(ss, nombreProducto, ',');
        ss >> cantidadVendida;
        cout << "Código: " << codigo << "\n";
        cout << "Nombre: " << nombreProducto << "\n";
        cout << "Cantidad vendida: " << cantidadVendida << "\n";
        cout << "-------------------------\n";
    }

    archivoVentas.close();
    cout << "Fin de las ventas registradas.\n";
    cin.ignore(); // Pausa para el usuario
}

// Función para mostrar el menú del empleado
void menu_empleado(Producto*& lista) {
    system("cls");
    system("color 6");
    int opcion;
    do {
       posicion(7, 5); cout << "\t\t **********************";
        posicion(7, 6); cout << "\t\t ||     Bienvenido   ||";
        posicion(7, 7); cout << "\t\t ||Menu de Opciones: ||";
        posicion(7, 8); cout << "\t\t ||Elija una opcion: ||";
        posicion(7, 9); cout << "\t\t **********************";
        posicion(7, 10);cout << "\t  =============================================================" << endl;
        posicion(7, 11);cout << "\t  || 1.VENDER			                             ||" << endl;
        posicion(7, 12);cout << "\t  || 2.MONSTRAR PRODUCTOS			             ||" << endl;
        posicion(7, 13);cout << "\t  || 3. Salir                                                ||" << endl;
        posicion(7, 14);cout << "\t  ============================" << endl;
        posicion(7, 15);cout << "\t  ||Ingrese la opcion:      ||" << endl;
        posicion(33, 15);
		 do {
            cin >> opcion;
            if (cin.fail() || opcion < 1 || opcion > 3) {
                cin.clear(); // Limpiar el estado de error
                cin.ignore(numeric_limits<streamsize>::max(), '\n'); // Limpiar el buffer de entrada
                posicion(1, 25);cout << "ERROR: Opcion no valida, precione una tecla para volver a intentar." << endl;
                system("pause");
                posicion(1, 25);cout<<"                                                                                                                                                                                  ";
                posicion(33, 15);
            }
        } while (opcion < 1 || opcion > 3);
        switch (opcion) {
            case 1:
            	system("cls");
                registrarVenta(lista);
                system("pause");
                break;
            case 2:
            	system("cls");
                leerInventario();
                system("pause");
                break;
            case 3:
            	system("cls");
                liberarLista(lista);
                cout << "Saliendo del menu del Empleado";
                system("pause");
                break;
        }
        system("cls");
    } while (opcion != 3);
}
void menu_admin(Producto*& lista) {
    system("cls");
    system("color 6");
    int opcion;
    do {
        posicion(7, 5); cout << "\t\t **********************";
        posicion(7, 6); cout << "\t\t ||     Bienvenido   ||";
        posicion(7, 7); cout << "\t\t ||Menu de Opciones: ||";
        posicion(7, 8); cout << "\t\t ||Elija una opcion: ||";
        posicion(7, 9); cout << "\t\t **********************";
        posicion(7, 10); cout << "\t  =============================================================";
        posicion(7, 11); cout << "\t  || 1. Ingresar un nuevo producto                           ||";
        posicion(7, 12); cout << "\t  || 2. Eliminar producto                                    ||";
        posicion(7, 13); cout << "\t  || 3. Modificar stock                                      ||";
        posicion(7, 14); cout << "\t  || 4. Ver lista de productos                               ||";
        posicion(7, 15); cout << "\t  || 5. Ver ventas registradas                               ||";
        posicion(7, 16); cout << "\t  || 6. Salir                                                ||";
        posicion(7, 17); cout << "\t  ============================";
        posicion(7, 18); cout << "\t  ||Ingrese la opcion:      ||";
        posicion(33, 18);
        cout.flush();
         do {
            cin >> opcion;
            if (cin.fail() || opcion < 1 || opcion > 6) {
                cin.clear(); // Limpiar el estado de error
                cin.ignore(numeric_limits<streamsize>::max(), '\n'); // Limpiar el buffer de entrada
                posicion(1, 25);cout << "ERROR: Opcion no valida, precione una tecla para volver a intentar." << endl;
                system("pause");
                posicion(1, 25);cout<<"                                                                                                                                                                                  ";
                posicion(33, 18);
            }
        } while (opcion < 1 || opcion > 6);

        switch (opcion) {
            case 1:
            	system("cls");
                agregarProducto(lista);
                system("pause");
                system("cls");
                break;
            case 2:
            	system("cls");
                eliminarProducto(lista);
                system("pause");
                system("cls");
                break;
            case 3:
            	system("cls");
                modificarStock(lista);
                system("pause");
                system("cls");
                break;
            case 4:
            	system("cls");
                leerInventario();
                system("pause");
                system("cls");
                break;
            case 5:
            	system("cls");
                verVentas();
                system("pause");
                system("cls");
                break;
            case 6:
            	system("cls");
                liberarLista(lista);
                cout << "Saliendo del menu de administrador..." << endl;
                system("pause");
                system("cls");
                break;
        }
        system("cls");
    } while (opcion != 6);
}



// Función de opciones del menú principal
void opcion_principal(int opcion, Producto*& lista) {
    string acceso;
    switch (opcion) {
        case 1:
            system("cls");
            do {
                cout << "Ingrese la contrasenia de administrador: ";
                cin >> acceso;
                if (acceso != "admin2019") {
                    cout << "Contrasenia incorrecta. Intentalo de nuevo." << endl;
                }
            } while (acceso != "admin2019");
            system("cls");
            cout << "Bienvenido, administrador. Por favor, presione una tecla." << endl;
            system("pause");
            menu_admin(lista);
            break;

        case 2:
            system("cls");
            do {
                cout << "Ingrese el usuario: ";
                cin >> acceso;
                if (acceso != "Empleado") {
                    cout << "Usuario incorrecto. Intentalo de nuevo." << endl;
                }
            } while (acceso != "Empleado");
            do {
                cout << "Ingrese la contrasenia de empleado: ";
                cin >> acceso;
                if (acceso != "12345") {
                    cout << "Contrasenia incorrecta. Intentalo de nuevo." << endl;
                }
            } while (acceso != "12345");
            system("cls");
            cout << "Bienvenido, empleado. Por favor, presione una tecla." << endl;
            system("pause");
        	menu_empleado(lista);
            break;

        case 3:
            system("cls");
            cout << "Saliendo del programa..." << endl;
            break;
    }
}

// Menú del programa principal
void menu_principal() {
    system("cls");
    system("color 6");
    int opcion;
    Producto* lista = nullptr; // Lista de productos inicializada como vacía
    do {
        posicion(7, 5); cout << "\t\t **********************";
        posicion(7, 6); cout << "\t\t ||     Bienvenido   ||";
        posicion(7, 7); cout << "\t\t ||Menu de Opciones: ||";
        posicion(7, 8); cout << "\t\t ||Elija una opcion: ||";
        posicion(7, 9); cout << "\t\t **********************";
        posicion(7, 10); cout << "\t  =============================================================";
        posicion(7, 11); cout << "\t  || 1. Ingresar como administrador		             ||";
        posicion(7, 12); cout << "\t  || 2. Ingresar como empleado                               ||";
        posicion(7, 13); cout << "\t  || 3. Salir del programa                                   ||";
        posicion(10, 17); cout << "\t  ============================";
        posicion(10, 18); cout << "\t  ||Ingrese la opcion:      ||";
        posicion(40, 18);
        cout.flush();
       do {
            cin >> opcion;
            if (cin.fail() || opcion < 1 || opcion > 3) {
                cin.clear(); // Limpiar el estado de error
                cin.ignore(numeric_limits<streamsize>::max(), '\n'); // Limpiar el buffer de entrada
                posicion(1, 25);cout << "ERROR: Opcion no valida, precione una tecla para volver a intentar." << endl;
                system("pause");
                posicion(1, 25);cout<<"                                                                                                                                                                                  ";
                posicion(40, 18);
            }
        } while (opcion < 1 || opcion > 3);

        opcion_principal(opcion, lista);
    } while (opcion != 3);
}

int main() {
    Producto* lista = nullptr;
    menu_principal();
    return 0;
}
