# include <stdio.h>
# include <iostream>
# include <stdlib.h>
# include <string.h>
#include <windows.h>
#include <locale.h>
using namespace std;
struct Fecha{
	int dia,mes,anio;
};
struct Productos{
	int codigo;
	char descripcion[50];
	float precio;
	int cantidadTotal;
	Productos *sig;
};
struct Ingresos{
	struct Fecha fingresos;
	float subtotal,iva,total,precio;
	int codigo;
	int cantidad;
	int cantidadTotal;
	long int codigoingresos;
	Ingresos *sig;
};
struct Egresos{
	struct Fecha fegresos;
	float subtotal,iva,total,precio;
	int codigo;
	int cantidad;
	int cantidadTotal;
	long int codigoegresos;
	Egresos *sig;	
};
struct detalleIngresos{
	struct Fecha fingresos;
	float subtotal,iva,total,precio;
	int codigo;
	int cantidad;
	int cantidadTotal;
	long int codigoingresos;
	int sumatotal;
	detalleIngresos *sig;
};
struct detalleEgresos{
	struct Fecha fegresos;
	float subtotal,iva,total,precio;
	int codigo;
	int cantidad;
	int cantidadTotal;
	long int codigoegresos;
	int sumatotal;
	detalleEgresos *sig;
};
void gotoxy(int x, int y) {
    COORD coord;
    coord.X = x;
    coord.Y = y;
    SetConsoleCursorPosition(GetStdHandle(STD_OUTPUT_HANDLE), coord);
}
void clearScreen() {
    system("cls"); 
}
void help_context1(void){
	

 cout<<endl<<"Esta funcion le permite Ingresar productos ";
 cout<<endl<<".................";
 system("PAUSE");
}

void help_context2(void){ 

 cout<<endl<<"Esta opcion le permite acceder a los productos existente  ";
 cout<<endl<<"......................";
 system("PAUSE");
}
void help_context3(void){ 

 cout<<endl<<"Desea hacer algo más con el inventario  ";
 cout<<endl<<"......................";
 system("PAUSE");
}
void help_context4(void){ 

 cout<<endl<<"Sucursal creada exitosamente,Desea hacer algo más. ";
 cout<<endl<<"......................";
 system("PAUSE");
}

//funciones principales
void ejecutarPrograma(Productos *&cabezap,detalleIngresos *&cabezai,Ingresos *&cabezai2,
					  detalleEgresos*&cabezae,Egresos *&cabezae2);
int cargarNucleos(char nombreArchivo, char nucleos[], int maxNucleos);
void manejarComando(char frase, 
                    char nucleosImpresion[], int numNucleosImpresion, 
                    char nucleosDetalles[], int numNucleosDetalles, 
                    char nucleosEgresos[], int numNucleosEgresos, 
                    char nucleosDetallesEgresos[], int numNucleosDetallesEgresos,Productos *&cabezap,detalleIngresos *&cabezai,Ingresos *&cabezai2,
					detalleEgresos*&cabezae,Egresos *&cabezae2);
 bool contieneNucleo(char frase, char nucleos[], int numNucleos);                  
	
            
void Funcionpln_IngresoProductos(Productos *&cabezap);
void Funcionpln_Ingresos(detalleIngresos *&cabezai,Productos *&cabezap,Ingresos *&cabezai2);
//Extras
void Convertir_Minusculas(char *str);
//Producto
void Menu_Productos(Productos *&cabezap);
void Insertar_Productos(Productos *&cabezap);
void Imprimirlista_Productos(Productos *cabezap);
void limpiar(Productos *&cabezap);
void Ordenar_Productos(Productos *&cabezap);
void Borrar_Producto(Productos *&cabezap, int codigo);
void Actualizar_Producto(Productos *&cabezap, int codigo);
//Ingresos sin detalle
void Menu_Ingresos(detalleIngresos *&cabezai, Productos *&cabezap, Ingresos *&cabezai2);//Submenu opcion 2 ingresos
void Insertar_Ingresos(detalleIngresos *&cabezai, Productos *&cabezap);
void limpiar_Ingresos(detalleIngresos *&cabezai);
void Ordenar_Ingresos(detalleIngresos *&cabezai);
void Imprimirlista_Ingresos(detalleIngresos *cabezai, Productos *cabezap);
void actualizarCantidad(Productos *&cabezap);
//Ingresos con detalle
void Ordenar_DetalleIngresos(Ingresos *&cabezai);
void Insertar_DetalleIngresos( Ingresos*& cabezai2, Productos*& cabezap, detalleIngresos*& cabezai );
void Imprimirlista_DetalleIngresos(Ingresos *cabezai2, Productos *cabezap);
//Egresos
void Menu_Egresos(detalleEgresos*&cabezae,Productos*&cabezap,Egresos *&cabezae2);
void Insertar_Egresos(detalleEgresos *&cabezae, Productos *&cabezap);
void Ordenar_Egresos(detalleEgresos *&cabezae);
void actualizarCantidadEgresos(Productos *&cabezap);
void Imprimirlista_Egresos(detalleEgresos *cabezae, Productos *cabezap);
//Egresos con detalle
void Insertar_DetalleEgresos(Egresos *&cabezae2, Productos *&cabezap, detalleEgresos *&cabezae);
void Imprimirlista_DetalleEgresos(Egresos *cabezae2, Productos *cabezap);
void Funcionpln_Ingresos(Productos *&cabezap,detalleIngresos *&cabezai);

int main() {
    setlocale(LC_ALL, "");
    Productos* cabezap = NULL;
    detalleIngresos* cabezai = NULL;
    Ingresos* cabezai2 = NULL;
    detalleEgresos* cabezae = NULL;
    Egresos* cabezae2 = NULL;
  
	
    do {
    		
        ejecutarPrograma(cabezap, cabezai, cabezai2, cabezae, cabezae2);
        
       
    } while (1);

    return 0;
}


//PlN......................................................................................
bool contieneNucleo(const char* frase, char* nucleos[], int numNucleos) {
    for (int i = 0; i < numNucleos; i++) {
        if (strstr(frase, nucleos[i]) != NULL) {
            return true;
        }
    }
    return false;
}

void manejarComando(char* frase, char* nucleosImpresion[], int numNucleosImpresion, char* nucleosDetalles[],
    int numNucleosDetalles, char* nucleosEgresos[], int numNucleosEgresos, char* nucleosDetallesEgresos[], int numNucleosDetallesEgresos,
    Productos*& cabezap, detalleIngresos*& cabezai, Ingresos*& cabezai2, detalleEgresos*& cabezae, Egresos*& cabezae2) {

		    Ordenar_Egresos(cabezae);
		    Ordenar_Ingresos(cabezai);
		    

    if (strstr(frase, "prod") != NULL) {
        if (contieneNucleo(frase, nucleosImpresion, numNucleosImpresion)) {
            cout << "Ejecutando comando: Imprimir productos" << endl;
            Ordenar_Productos(cabezap);
            Imprimirlista_Productos(cabezap);
        } else {
            cout << "Ejecutando comando: Insertar productos" << endl;
            Ordenar_Productos(cabezap);
            Funcionpln_IngresoProductos(cabezap);
        }
    } else if (strstr(frase, "ingr") != NULL) {
        if (contieneNucleo(frase, nucleosDetalles, numNucleosDetalles)) {
        			   
            cout << "Ejecutando comando: Imprimir detalles de ingresos" << endl;
             Ordenar_Ingresos(cabezai);
            Insertar_DetalleIngresos(cabezai2, cabezap, cabezai);
            Imprimirlista_DetalleIngresos(cabezai2, cabezap);
        } else if (contieneNucleo(frase, nucleosImpresion, numNucleosImpresion)) {
        			    Ordenar_Ingresos(cabezai);
            cout << "Ejecutando comando: Imprimir ingresos" << endl;
            Ordenar_Ingresos(cabezai);
            Imprimirlista_Ingresos(cabezai, cabezap);
        } else {
        	
            cout << "Ejecutando comando: Insertar ingresos" << endl;
         		    
		Funcionpln_Ingresos(cabezap,cabezai);
            
            
        }
    } else if (strstr(frase, "egre") != NULL || strstr(frase, "sac") != NULL || strstr(frase, "sal") != NULL) {
        if (contieneNucleo(frase, nucleosDetallesEgresos, numNucleosDetallesEgresos)) {
            cout << "Ejecutando comando: Imprimir detalles de egresos" << endl;
            Insertar_DetalleEgresos(cabezae2, cabezap, cabezae);
            Imprimirlista_DetalleEgresos(cabezae2, cabezap);
        } else if (contieneNucleo(frase, nucleosEgresos, numNucleosEgresos)) {
            cout << "Ejecutando comando: Imprimir egresos" << endl;
            Insertar_Egresos(cabezae, cabezap);
            Ordenar_Egresos(cabezae);
            actualizarCantidadEgresos(cabezap);
            Ordenar_Egresos(cabezae);
            Imprimirlista_Egresos(cabezae, cabezap);
        } else {
            cout << "Ejecutando comando: Insertar egresos" << endl;
            Insertar_Egresos(cabezae, cabezap);
            Ordenar_Egresos(cabezae);
            actualizarCantidadEgresos(cabezap);
        }
    } else {
        cout << "Continue." << endl;
    }
}

int cargarNucleos(const char* nombreArchivo, char* nucleos[], int maxNucleos) {
    FILE* archivo = fopen(nombreArchivo, "r");
    if (!archivo) {
        cerr << "Error al abrir el archivo " << nombreArchivo << endl;
        return -1;
    }

    int numNucleos = 0;
    char buffer[256];
    while (fgets(buffer, sizeof(buffer), archivo) && numNucleos < maxNucleos) {
        buffer[strcspn(buffer, "\n")] = '\0';
        nucleos[numNucleos] = new char[strlen(buffer) + 1];
        if (nucleos[numNucleos] == NULL) {
            cerr << "Error al asignar memoria" << endl;
            fclose(archivo);
            return -1;
        }
        strcpy(nucleos[numNucleos], buffer);
        numNucleos++;
    }
    fclose(archivo);
    return numNucleos;
}

void ejecutarPrograma(Productos*& cabezap, detalleIngresos*& cabezai, Ingresos*& cabezai2, detalleEgresos*& cabezae, Egresos*& cabezae2) {
    


    char archivoNucleos[] = "nucleos.txt";
    char archivoNucleosImpresion[] = "nucleo_impresion.txt";
    char archivoNucleosDetalles[] = "nucleo_detalle.txt";
    char archivoNucleosEgresos[] = "nucleo_egreso.txt";
    char archivoNucleosDetallesEgresos[] = "nucleo_detalle_egreso.txt";
    

    char* nucleos[100];
    char* nucleosImpresion[100];
    char* nucleosDetalles[100];
    char* nucleosEgresos[100];
    char* nucleosDetallesEgresos[100];

    int numNucleos = cargarNucleos(archivoNucleos, nucleos, 100);
    int numNucleosImpresion = cargarNucleos(archivoNucleosImpresion, nucleosImpresion, 100);
    int numNucleosDetalles = cargarNucleos(archivoNucleosDetalles, nucleosDetalles, 100);
    int numNucleosEgresos = cargarNucleos(archivoNucleosEgresos, nucleosEgresos, 100);
    int numNucleosDetallesEgresos = cargarNucleos(archivoNucleosDetallesEgresos, nucleosDetallesEgresos, 100);

    if (numNucleos < 0 || numNucleosImpresion < 0 || numNucleosDetalles < 0 || numNucleosEgresos < 0 || numNucleosDetallesEgresos < 0) {
        cerr << "Error al cargar los núcleos de archivos." << endl;
        return;
    }

    char frase[256];
    cout << "Por favor, ingrese una frase: ";
    fgets(frase, sizeof(frase), stdin);
    fflush(stdin);
    frase[strcspn(frase, "\n")] = '\0';
	
    Convertir_Minusculas(frase);

    cout << "Frase ingresada: " << frase << endl;
	fflush(stdin);
    manejarComando(frase, nucleosImpresion, numNucleosImpresion, nucleosDetalles,
        numNucleosDetalles, nucleosEgresos, numNucleosEgresos,
        nucleosDetallesEgresos, numNucleosDetallesEgresos, cabezap, cabezai, cabezai2, cabezae, cabezae2);

    for (int i = 0; i < numNucleos; i++) {
        delete[] nucleos[i];
    }
    for (int i = 0; i < numNucleosImpresion; i++) {
        delete[] nucleosImpresion[i];
    }
    for (int i = 0; i < numNucleosDetalles; i++) {
        delete[] nucleosDetalles[i];
    }
    for (int i = 0; i < numNucleosEgresos; i++) {
        delete[] nucleosEgresos[i];
    }
    for (int i = 0; i < numNucleosDetallesEgresos; i++) {
        delete[] nucleosDetallesEgresos[i];
    }
}

//funciones extras-----------------------------
void Convertir_Minusculas(char *frase) {
    while (*frase) {
        *frase = tolower(*frase);
        frase++;
    }
}


//Ingreso y guardado de productos.........................................................................................................
void Funcionpln_IngresoProductos(Productos *&cabezap){
	
	Insertar_Productos(cabezap);
	Ordenar_Productos(cabezap);
	
}
void Funcionpln_Ingresos(Productos *&cabezap,detalleIngresos *&cabezai){

	Insertar_Ingresos(cabezai,cabezap);
            Ordenar_Ingresos(cabezai);
            actualizarCantidad(cabezap);
	
}

void actualizarCantidad(Productos*& cabezap) {
    FILE *productos;
    Productos *corredor = cabezap;   
    productos = fopen("Productos.txt", "w");
    
    if (productos == NULL) {
        cout<<"Error al abrir el archivo !\n";
        return;
    }
     
    while (corredor != NULL) {
        fprintf(productos, "%d %s %.2f %d\n", corredor->codigo, corredor->descripcion, corredor->precio, corredor->cantidadTotal);
        corredor = corredor->sig;
    }
    fclose(productos);
}
void Insertar_Productos(Productos *&cabezap) {
    FILE *archivo;
    int codigo;
    char descripcion[50]; 
    float precio;
    int cantidadTotal = 0;
    
    archivo = fopen("Productos.txt", "a");
    
    if (archivo == NULL) {
        printf("Error opening file!\n");
        return;
    }
    printf("Ingrese codigo: ");
    scanf("%d", &codigo);
    
    Productos *aux = cabezap;
    while (aux != NULL) {
        if (aux->codigo == codigo) {
            printf("El codigo ya existe\n");
            fclose(archivo);
            return;
        }
        aux = aux->sig;
    }
    
    printf("Ingrese nombre del producto: ");
    scanf("%s", descripcion);
    
    printf("Ingrese precio del producto: ");
    scanf("%f", &precio);
    
    fprintf(archivo, "%d %s %.2f %d\n", codigo, descripcion, precio, cantidadTotal);
    
    fclose(archivo);
}
void limpiar(Productos *&cabezap) {
    Productos *borrar;
    while (cabezap != NULL) {
        borrar = cabezap;
        cabezap = cabezap->sig;
        delete borrar;
    }
}
void Ordenar_Productos(Productos *&cabezap) {
    limpiar(cabezap);  
    int codigo;
    char descripcion[50];
    float precio;
    int cantidadTotal;
    FILE *archivo = fopen("Productos.txt", "a+");
    
    if (archivo == NULL) {
        printf("Error opening file!\n");
        return;
    }

    while (fscanf(archivo, "%d %s %f %d", &codigo, descripcion, &precio, &cantidadTotal) != EOF) {
        Productos* nuevo = new(Productos); 
        nuevo->codigo = codigo;
        strcpy(nuevo->descripcion, descripcion);
        nuevo->precio = precio;
        nuevo->cantidadTotal = cantidadTotal;
        nuevo->sig = NULL;
        Productos* aux1 = cabezap;
        Productos* aux2 = NULL;
        while ((aux1 != NULL) && (aux1->codigo < codigo)) {
            aux2 = aux1;
            aux1 = aux1->sig;
        }
        
        if (aux2 == NULL) {
            nuevo->sig = cabezap;
            cabezap = nuevo;
        } else {
            aux2->sig = nuevo;
            nuevo->sig = aux1;
        }
    }
    fclose(archivo);
}

void Imprimirlista_Productos(Productos *cabezap){
	printf("\t\t\t\t\tLista de Productos\n");
	cout << "\n============================================================================================";
	printf("\n|| Codigo de Producto |        Descripcion y Precio/unidad    | Cantidad total disponible ||  ");
	cout << "\n============================================================================================" << endl;
	if(cabezap==NULL){
		cout<<"\t\t\t\t------------La lista esta vacia------------"<<endl;
	}
	
	while(cabezap!=NULL){
		cout<<"\t"<<cabezap->codigo<<"\t\t\t"<<   cabezap->descripcion    <<" --> "<<"$"<<cabezap->precio<<"\t\t\t"<<cabezap->cantidadTotal<<endl;
		cout<<"____________________________________________________________________________________________"<<endl;
		cabezap=cabezap->sig;
}

}
void Borrar_Producto(Productos *&cabezap, int codigo){
    Productos *anterior = NULL;
    Productos *actual = cabezap;
    bool encontrado = false;

    while (actual != NULL) {
        if (actual->codigo == codigo) {
            encontrado = true;
            break;
        }
        anterior = actual;
        actual = actual->sig;
    }

    if (!encontrado) {
        cout << "Producto con codigo " << codigo << " no encontrado." << endl;
        return;
    }


    if (anterior == NULL) {
        cabezap = actual->sig;
    } else {
        anterior->sig = actual->sig;
    }

    delete actual;

    FILE *archivo;
    archivo = fopen("Productos.txt", "w");
    if (archivo == NULL) {
        cout << "Error al abrir el archivo!" << endl;
        return;
    }

    Productos *temp = cabezap;
    while (temp != NULL) {
        fprintf(archivo, "%d %s %.2f %d\n", temp->codigo, temp->descripcion, temp->precio, temp->cantidadTotal);
        temp = temp->sig;
    }

    fclose(archivo);
    cout << "Producto con codigo " << codigo << " ha sido borrado exitosamente." << endl;
}
void Actualizar_Producto(Productos *&cabezap, int codigo) {
    Productos *actual = cabezap;
    bool encontrado = false;

    while (actual != NULL) {
        if (actual->codigo == codigo) {
            encontrado = true;
            break;
        }
        actual = actual->sig;
    }

    if (!encontrado) {
        cout << "Producto con codigo " << codigo << " no encontrado." << endl;
        return;
    }

    int nuevoCodigo;
    char nuevaDescripcion[50];
    float nuevoPrecio;

    cout << "Ingrese el nuevo codigo: ";
    cin >> nuevoCodigo;

    cout << "Ingrese el nuevo nombre del producto: ";
    cin >> nuevaDescripcion;

    cout << "Ingrese el nuevo precio del producto: ";
    cin >> nuevoPrecio;

    actual->codigo = nuevoCodigo;
    strcpy(actual->descripcion, nuevaDescripcion);
    actual->precio = nuevoPrecio;

    FILE *archivo;
    archivo = fopen("Productos.txt", "w");
    if (archivo == NULL) {
        cout << "Error al abrir el archivo!" << endl;
        return;
    }

    Productos *temp = cabezap;
    while (temp != NULL) {
        fprintf(archivo, "%d %s %.2f %d\n", temp->codigo, temp->descripcion, temp->precio, temp->cantidadTotal);
        temp = temp->sig;
    }

    fclose(archivo);
    cout << "Producto con codigo " << codigo << " ha sido actualizado exitosamente." << endl;
}


//Ingresos sin Detalles.........................................................................................................

void Imprimirlista_Ingresos(detalleIngresos *cabezai, Productos *cabezap) {
    cout << "\tLista de Ingresos de productos\n";


    if (cabezai == NULL || cabezap == NULL) {
        cout << "\t\t\t\t\t\t\t------------La lista esta vacia------------" << endl;
        return;
    }

    detalleIngresos *auxi = cabezai;
    while (auxi != NULL) {
		cout<<"......................................................................"<<endl;
        cout <<"Codigo de ingreso: "<<auxi->codigoingresos << "   " <<"Fecha de ingreso: "<< auxi->fingresos.dia << "/" << auxi->fingresos.mes << "/" << auxi->fingresos.anio << "\n";
		    cout << "=====================================================================";
    		cout << "\n|| Codigo de Producto | Descripcion | Precio | Cantidad | Subtotal ||";
    		cout << "\n=====================================================================" << endl;
        detalleIngresos *auxi2 = cabezai;
        while (auxi2 != NULL) {
            if (auxi2->codigoingresos == auxi->codigoingresos) {
               
                Productos *auxp = cabezap;
                while (auxp != NULL) {
                    if (auxp->codigo == auxi2->codigo) {
                        cout << "     " << auxp->codigo << "           " << auxp->descripcion << "         " << auxp->precio << "        " << auxi2->cantidad << "      " << auxi2->total << "\n";
                        cout<<"--------------------------------------------------------------------"<<endl;
						break;
                    }
                    auxp = auxp->sig;
                }
            }
            auxi2 = auxi2->sig;
        }

        cout << endl;
        detalleIngresos *auxi3 = auxi->sig;
        while (auxi3 != NULL && auxi3->codigoingresos == auxi->codigoingresos) {
            auxi = auxi3;
            auxi3 = auxi3->sig;
        }
        auxi = auxi->sig;}
		}
		
void Insertar_Ingresos(detalleIngresos *&cabezai, Productos *&cabezap) {
    FILE *archivo;
    archivo = fopen("Detalles Ingresos.txt", "a");  

    if (archivo == NULL) {
        printf("Error opening file!\n");
        return;
    }

    char opcion;
    detalleIngresos *cabezai2 =new(detalleIngresos);  

    printf("Ingrese la fecha del ingreso:\n");
    printf("Ingrese el dia:\t");
    scanf("%d", &cabezai2->fingresos.dia);
    printf("Ingrese el mes:\t");
    scanf("%d", &cabezai2->fingresos.mes);
    printf("Ingrese el anio:\t");
    scanf("%d", &cabezai2->fingresos.anio);
    
    cabezai2->codigoingresos = ((cabezai2->fingresos.anio * 10000) + cabezai2->fingresos.mes * 100 + cabezai2->fingresos.dia);

    float sumatotal = 0;
    float ivatotal = 0;
    float totalfinal = 0;

    do {
        printf("Ingrese el codigo del producto que se ingresara: ");
        scanf("%d", &cabezai2->codigo);

        Productos *corredor = cabezap;
        bool encontrado = false;

        while (corredor != NULL) {
            if (corredor->codigo == cabezai2->codigo) {
                cabezai2->precio = corredor->precio;
                encontrado = true;
                break;
            }
            corredor = corredor->sig;
        }

        if (!encontrado) {
            printf("El codigo del producto no se encuentra en la lista.\n");
            continue;
        }

        printf("\t\t-------------------------------------------------------------------------------------\n");
        printf("\t\t\t\tProducto seleccionado: %s ------> Precio: %.2f\n", corredor->descripcion, cabezai2->precio);
        printf("\t\t-------------------------------------------------------------------------------------\n");

        printf("Cantidad a ingresar: ");
        scanf("%d", &cabezai2->cantidad);

        cabezai2->total = cabezai2->precio * cabezai2->cantidad;
        cabezai2->iva = cabezai2->total * 0.12;
        cabezai2->subtotal = cabezai2->total - cabezai2->iva;

        sumatotal += cabezai2->total; 
        ivatotal = sumatotal * 0.12;
        totalfinal = sumatotal + ivatotal;

        Productos *aux3 = cabezap;
        while (aux3 != NULL) {
            if (aux3->codigo == cabezai2->codigo) {
                aux3->cantidadTotal += cabezai2->cantidad;
                break;
            }
            aux3 = aux3->sig;
        }
        fprintf(archivo, "%ld %d %d %d %d %d %.2f\n", cabezai2->codigoingresos, cabezai2->codigo, cabezai2->fingresos.dia, cabezai2->fingresos.mes, cabezai2->fingresos.anio, cabezai2->cantidad, cabezai2->total);

        printf("¿Desea ingresar mas productos (s/n): ");
        scanf(" %c", &opcion);
    } while (opcion == 's' || opcion == 'S');

    printf("El Subtotal de los ingresos es: %.2f\n", sumatotal);
    printf("El iva es: %.2f\n", ivatotal);
    printf("El total es: %.2f\n", totalfinal);

    fclose(archivo);  
    free(cabezai2);   
}
void limpiar_Ingresos(detalleIngresos*& cabezai) {
    detalleIngresos *borrar;
    while (cabezai != NULL) {
        borrar = cabezai;
        cabezai = cabezai->sig;
        free(borrar); 
    }
}
void Ordenar_Ingresos(detalleIngresos *&cabezai) {
    limpiar_Ingresos(cabezai);  

    int codigoIngreso, codigopropio;
    float total;
    int cantidad;
    int dia, mes, anio;

    FILE *archivo = fopen("Detalles Ingresos.txt", "r");

    if (archivo == NULL) {
        printf("Error opening file!\n");
        return;
    }

    while (fscanf(archivo, "%d %d %d %d %d %d %f", &codigopropio, &codigoIngreso, &dia, &mes, &anio, &cantidad, &total) != EOF) {
        detalleIngresos* nuevo = new(detalleIngresos);  
        nuevo->codigoingresos = codigopropio;
        nuevo->codigo = codigoIngreso;
        nuevo->fingresos.dia = dia;
        nuevo->fingresos.mes = mes;
        nuevo->fingresos.anio = anio;
        nuevo->cantidad = cantidad;
        nuevo->total = total;
        nuevo->sig = NULL;

        
        detalleIngresos* aux1 = cabezai;
        detalleIngresos* aux2 = NULL;
        while ((aux1 != NULL) && (aux1->codigoingresos < codigopropio)) {
            aux2 = aux1;
            aux1 = aux1->sig;
        }

        if (aux2 == NULL) {
            nuevo->sig = cabezai;
            cabezai = nuevo;
        } else {
            aux2->sig = nuevo;
            nuevo->sig = aux1;
        }
    }
    fclose(archivo);
}
//Ingresos Detallados.......................................................................................................................
void Insertar_DetalleIngresos(Ingresos *&cabezai2, Productos *&cabezap, detalleIngresos *&cabezai) {
    detalleIngresos *aux = cabezai;
    

    FILE *archivo = fopen("Ingresos.txt", "w");
    if (archivo == NULL) {
        printf("Error opening file!\n");
        return;
    }

    while (aux != NULL) {
        Ingresos *nuevo = new(Ingresos);
        if (nuevo == NULL) {
            printf("Memory allocation failed!\n");
            fclose(archivo);
            return;
        }

        nuevo->codigoingresos = aux->codigoingresos;
        nuevo->codigo = aux->codigo;
        nuevo->fingresos = aux->fingresos;
        nuevo->cantidad = aux->cantidad;
        nuevo->cantidadTotal = aux->cantidadTotal;
        nuevo->sig = NULL;

     
        Productos *corredor = cabezap;
        while (corredor != NULL) {
            if (corredor->codigo == aux->codigo) {
                nuevo->subtotal = corredor->precio * aux->cantidad;
                nuevo->iva = nuevo->subtotal * 0.15;
                nuevo->total = nuevo->subtotal + nuevo->iva;
                break;
            }
            corredor = corredor->sig;
        }
        Productos *auxp = cabezap;
        while (auxp != NULL) {
            if (auxp->codigo == aux->codigo) {
                auxp->cantidadTotal += aux->cantidad;
                break;
            }
            auxp = auxp->sig;
        }
        if (cabezai2 == NULL) {
            cabezai2 = nuevo;
        } else {
            Ingresos *ultimo = cabezai2;
            while (ultimo->sig != NULL) {
                ultimo = ultimo->sig;
            }
            ultimo->sig = nuevo;
        }
        fprintf(archivo, "%ld %d %d %d %d %d %.2f %.2f %.2f\n", 
                aux->codigoingresos, aux->codigo, aux->fingresos.dia, aux->fingresos.mes, aux->fingresos.anio, 
                aux->cantidad, nuevo->subtotal, nuevo->iva, nuevo->total);
        detalleIngresos *borrar = aux;
        aux = aux->sig;
        free(borrar);
    }

    cabezai = NULL; 
    fclose(archivo); 
}
void Imprimirlista_DetalleIngresos(Ingresos *cabezai2, Productos *cabezap) {
    
    if (cabezai2 == NULL || cabezap == NULL) {
        cout << "\t\t\t\t\t\t\t------------La lista esta vacia------------" << endl;
        return;
    }

    for (Productos *auxp = cabezap; auxp != NULL; auxp = auxp->sig) {
        cout << "\n\n\n\tProducto: " << auxp->descripcion << " (Codigo: " << auxp->codigo << ")" << endl;
        cout << "____________________________________________________________________________________________________________________________________________________________" << endl;
        cout << "\n========================================================================================================================================================";
        cout << "\n|| Codigo de ingreso      |    Codigo P.   |    Descripcion/Precio  |    Fecha de ingreso  |   Cantidad ingresada |    Subtotal  |   Iva    |  Total  ||  ";
        cout << "\n========================================================================================================================================================" << endl;

        bool productosEncontrados = false;
        for (Ingresos *auxi = cabezai2; auxi != NULL; auxi = auxi->sig) {
            if (auxi->codigo == auxp->codigo) {
                cout << "\t" << auxi->codigoingresos << "\t\t" << auxi->codigo << "\t\t" << auxp->descripcion << "-->$" << auxp->precio << "\t          " << auxi->fingresos.dia << "/" << auxi->fingresos.mes << "/" << auxi->fingresos.anio << "\t\t   " << auxi->cantidad << "\t\t" << "$" << auxi->subtotal << "           " << "$" << auxi->iva << "    " << "$" << auxi->total  << endl;
               	cout<<"_____________________________________________________________________________________________________________________________________________________"<<endl;
                productosEncontrados = true;
            }
        }

        if (!productosEncontrados) {
            cout << "\t\t\t\t\t\t\t------------No se encontraron ingresos para este producto------------" << endl;
        }
    }
}
//Egresos sin detalle......................................................................................................................................
void Menu_Egresos(detalleEgresos*&cabezae,Productos*&cabezap,Egresos *&cabezae2){
	int eleccion;
	Ordenar_Egresos(cabezae);
	do{
		cout<<"\t\t\tSubmenu Egresos:"<<endl;
	cout<<"1.- Nuevo Egreso"<<endl;
	cout<<"2.- Imprimir el Egreso"<<endl;
	cout<<"3.- Mostrar el Egreso Detallado"<<endl;
	cout<<"4.- Actualizar el Egreso"<<endl;
	cout<<"5.- Borrar un egreso"<<endl;
	cout<<"6.- Regresar al menu"<<endl;
	cout<<"Ingrese la opcion:\t\t";
	cin>>eleccion;
	switch(eleccion){
		case 1:{
			
		Insertar_Egresos(cabezae,cabezap);
		Ordenar_Egresos(cabezae);
		actualizarCantidadEgresos(cabezap);

			system("pause");
			break;
		}
		case 2:{
		Ordenar_Egresos(cabezae);
		Imprimirlista_Egresos(cabezae,cabezap);
		
		system("pause");
			break;
		}
		case 3:{
			Insertar_DetalleEgresos(cabezae2,cabezap,cabezae);
			Imprimirlista_DetalleEgresos(cabezae2,cabezap);
			system("pause");
			break;
		}
		case 4:{
//			actualizarlistaEgresos(cabezap,cabezae);
			system("pause");
			break;
		}
		case 5:{
//		BorrarEgreso();
			system("pause");
			break;
		}
		case 6:{
			cout<<"Volviendo al menu inicial"<<endl;
			system("pause");
			break;
		}
		default:{
			cout<<"----Ingrese alguna de las 6 opciones----"<<endl;
			
			break;
		}
	}
	system("cls");
	}while(eleccion!=6);	
}
void actualizarCantidadEgresos(Productos *&cabezap) {
    FILE *productos = fopen("Productos.txt", "w");
    if (productos == NULL) {
        printf("Error opening file!\n");
        return;
    }

    Productos *corredor = cabezap;
    while (corredor != NULL) {
        fprintf(productos, "%d %s %.2f %d\n", corredor->codigo, corredor->descripcion, corredor->precio, corredor->cantidadTotal);
        corredor = corredor->sig;
    }
    fclose(productos);
}

void Imprimirlista_Egresos(detalleEgresos *cabezae, Productos *cabezap) {
    cout << "\tLista de Egresos de productos\n";
    
    if (cabezae == NULL || cabezap == NULL) {
        cout << "\t\t\t\t\t\t\t------------La lista esta vacia------------" << endl;
        return;
    }

    detalleEgresos *auxi = cabezae;
    while (auxi != NULL) {
        cout << "......................................................................" << endl;
        cout << "Codigo de egreso: " << auxi->codigoegresos << "   " << "Fecha de egreso: " << auxi->fegresos.dia << "/" << auxi->fegresos.mes << "/" << auxi->fegresos.anio << "\n";
        cout << "=====================================================================";
        cout << "\n|| Codigo de Producto | Descripcion | Precio | Cantidad E. | Subtotal ||";
        cout << "\n=====================================================================" << endl;

        detalleEgresos *auxi2 = auxi;
        do {
            Productos *auxp = cabezap;
            while (auxp != NULL) {
                if (auxp->codigo == auxi2->codigo) {
                    cout << "     " << auxp->codigo << "           " << auxp->descripcion << "         " << auxp->precio << "        " << auxi2->cantidad << "      " << auxi2->total << "\n";
                    cout << "--------------------------------------------------------------------" << endl;
                    break;
                }
                auxp = auxp->sig;
            }
            auxi2 = auxi2->sig;
        } while (auxi2 != NULL && auxi2->codigoegresos == auxi->codigoegresos);

        auxi = auxi2; 
    }
}

void Insertar_Egresos(detalleEgresos *&cabezae, Productos *&cabezap) {

    FILE *archivo = fopen("Detalles Egresos.txt", "a");
    if (archivo == NULL) {
        printf("Error opening file!\n");
        return;
    }

    char opcion;
    detalleEgresos *cabezae2 = (detalleEgresos *)malloc(sizeof(detalleEgresos));
    if (cabezae2 == NULL) {
        printf("Memory allocation failed!\n");
        fclose(archivo);
        return;
    }

    printf("Ingrese la fecha del egreso: \n");
    do {
        printf("Ingrese el dia: ");
        scanf("%d", &cabezae2->fegresos.dia);
        if (cabezae2->fegresos.dia <= 0 || cabezae2->fegresos.dia >= 32) {
            printf("Dia fuera del rango, intente de nuevo: \n");
        }
    } while (cabezae2->fegresos.dia <= 0 || cabezae2->fegresos.dia >= 32);

    do {
        printf("Ingrese el mes: ");
        scanf("%d", &cabezae2->fegresos.mes);
        if (cabezae2->fegresos.mes <= 0 || cabezae2->fegresos.mes >= 13) {
            printf("Mes fuera del rango, intente de nuevo: \n");
        }
    } while (cabezae2->fegresos.mes <= 0 || cabezae2->fegresos.mes >= 13);

    do {
        printf("Ingrese el anio: ");
        scanf("%d", &cabezae2->fegresos.anio);
        if (cabezae2->fegresos.anio <= 1500 || cabezae2->fegresos.anio >= 2025) {
            printf("Anio fuera del rango, intente de nuevo: \n");
        }
    } while (cabezae2->fegresos.anio <= 1500 || cabezae2->fegresos.anio >= 2025);

    Fecha fechaEgreso = cabezae2->fegresos;
    cabezae2->codigoegresos = ((cabezae2->fegresos.anio * 10000) + cabezae2->fegresos.mes * 100 + cabezae2->fegresos.dia);
    
    float sumatotal = 0;
    float ivatotal = 0;
    float totalfinal = 0;
    do {
        printf("Ingrese el codigo del producto que se egresara: ");
        scanf("%d", &cabezae2->codigo);
        
        Productos *corredor = cabezap;
        bool encontrado = false;
        while (corredor != NULL) {
            if (corredor->codigo == cabezae2->codigo) {
                cabezae2->precio = corredor->precio;
                encontrado = true;
                break;
            }
            corredor = corredor->sig;
        }
        
        if (!encontrado) {
            printf("El codigo del producto no se encuentra en la lista.\n");
            continue;
        }
        
        printf("\t\t-------------------------------------------------------------------------------------\n");
        printf("\t\t\t\tProducto seleccionado: %s ------> Precio: %.2f\n", corredor->descripcion, cabezae2->precio);
        printf("\t\t-------------------------------------------------------------------------------------\n");
        printf("Cantidad a egresar: ");
        scanf("%d", &cabezae2->cantidad);
        
        cabezae2->total = cabezae2->precio * cabezae2->cantidad;
        cabezae2->iva = cabezae2->total * 0.15;
        cabezae2->subtotal = cabezae2->total - cabezae2->iva;
        sumatotal += cabezae2->total;
        ivatotal = sumatotal * 0.15;
        totalfinal = sumatotal + ivatotal;

        Productos *aux3 = cabezap;
        while (aux3 != NULL) {
            if (aux3->codigo == cabezae2->codigo) {
                aux3->cantidadTotal -= cabezae2->cantidad;
                break;
            }
            aux3 = aux3->sig;
        }
        
        fprintf(archivo, "%ld %d %d %d %d %d %.2f\n",
                cabezae2->codigoegresos, cabezae2->codigo, cabezae2->fegresos.dia,
                cabezae2->fegresos.mes, cabezae2->fegresos.anio, cabezae2->cantidad,
                cabezae2->total);

        printf("¿Desea egresar mas productos (s/n): ");
        scanf(" %c", &opcion);  

    } while (opcion == 's' || opcion == 'S');
    
    printf("El Subtotal de los egresos es: %.2f\n", sumatotal);
    printf("El iva es: %.2f\n", ivatotal);
    printf("El total es: %.2f\n", totalfinal);

    free(cabezae2);
    fclose(archivo);
}

void limpiar_Egresos(detalleEgresos*&cabezae){
	detalleEgresos *borrar;
	while(cabezae!=NULL){
		borrar=cabezae;
		cabezae=cabezae->sig;
		delete borrar;
	
		}	
	}
void Ordenar_Egresos(detalleEgresos *&cabezae) {
    limpiar_Egresos(cabezae);
    
    int codigoEgreso, codigopropio;
    float total;
    int cantidad;
    int dia, mes, anio;

    FILE *archivo = fopen("Detalles Egresos.txt", "r");
    if (archivo == NULL) {
        printf("Error opening file!\n");
        return;
    }

    while (fscanf(archivo, "%d %d %d %d %d %d %f", &codigopropio, &codigoEgreso, &dia, &mes, &anio, &cantidad, &total) == 7) {
        detalleEgresos *nuevo = (detalleEgresos *)malloc(sizeof(detalleEgresos));
        if (nuevo == NULL) {
            printf("Memory allocation failed!\n");
            fclose(archivo);
            return;
        }

        nuevo->codigoegresos = codigopropio;
        nuevo->codigo = codigoEgreso;
        nuevo->fegresos.dia = dia;
        nuevo->fegresos.mes = mes;
        nuevo->fegresos.anio = anio;
        nuevo->cantidad = cantidad;
        nuevo->total = total;

        detalleEgresos *aux1 = cabezae;
        detalleEgresos *aux2 = NULL;

        while (aux1 != NULL && aux1->codigoegresos < codigopropio) {
            aux2 = aux1;
            aux1 = aux1->sig;
        }

        if (aux2 == NULL) {
            nuevo->sig = cabezae;
            cabezae = nuevo;
        } else {
            aux2->sig = nuevo;
            nuevo->sig = aux1;
        }
    }

    fclose(archivo);
}
//Egresos Detallados.................................................................................................................
void Insertar_DetalleEgresos(Egresos *&cabezae2, Productos *&cabezap, detalleEgresos *&cabezae) {
    detalleEgresos *aux = cabezae;
    FILE *archivo = fopen("Egresos.txt", "w");
    if (archivo == NULL) {
        printf("Error opening file!\n");
        return;
    }

    while (aux != NULL) {
        Egresos *nuevo = (Egresos *)malloc(sizeof(Egresos));
        if (nuevo == NULL) {
            printf("Memory allocation failed!\n");
            fclose(archivo);
            return;
        }
        nuevo->codigoegresos = aux->codigoegresos;
        nuevo->codigo = aux->codigo;
        nuevo->fegresos = aux->fegresos;
        nuevo->cantidad = aux->cantidad;
        nuevo->cantidadTotal = aux->cantidadTotal;

        Productos *corredor = cabezap;
        while (corredor != NULL) {
            if (corredor->codigo == aux->codigo) {
                nuevo->subtotal = corredor->precio * aux->cantidad;
                nuevo->iva = nuevo->subtotal * 0.15;
                nuevo->total = nuevo->subtotal + nuevo->iva;
                break;
            }
            corredor = corredor->sig;
        }

        Productos *auxp = cabezap;
        while (auxp != NULL) {
            if (auxp->codigo == aux->codigo) {
                auxp->cantidadTotal -= aux->cantidad;
                break;
            }
            auxp = auxp->sig;
        }

        if (cabezae2 == NULL) {
            cabezae2 = nuevo;
            nuevo->sig = NULL;
        } else {
            Egresos *ultimo = cabezae2;
            while (ultimo->sig != NULL) {
                ultimo = ultimo->sig;
            }
            ultimo->sig = nuevo;
            nuevo->sig = NULL;
        }

        fprintf(archivo, "%d %d %d %d %d %d %.2f %.2f %.2f\n",
                aux->codigoegresos, aux->codigo, aux->fegresos.dia, aux->fegresos.mes,
                aux->fegresos.anio, aux->cantidad, nuevo->subtotal, nuevo->iva, nuevo->total);

        detalleEgresos *borrar = aux;
        aux = aux->sig;
        free(borrar);
    }

    cabezae = NULL;
    fclose(archivo);
}
void Imprimirlista_DetalleEgresos(Egresos *cabezae2, Productos *cabezap) {
    
    if (cabezae2 == NULL || cabezap == NULL) {
        cout << "\t\t\t\t\t\t\t------------La lista esta vacia------------" << endl;
        return;
    }

    for (Productos *auxp = cabezap; auxp != NULL; auxp = auxp->sig) {
        cout << "\n\n\n\tProducto: " << auxp->descripcion << " (Codigo: " << auxp->codigo << ")" << endl;
        cout << "____________________________________________________________________________________________________________________________________________________________" << endl;
        cout << "\n========================================================================================================================================================";
        cout << "\n|| Codigo de Egreso      |    Codigo P.   |    Descripcion/Precio  |    Fecha de egreso  |   Cantidad egresada |    Subtotal  |   Iva    |  Total  ||  ";
        cout << "\n========================================================================================================================================================" << endl;

        bool productosEncontrados = false;
        for (Egresos *auxe = cabezae2; auxe != NULL; auxe = auxe->sig) {
            if (auxe->codigo == auxp->codigo) {
                cout << "\t" << auxe->codigoegresos << "\t\t" << auxe->codigo << "\t\t" << auxp->descripcion << "-->$" << auxp->precio << "\t          " << auxe->fegresos.dia << "/" << auxe->fegresos.mes << "/" << auxe->fegresos.anio << "\t\t   " << auxe->cantidad << "\t\t" << "$" << auxe->subtotal << "           " << "$" << auxe->iva << "    " << "$" << auxe->total  << endl;
               	cout<<"_____________________________________________________________________________________________________________________________________________________"<<endl;
                productosEncontrados = true;
            }
        }

        if (!productosEncontrados) {
            cout << "\t\t\t\t\t\t\t------------No se encontraron egresos para este producto------------" << endl;
        }
    }
}

