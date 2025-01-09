/**
 * Autor: JM Dev
 * 
 * Descripción: Codigo de demostración de concurrencia y paralelismo en C++.
 */


#include <iostream>
#include <thread>
#include <vector>
#include <numeric> // Para std::accumulate
#include <chrono>  // Para medir el tiempo

// =======================================
// Función que simula una tarea concurrente
// =======================================
void tareaConcurrente(int id) {
    std::cout << "Iniciando tarea concurrente " << id << " en el hilo " 
              << std::this_thread::get_id() << std::endl;
    std::this_thread::sleep_for(std::chrono::seconds(2)); // Simula trabajo pesado
    std::cout << "Tarea concurrente " << id << " completada.\n";
}

// =======================================
// Función que suma un rango de números en paralelo
// =======================================
void sumaParcial(const std::vector<int>& datos, size_t inicio, size_t fin, long long& resultado) {
    resultado = std::accumulate(datos.begin() + inicio, datos.begin() + fin, 0LL);
}

// =======================================
// Función principal
// =======================================
int main() {
    // ------------------------------------
    // Primera parte: Concurrencia
    // ------------------------------------
    const int numTareas = 3; // Número de tareas concurrentes
    std::vector<std::thread> hilosConcurrentes;

    auto inicioConcurrencia = std::chrono::high_resolution_clock::now(); // Inicia el temporizador

    std::cout << "== Comenzando tareas concurrentes ==\n";
    for (int i = 0; i < numTareas; ++i) {
        hilosConcurrentes.emplace_back(tareaConcurrente, i + 1);
    }

    for (auto& hilo : hilosConcurrentes) {
        if (hilo.joinable()) {
            hilo.join(); // Esperar a que terminen todas las tareas
        }
    }
    auto finConcurrencia = std::chrono::high_resolution_clock::now(); // Finaliza el temporizador
    std::chrono::duration<double> duracionConcurrencia = finConcurrencia - inicioConcurrencia; // Calcula el tiempo

    std::cout << "== Tareas concurrentes finalizadas ==\n";
    std::cout << "Tiempo de ejecución de las tareas concurrentes: " 
              << duracionConcurrencia.count() << " segundos\n\n";

    // ------------------------------------
    // Segunda parte: Paralelismo
    // ------------------------------------
    const size_t tamDatos = 1000000; // Tamaño del vector
    const size_t numHilosParalelos = 4; // Número de hilos paralelos
    std::vector<int> datos(tamDatos, 1); // Vector inicializado con unos
    std::vector<std::thread> hilosParalelos;
    std::vector<long long> resultados(numHilosParalelos, 0);

    size_t rango = tamDatos / numHilosParalelos; // División del trabajo

    auto inicioParalelismo = std::chrono::high_resolution_clock::now(); // Inicia el temporizador

    std::cout << "== Comenzando suma paralela ==\n";
    for (size_t i = 0; i < numHilosParalelos; ++i) {
        size_t inicio = i * rango;
        size_t fin = (i == numHilosParalelos - 1) ? tamDatos : inicio + rango;
        hilosParalelos.emplace_back(sumaParcial, std::cref(datos), inicio, fin, std::ref(resultados[i]));
    }

    for (auto& hilo : hilosParalelos) {
        if (hilo.joinable()) {
            hilo.join(); // Esperar a que cada hilo termine
        }
    }

    long long sumaTotal = std::accumulate(resultados.begin(), resultados.end(), 0LL);
    auto finParalelismo = std::chrono::high_resolution_clock::now(); // Finaliza el temporizador
    std::chrono::duration<double> duracionParalelismo = finParalelismo - inicioParalelismo; // Calcula el tiempo

    std::cout << "Suma total: " << sumaTotal << " (esperado: " << tamDatos << ")\n";
    std::cout << "== Suma paralela finalizada ==\n";
    std::cout << "Tiempo de ejecución de la suma paralela: " 
              << duracionParalelismo.count() << " segundos\n";

    return 0;
}
