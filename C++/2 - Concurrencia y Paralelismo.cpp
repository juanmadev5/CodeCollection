/**
 * Autor: JM Dev
 * 
 * Descripción: Codigo de demostración de concurrencia y paralelismo en C++.
 */

#include <iostream>
#include <thread>
#include <vector>
#include <chrono>

using namespace std;

// Función que simula una tarea que toma tiempo
void tarea(int id) {
    cout << "Tarea " << id << " iniciada en hilo " << this_thread::get_id() << endl;
    // Simula una tarea de larga duración
    this_thread::sleep_for(chrono::seconds(2));
    cout << "Tarea " << id << " terminada en hilo " << this_thread::get_id() << endl;
}

int main() {
    vector<thread> hilos;  // Vector para almacenar los hilos

    // Inicia 4 tareas en hilos separados (concurrencia y paralelismo)
    for (int i = 1; i <= 4; ++i) {
        hilos.push_back(thread(tarea, i));  // Lanza un hilo para cada tarea
    }

    // Espera a que todos los hilos terminen
    for (auto& hilo : hilos) {
        hilo.join();  // Espera a que cada hilo termine
    }

    cout << "Todas las tareas han terminado!" << endl;

    return 0;
}
