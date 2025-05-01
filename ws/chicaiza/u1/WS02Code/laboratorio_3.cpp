#include <iostream>
#include <vector>
#include <iomanip>
#include <cmath>
using namespace std;

struct Estudiante
{
    int id;
    string nombre;
    float nota1;
    float nota2;
    float promedio;
    char categoria;
    float z;
};

float calcularMedia(const vector<Estudiante> &estudiantes)
{
    if (estudiantes.empty())
        return 0;

    float suma = 0;
    for (const auto &est : estudiantes)
        suma += est.promedio;

    return suma / estudiantes.size();
}

float calcularDesviacionEstandar(const vector<Estudiante> &estudiantes, float media)
{
    if (estudiantes.empty())
        return 0;

    float suma = 0;
    for (const auto &est : estudiantes)
        suma += pow(est.promedio - media, 2);

    return sqrt(suma / estudiantes.size());
}

float calcularZ(float promedio, float media, float desviacion)
{
    return (desviacion == 0) ? 0 : (promedio - media) / desviacion;
}

char calcularCategoria(float z)
{
    if (z >= 1)
        return 'A';
    if (z >= 0)
        return 'B';
    if (z >= -1)
        return 'C';
    if (z >= -2)
        return 'D';
    return 'E';
}

void actualizarCategorias(vector<Estudiante> &estudiantes)
{
    float media = calcularMedia(estudiantes);
    float desviacion = calcularDesviacionEstandar(estudiantes, media);

    for (auto &est : estudiantes)
    {
        est.z = calcularZ(est.promedio, media, desviacion);
        est.categoria = calcularCategoria(est.z);
    }
}

void mostrarLista(const vector<Estudiante> &estudiantes)
{
    system("cls");
    if (estudiantes.empty())
    {
        cout << "No hay estudiantes registrados.\n";
        return;
    }

    cout << "------------------------------------------------------------------------------------------------\n";
    cout << setw(5) << "ID" << setw(25) << "Nombre" << setw(10) << "Nota1"
         << setw(10) << "Nota2" << setw(12) << "Promedio" << setw(12) << "Z" << setw(12) << "Categoria\n";
    cout << "------------------------------------------------------------------------------------------------\n";

    for (const auto &est : estudiantes)
    {
        cout << setw(5) << est.id
             << setw(25) << est.nombre.substr(0, 24)
             << setw(10) << est.nota1
             << setw(10) << est.nota2
             << setw(12) << fixed << setprecision(2) << est.promedio
             << setw(12) << fixed << setprecision(2) << est.z
             << setw(12) << est.categoria << "\n";
    }
}

void anadirEstudiante(vector<Estudiante> &estudiantes, int &id)
{
    system("cls");
    Estudiante est;
    est.id = id;

    cout << "\nAniadir Estudiante:\n";
    cout << "Ingrese Nombre: ";
    cin.ignore();
    getline(cin, est.nombre);

    do
    {
        cout << "Ingrese Nota 1: ";
        cin >> est.nota1;
        if (est.nota1 < 1 || est.nota1 > 20)
        {
            cout << "La calificacion debe tener un puntaje entre 1 y 20 para ser ingresada" << endl;
        }
    } while (est.nota1 < 1 || est.nota1 > 20);

    do
    {
        cout << "Ingrese Nota 2: ";
        cin >> est.nota2;
        if (est.nota2 < 1 || est.nota2 > 20)
        {
            cout << "La calificacion debe tener un puntaje entre 1 y 20 para ser ingresada" << endl;
        }
    } while (est.nota2 < 1 || est.nota2 > 20);

    est.promedio = (est.nota1 + est.nota2) / 2;
    estudiantes.push_back(est);

    actualizarCategorias(estudiantes);
    id++;

    cout << "\nEstudiante aniadido con exito.\n";
}

void modificarDatos(vector<Estudiante> &estudiantes)
{
    system("cls");

    if (estudiantes.empty())
    {
        cout << "No hay estudiantes para modificar.\n";
        return;
    }

    mostrarLista(estudiantes);
    int idModificar;
    cout << "\nIngrese el ID del estudiante que desea modificar: ";
    cin >> idModificar;

    for (auto &est : estudiantes)
    {
        if (est.id == idModificar)
        {
            int op;
            cout << "\nSeleccione el dato que desea modificar:\n";
            cout << "1. Nombre\n";
            cout << "2. Nota 1\n";
            cout << "3. Nota 2\n";
            cout << "Opcion: ";
            cin >> op;
            cin.ignore();

            switch (op)
            {
            case 1:
                cout << "Ingrese nuevo Nombre: ";
                getline(cin, est.nombre);
                break;
            case 2:
                do
                {
                    cout << "Ingrese nueva Nota 1: ";
                    cin >> est.nota1;
                    if (est.nota1 < 1 || est.nota1 > 20)
                    {
                        cout << "La calificacion debe tener un puntaje entre 1 y 20 para ser ingresada" << endl;
                    }
                } while (est.nota1 < 1 || est.nota1 > 20);
                break;
            case 3:
                do
                {
                    cout << "Ingrese nueva Nota 2: ";
                    cin >> est.nota2;
                    if (est.nota2 < 1 || est.nota2 > 20)
                    {
                        cout << "La calificacion debe tener un puntaje entre 1 y 20 para ser ingresada" << endl;
                    }
                } while (est.nota2 < 1 || est.nota2 > 20);
                break;
            default:
                cout << "Opción invalida.\n";
                return;
            }

            est.promedio = (est.nota1 + est.nota2) / 2;
            actualizarCategorias(estudiantes);
            cout << "Datos modificados correctamente.\n";
            return;
        }
    }

    cout << "ID no encontrado.\n";
}

void eliminarEstudiante(vector<Estudiante> &estudiantes)
{
    system("cls");

    if (estudiantes.empty())
    {
        cout << "No hay estudiantes para eliminar.\n";
        return;
    }

    mostrarLista(estudiantes);
    int idEliminar;
    cout << "\nIngrese el ID del estudiante a eliminar: ";
    cin >> idEliminar;

    for (auto it = estudiantes.begin(); it != estudiantes.end(); ++it)
    {
        if (it->id == idEliminar)
        {
            estudiantes.erase(it);
            actualizarCategorias(estudiantes);
            cout << "Estudiante eliminado correctamente.\n";
            return;
        }
    }

    cout << "ID no encontrado. No se elimino ningun estudiante.\n";
}

void mostrarMenu()
{
    cout << "\n----------------------\n";
    cout << "Seleccione una opcion:\n";
    cout << "1. Mostrar lista de estudiantes\n";
    cout << "2. Agregar estudiante\n";
    cout << "3. Modificar por ID\n";
    cout << "4. Eliminar estudiante\n";
    cout << "5. Salir\n";
    cout << "----------------------\n";
}

void menuPrincipal()
{
    int id = 1;
    vector<Estudiante> estudiantes;
    int op;
    bool bandera = true;

    while (bandera)
    {
        system("cls");
        mostrarMenu();
        cin >> op;

        switch (op)
        {
        case 1:
            mostrarLista(estudiantes);
            break;
        case 2:
            anadirEstudiante(estudiantes, id);
            break;
        case 3:
            modificarDatos(estudiantes);
            break;
        case 4:
            eliminarEstudiante(estudiantes);
            break;
        case 5:
            bandera = false;
            break;
        default:
            cout << "Opcion invalida. Intente nuevamente.\n";
        }

        system("pause");
    }
}

int main()
{
    menuPrincipal();
    return 0;
}