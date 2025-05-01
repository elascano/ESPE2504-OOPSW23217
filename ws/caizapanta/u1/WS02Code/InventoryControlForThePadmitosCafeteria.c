#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <ctype.h>

void showMenu();

struct Product {
    char name[50];
    int quantity;
};

struct Product inventory[100];
int productCount;

void displayProductList() {
    for (int i = 0; i < productCount; i++) {
        printf(" %d: [Product: %s] (Quantity: %d)\n", i + 1, inventory[i].name, inventory[i].quantity);
    }
}

void addProduct() {
    if (productCount < 100) {
        char newName[50];
        char confirmation;

        printf("Enter the name of the new product: ");
        getchar();
        fgets(newName, 50, stdin);

        newName[strcspn(newName, "\n")] = '\0';

        for (int i = 0; newName[i] != '\0'; i++) {
            if (isdigit(newName[i])) {
                printf("Error: Product name cannot contain numbers.\n");
                return;
            }
        }
        printf("Are you sure you want to add the product '%s' (Y/N): ", newName);
        scanf(" %c", &confirmation);
        confirmation = toupper(confirmation);

        if (confirmation == 'Y') {
            sprintf(inventory[productCount].name, "%03d.%s", productCount + 1, newName);
            productCount++;
            printf("Product added successfully.\n");
        } else if (confirmation == 'N') {
            printf("Product was not added.\n");
        } else {
            printf("Invalid action.\n");
        }
    } else {
        printf("Cannot add more products. Maximum capacity reached.\n");
    }
}

void searchProduct() {
    char searchTerm[50];
    int found = 0;

    printf("Enter the name or part of the product name to search: ");
    getchar();
    fgets(searchTerm, 50, stdin);
    searchTerm[strcspn(searchTerm, "\n")] = '\0';

    printf("\nSearch results:\n");
    for (int i = 0; i < productCount; i++) {
        if (strstr(inventory[i].name, searchTerm) != NULL) {
            printf(" %d: [Product: %s] (Quantity: %d)\n", i + 1, inventory[i].name, inventory[i].quantity);
            found = 1;
        }
    }

    if (!found) {
        printf("No products found matching '%s'.\n", searchTerm);
    }
}

void increaseProductQuantity() {
    char searchTerm[50];
    int amount;
    int found = 0;
    char confirmation;

    printf("Enter the code or name of the product to increase quantity: ");
    getchar();
    fgets(searchTerm, 50, stdin);
    searchTerm[strcspn(searchTerm, "\n")] = '\0';

    if (strlen(searchTerm) == 0) {
        printf("Error: No input received. Try again.\n");
        return;
    }

    for (int i = 0; i < productCount; i++) {
        if (strstr(inventory[i].name, searchTerm) != NULL) {
            printf("\nProduct found: %s (Current quantity: %d)\n", inventory[i].name, inventory[i].quantity);
            printf("Enter amount to add: ");
            if (scanf("%d", &amount) != 1 || amount <= 0) {
                printf("Error: Invalid quantity. Only positive numbers allowed.\n");
                while (getchar() != '\n');
                return;
            }

            printf("Are you sure you want to add %d to '%s' (Y/N): ", amount, inventory[i].name);
            scanf(" %c", &confirmation);
            confirmation = toupper(confirmation);

            if (confirmation == 'Y') {
                inventory[i].quantity += amount;
                printf("\nQuantity updated. New quantity: %d\n", inventory[i].quantity);
            } else if (confirmation == 'N') {
                printf("\nNo changes made.\n");
            } else {
                printf("\nInvalid option.\n");
            }

            found = 1;
            break;
        }
    }

    if (!found) {
        printf("\nNo product found with code or name '%s'.\n", searchTerm);
    }
}

void decreaseProductQuantity() {
    char searchTerm[50];
    int amount;
    int found = 0;
    char confirmation;

    printf("Enter the code or name of the product to decrease quantity: ");
    getchar();
    fgets(searchTerm, 50, stdin);
    searchTerm[strcspn(searchTerm, "\n")] = '\0';

    for (int i = 0; i < productCount; i++) {
        if (strstr(inventory[i].name, searchTerm) != NULL) {
            printf("\nProduct found: %s (Current quantity: %d)\n", inventory[i].name, inventory[i].quantity);
            printf("Enter amount to remove: ");
            if (scanf("%d", &amount) != 1 || amount <= 0) {
                printf("Error: Invalid quantity.\n");
                while (getchar() != '\n');
                return;
            }

            printf("Are you sure you want to remove %d from '%s' (Y/N): ", amount, inventory[i].name);
            scanf(" %c", &confirmation);
            confirmation = toupper(confirmation);

            if (confirmation == 'Y') {
                if (amount <= inventory[i].quantity) {
                    inventory[i].quantity -= amount;
                    printf("\nQuantity updated. New quantity: %d\n", inventory[i].quantity);
                } else {
                    printf("\nNot enough stock available.\n");
                }
            } else if (confirmation == 'N') {
                printf("\nNo changes made.\n");
            } else {
                printf("\nInvalid option.\n");
            }

            found = 1;
            break;
        }
    }

    if (!found) {
        printf("\nNo product found with code or name '%s'.\n", searchTerm);
    }
}

void deleteProduct() {
    char searchTerm[50];
    int index = -1;
    char confirmation;

    printf("Enter the name or code of the product to delete: ");
    getchar();
    fgets(searchTerm, 50, stdin);
    searchTerm[strcspn(searchTerm, "\n")] = 0;

    for (int i = 0; i < productCount; i++) {
        if (strstr(inventory[i].name, searchTerm) != NULL) {
            index = i;
            break;
        }
    }

    if (index != -1) {
        printf("Product found: %s. Are you sure you want to delete it (Y/N): ", inventory[index].name);
        scanf(" %c", &confirmation);
        confirmation = toupper(confirmation);

        if (confirmation == 'Y') {
            printf("Product deleted: %s\n", inventory[index].name);
            for (int i = index; i < productCount - 1; i++) {
                strcpy(inventory[i].name, inventory[i + 1].name);
                inventory[i].quantity = inventory[i + 1].quantity;
            }
            productCount--;
        } else if (confirmation == 'N') {
            printf("Action cancelled. No product deleted.\n");
        } else {
            printf("Invalid action.\n");
        }
    } else {
        printf("No product found matching '%s'.\n", searchTerm);
    }
}

void saveReport() {
    FILE *file = fopen("products.txt", "w");
    if (file == NULL) {
        printf("Error opening file.\n");
        return;
    }
    for (int i = 0; i < productCount; i++) {
        fprintf(file, "%d: [Product: %s]\n", i + 1, inventory[i].name);
    }
    fclose(file);

    printf("Product list successfully saved to 'products.txt'.\n");
}

void returnToMenu() {
    char option;
    do {
        printf("\nDo you want to return to the main menu (Y/N): ");
        scanf(" %c", &option);
        option = toupper(option);

        if (option == 'Y') {
            showMenu();
            break;
        } else if (option == 'N') {
            printf("Exiting program. Goodbye!\n");
            exit(0);
        } else {
            printf("Invalid option. Try again.\n");
        }
    } while (1);
}

void showMenu() {
    int choice;

    do {
        printf("\n***** Select an option: *****\n");
        printf("1. View available product list\n");
        printf("2. Add product\n");
        printf("3. Search product\n");
        printf("4. Increase product quantity\n");
        printf("5. Decrease product quantity\n");
        printf("6. Delete product\n");
        printf("7. Generate report\n");
        printf("8. Exit\n");
        printf("Enter your option: ");
        scanf("%d", &choice);

        switch (choice) {
            case 1:
                displayProductList();
                returnToMenu();
                break;
            case 2:
                addProduct();
                break;
            case 3:
                searchProduct();
                break;
            case 4:
                increaseProductQuantity();
                break;
            case 5:
                decreaseProductQuantity();
                break;
            case 6:
                deleteProduct();
                break;
            case 7:
                saveReport();
                returnToMenu();
                break;
            case 8:
                printf("Exiting program. Goodbye!\n");
                break;
            default:
                printf("Invalid option. Try again.\n");
        }
    } while (choice != 8);
}

int main() {
    showMenu();
    return 0;
}
