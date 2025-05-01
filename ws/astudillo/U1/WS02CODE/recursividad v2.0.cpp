#include <iostream>
using namespace std;

void ordenar(int array[], int n, int i = 0) {
    if (i > n) return;
    int minimo = i;
    for (int j = i + 1; j < n; j++) {
        if (array[j] > array[minimo]) {
            minimo = j;}}
    if (minimo != i) {
        int temp = array[i];
        array[i] = array[minimo];
        array[minimo] = temp;}
    ordenar(array, n, i + 1);}

void imprimir(int array[], int n, int i = 0) {
    if (i >= n) return;
    cout << array[i] << " ";
    imprimir(array, n, i + 1);
}

int main() {
    int n;
    int array[100];
    cout << "Ingrese la cantidad de numeros: ";
    cin >> n;
    cout << "Ingrese los numeros:\n";
    for (int i = 0; i < n; i++) {
        cin >> array[i];}
    ordenar(array, n);
    cout << "Numeros ordenados: ";
    imprimir(array, n);
    return 0;}
