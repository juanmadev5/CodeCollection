/**
 * Autor: JM Dev
 * 
 * Descripción: Codigo de demostración de punteros en C++.
 */

#include <iostream>

using namespace std;

int main() {
    // Declaramos una variable normal
    int valor = 10;

    // Declaramos un puntero que apuntará a una variable de tipo int
    int* puntero;

    // Asignamos la dirección de memoria de 'valor' al puntero
    puntero = &valor;

    // Imprimimos el valor de la variable 'valor' usando el puntero
    cout << "Valor de la variable 'valor' usando puntero: " << *puntero << endl;

    // Modificamos el valor de 'valor' a través del puntero
    *puntero = 20;

    // Imprimimos el valor de 'valor' después de modificarlo usando el puntero
    cout << "Nuevo valor de la variable 'valor' después de modificar con puntero: " << valor << endl;

    // Imprimimos la dirección de memoria de 'valor'
    cout << "Dirección de memoria de 'valor': " << &valor << endl;

    // Imprimimos la dirección de memoria a la que apunta el puntero
    cout << "Dirección de memoria almacenada en el puntero: " << puntero << endl;

    return 0;
}
