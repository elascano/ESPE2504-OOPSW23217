#include <stdio.h>
#include <string.h>
#include <ctype.h>
#include <stdlib.h>

#define MAX_USUARIO 50
#define MAX_CONTRASENA 50
#define MAX_ITEMS 100
#define MAX_NAME_LENGTH 50
#define MAX_TYPE_LENGTH 20
#define MAX_SIZE_LENGTH 2

// Estructura para las prendas
typedef struct {
    char item_id;               // ID de la prenda (letra del alfabeto)
    char name[MAX_NAME_LENGTH]; // Nombre de la prenda
    char type[MAX_TYPE_LENGTH]; // Tipo de prenda (blusa, falda, etc.)
    char size[MAX_SIZE_LENGTH]; // Talla (S, M, L)
    int quantity;               // Cantidad disponible
} Item;

// Estructura para el inventario
typedef struct {
    Item items[MAX_ITEMS];
    int item_count;
} Inventory;

// Funciones de validación de usuario y contraseña
int validar_contrasena(const char *contrasena) {
    int tiene_mayuscula = 0, tiene_minuscula = 0, tiene_numero = 0, tiene_especial = 0;

    for (int i = 0; i < strlen(contrasena); i++) {
        if (isupper(contrasena[i])) tiene_mayuscula = 1;
        else if (islower(contrasena[i])) tiene_minuscula = 1;
        else if (isdigit(contrasena[i])) tiene_numero = 1;
        else tiene_especial = 1;
    }

    return tiene_mayuscula && tiene_minuscula && tiene_numero && tiene_especial;
}

int validar_usuario(const char *usuario) {
    int tiene_alfabetico_o_numero = 0;

    for (int i = 0; i < strlen(usuario); i++) {
        if (isalpha(usuario[i]) || isdigit(usuario[i])) {
            tiene_alfabetico_o_numero = 1;
            break;
        }
    }

    return tiene_alfabetico_o_numero;
}

// Función para ingresar y validar los datos de la prenda
void ingresarDatos(Item *p) {

    printf("Ingrese el tipo de prenda (Falda, Chompa, Pantalón, etc.): ");
    scanf("%s", p->type);

    printf("Ingrese el genero (Hombre/Mujer): ");
    scanf("%s", p->size);

    printf("Ingrese la cantidad de la prenda: ");
    scanf("%d", &p->quantity);
    while (p->quantity <= 0) {
        printf("Error: Ingrese una cantidad válida (mayor que 0): ");
        scanf("%d", &p->quantity);
    }
}

// Función para mostrar las prendas disponibles
void list_items(Inventory *inventory) {
    printf("Prendas disponibles en el inventario:\n");
    for (int i = 0; i < inventory->item_count; i++) {
        printf("ID: %c, Nombre: %s, Tipo: %s, Talla: %s, Cantidad: %d\n",
               inventory->items[i].item_id,
               inventory->items[i].name,
               inventory->items[i].type,
               inventory->items[i].size,
               inventory->items[i].quantity);
    }
}

// Función para buscar una prenda por nombre o tipo
void buscar_prenda(Inventory *inventory) {
    char criterio[MAX_NAME_LENGTH];
    int encontrado = 0;

    printf("Ingrese el nombre o tipo de la prenda a buscar: ");
    scanf("%s", criterio);

    for (int i = 0; i < inventory->item_count; i++) {
        if (strstr(inventory->items[i].name, criterio) != NULL || strstr(inventory->items[i].type, criterio) != NULL) {
            printf("Prenda encontrada: ID: %c, Nombre: %s, Tipo: %s, Talla: %s, Cantidad: %d\n",
                   inventory->items[i].item_id,
                   inventory->items[i].name,
                   inventory->items[i].type,
                   inventory->items[i].size,
                   inventory->items[i].quantity);
            encontrado = 1;
        }
    }

    if (!encontrado) {
        printf("No se encontró ninguna prenda con ese nombre o tipo.\n");
    }
}

// Función para eliminar una prenda del inventario por ID
void remove_item(Inventory *inventory) {
    char item_id;
    char confirmation[10]; // Para almacenar respuestas de "si" o "no"
    int found = 0;

    list_items(inventory);
    printf("Para eliminar una prenda, debe ingresar un ID en letra mayúscula.\n");

    printf("Ingrese el ID de la prenda a eliminar (letra del alfabeto en mayúscula): ");
    scanf(" %c", &item_id);

    // Verificar si el inventario está vacío
    if (inventory->item_count == 0) {
        printf("Error: El inventario está vacío.\n");
        return;
    }

    // Buscar la prenda con el ID especificado
    for (int i = 0; i < inventory->item_count; i++) {
        if (inventory->items[i].item_id == item_id) {
            found = 1;

            // Mostrar detalles de la prenda que se está eliminando
            printf("Eliminando la prenda:\n");
            printf("ID: %c, Nombre: %s, Tipo: %s, Talla: %s, Cantidad: %d\n",
                   inventory->items[i].item_id,
                   inventory->items[i].name,
                   inventory->items[i].type,
                   inventory->items[i].size,
                   inventory->items[i].quantity);

            // Confirmar eliminación
            printf("¿Está seguro de que desea eliminar esta prenda? (si/no): ");
            scanf("%s", confirmation);

            // Comparar la respuesta sin distinguir mayúsculas y minúsculas
            if (strcasecmp(confirmation, "si") == 0) {
                // Desplazar los elementos restantes hacia la izquierda
                for (int j = i; j < inventory->item_count - 1; j++) {
                    inventory->items[j] = inventory->items[j + 1];
                }
                inventory->item_count--;
                printf("Prenda con ID %c eliminada con éxito.\n", item_id);
            } else {
                printf("Eliminación cancelada.\n");
            }
            break;
        }
    }

    // Si no se encontró la prenda
    if (!found) {
        printf("Error: No se encontró la prenda con ID %c.\n", item_id);
    }
}

// Función para mostrar el menú y permitir que el usuario elija acciones
void mostrarMenu() {
    printf("\nSelecciona una opción:\n");
    printf("1. Ingresar nueva prenda\n");
    printf("2. Mostrar datos de la prenda\n");
    printf("3. Buscar prenda\n");
    printf("4. Eliminar prenda\n");
    printf("5. Salir\n");
}

// Función principal
int main() {
    char usuarioRegistrado[MAX_USUARIO];
    char contrasenaRegistrada[MAX_CONTRASENA];
    char usuarioIngresado[MAX_USUARIO];
    char contrasenaIngresada[MAX_CONTRASENA];
    int opcion;
    int registroCompleto = 0;
    Inventory inventory;
    inventory.item_count = 0;  // Inicializa el contador de artículos

    do {
        printf("==== Menú ====\n");
        printf("1. Registrarse\n");
        printf("2. Iniciar sesión\n");
        printf("3. Salir\n");
        printf("Seleccione una opción: ");
        scanf("%d", &opcion);
        getchar(); // Consumir el salto de línea restante

        if (opcion == 1) { // Registro de usuario
            printf("=== Registro ===\n");

            do {
                printf("Ingrese un nombre de usuario: ");
                fgets(usuarioRegistrado, MAX_USUARIO, stdin);
                usuarioRegistrado[strcspn(usuarioRegistrado, "\n")] = '\0'; // Eliminar el salto de línea

                if (!validar_usuario(usuarioRegistrado)) {
                    printf("El nombre de usuario debe contener al menos un carácter alfabético o un número.\n");
                }
            } while (!validar_usuario(usuarioRegistrado));

            do {
                printf("Ingrese una contraseña: ");
                fgets(contrasenaRegistrada, MAX_CONTRASENA, stdin);
                contrasenaRegistrada[strcspn(contrasenaRegistrada, "\n")] = '\0'; // Eliminar el salto de línea

                if (!validar_contrasena(contrasenaRegistrada)) {
                    printf("La contraseña debe contener al menos una letra mayúscula, una letra minúscula, un número y un carácter especial.\n");
                }
            } while (!validar_contrasena(contrasenaRegistrada));

            registroCompleto = 1;
            printf("¡Registro exitoso! Ahora puede iniciar sesión.\n\n");
        } else if (opcion == 2) { // Inicio de sesión
            if (!registroCompleto) {
                printf("Primero debe registrarse antes de iniciar sesión.\n\n");
                continue;
            }

            printf("=== Iniciar sesión ===\n");
            printf("Ingrese su nombre de usuario: ");
            fgets(usuarioIngresado, MAX_USUARIO, stdin);
            usuarioIngresado[strcspn(usuarioIngresado, "\n")] = '\0'; // Eliminar el salto de línea

            printf("Ingrese su contraseña: ");
            fgets(contrasenaIngresada, MAX_CONTRASENA, stdin);
            contrasenaIngresada[strcspn(contrasenaIngresada, "\n")] = '\0'; // Eliminar el salto de línea

            // Validar usuario y contraseña
            if (strcmp(usuarioRegistrado, usuarioIngresado) == 0 &&
                strcmp(contrasenaRegistrada, contrasenaIngresada) == 0) {
                printf("¡Inicio de sesión exitoso! Bienvenido, %s.\n\n", usuarioRegistrado);

                do {
                    mostrarMenu();
                    printf("Ingrese su opción: ");
                    scanf("%d", &opcion);

                    if (opcion == 1) {
                        Item nuevaPrenda;
                        printf("Ingresar nueva prenda:\n");
                        ingresarDatos(&nuevaPrenda);
                        nuevaPrenda.item_id = 'A' + inventory.item_count; // Asignar un ID único a la prenda
                        inventory.items[inventory.item_count] = nuevaPrenda;
                        inventory.item_count++;
                    } else if (opcion == 2) {
                        list_items(&inventory);
                    } else if (opcion == 3) {
                        buscar_prenda(&inventory);
                    } else if (opcion == 4) {
                        remove_item(&inventory);
                    } else if (opcion == 5) {
                        printf("Saliendo...\n");
                        break;
                    } else {
                        printf("Opción no válida. Intente de nuevo.\n");
                    }

                } while (opcion != 5);
            } else {
                printf("Nombre de usuario o contraseña incorrectos.\n\n");
            }
        } else if (opcion == 3) {
            printf("Saliendo del programa.\n");
        } else {
            printf("Opción no válida. Intente de nuevo.\n\n");
        }

    } while (opcion != 3);

    return 0;
}



