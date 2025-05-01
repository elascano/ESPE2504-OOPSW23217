#include "functions.h"


int main(){
	int opc, opc1;
	char idRepresentante[32];
		
	IniciarSesion();

	while(1){
		
		imprimirArchivos("DB\\menu.txt", 244);
		scanf("%d", &opc);
		switch(opc){
			case 1:
				puts("Realmente desea seleccionar esta opcion?");
				puts("[1] SI || [2] NO");
				scanf("%d", &opc1);
				switch(opc1){
					case 1:
						RegistroPadreFamilia();
						break;
					case 2:
							puts("Presione cualquier tecla para continuar...");
							getch();
						break;
				}
				opc1=0;
				limpiarPantalla();
				break;
			case 2:
				puts("Realmente desea seleccionar esta opcion?");
				puts("[1] SI || [2] NO");
				scanf("%d", &opc1);
				switch(opc1){
					case 1:
						RegistrarPagos();
						break;
					case 2:
							puts("Presione cualquier tecla para continuar...");
							getch();
						break;
				}
				opc1=0;
				limpiarPantalla();
				break;
			case 3:
				puts("Realmente desea seleccionar esta opcion?");
				puts("[1] SI || [2] NO");
				scanf("%d", &opc1);
				switch(opc1){
					case 1:
						puts("Ingrese el ID del Representante que desea actualizar: ");
						scanf("%31s", idRepresentante);
						modificarPadreFamilia(idRepresentante);
						getch();
						break;
					case 2:
						puts("Presione cualquier tecla para continuar...");
						getch();
						break;
				}
				limpiarPantalla();
				opc1=0;
				break;
			case 4:
				puts("Realmente desea seleccionar esta opcion?");
				puts("[1] SI || [2] NO");
				scanf("%d", &opc1);
				switch(opc1){
					case 1:
						buscarRepresentante();
						getch();
						break;
					case 2:
							puts("Presione cualquier tecla para continuar...");
							getch();
						break;
				}
				opc1=0;
				limpiarPantalla();
				break;
			case 5:
				puts("Realmente desea seleccionar esta opcion?");
				puts("[1] SI || [2] NO");
				scanf("%d", &opc1);
				switch(opc1){
					case 1:
						buscarPago();
						getch();
						break;
					case 2:
							puts("Presione cualquier tecla para continuar...");
							getch();
						break;
				}
				opc1=0;
				limpiarPantalla();
				break;
			case 6:
				return 0;
			default:
				printf("Opcion Invalida...");
				getch();
				limpiarPantalla();
				break;
				
		}
	}
	
	
	printf("\n\nPresione una tecla para salir ...");
	getch();
	return 0;	
}
	
	

