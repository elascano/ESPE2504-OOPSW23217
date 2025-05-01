#include <iostream>
using namespace std;
void llenar(int v[], int n){
    int i;
    for(i=0;i<n;i++){
        cout<<"Ingrese el elmento "<<i+1<<": ";
        cin>> v[i];
    }
}
void mostrar(int v[], int n){
    cout<<"Elementos del array"<<endl;
    for(int i=0;i<n;i++){
        cout<< v[i]<<"\t";
    }
    cout<<endl;
}
int ordena_burbuja(int v[], int n){
    int i,j, aux, cont=0, pas=1;
    bool dedito=true;
    for(;dedito==true;){
        dedito=false;
        for(j=0;j<n-1;j++){
            cont++;
            if(v[j] > v[j+1]){
                //intercambio de posiciones
                aux= v[j];
                v[j]=v[j+1];
                v[j+1]=aux;
                dedito=true;
            }
        }


    }
    return cont;

}
main(){
    int vector[5], ncompa;
    int n=5;
    llenar(vector,n);
    mostrar(vector,n);
    ncompa= ordena_burbuja(vector,n);
    mostrar(vector,n);
    cout<<"El numero de comparaciones en burbuja es: "<<ncompa;
}