/*
 * @Author: JM Dev
 * 
 * Codigo de demostración de corrutinas en Kotlin.
 * Este código muestra cómo trabajar con corrutinas en Kotlin, realizando tareas asíncronas y sincronizadas
 * usando funciones como runBlocking, launch, async, join y await. Los tres ejemplos muestran el uso de 
 * corrutinas de manera simple para mejorar el rendimiento de las aplicaciones al ejecutar múltiples tareas 
 * de forma concurrente.
 */

import kotlinx.coroutines.*

fun main() {
    // Llama a las funciones de demostración
    sincronicoAsincronico()
    sincronicoAsincronico2()
    asincrono()
}

/**
 * Demuestra el uso de `runBlocking` para ejecutar tareas sincrónicas y asíncronas en paralelo.
 * 
 * El bloque `runBlocking` ejecuta de manera sincrónica, bloqueando el hilo principal hasta que todas
 * las corrutinas internas terminen. Dentro de `runBlocking`, se lanza una corrutina asíncrona usando
 * `launch`, que se ejecuta de forma concurrente sin bloquear el hilo principal.
 * 
 * Este ejemplo muestra cómo un mensaje puede imprimirse mientras una corrutina está esperando
 * a completar una tarea.
 */
fun sincronicoAsincronico() {

    // Llamada a runBlocking para iniciar el contexto de corrutinas en el hilo principal
    runBlocking { // Este bloque de código se ejecuta de forma síncrona

        // Lanzamos una nueva corrutina
        launch { // Este bloque de código se ejecuta de forma asíncrona
            println("Iniciando tarea en una corrutina...")
            delay(1000L)  // Simula un delay de 1 segundo (1000 ms)
            println("¡Tarea completada después de un segundo!")
        }
        
        // Este mensaje se imprimirá mientras la corrutina está esperando
        println("Esperando la tarea en segundo plano...")
    }

    // Este mensaje se imprime cuando se termina el bloque runBlocking
    println("Fin del demo1!")
}

/**
 * En este ejemplo, se lanzan dos corrutinas concurrentes y se espera que ambas terminen 
 * utilizando `join()`.
 * 
 * Se lanza `job1` con un retraso de 1 segundo y `job2` con un retraso de 0.5 segundos. 
 * Usamos `join()` para esperar que ambas corrutinas finalicen antes de imprimir el mensaje final.
 */
fun sincronicoAsincronico2() = runBlocking { 
    val job1 = launch { 
        delay(1000L)
        println("Corrutina 1 terminada")
    }
    
    val job2 = launch {
        delay(500L)
        println("Corrutina 2 terminada")
    }
    
    job1.join()  // Espera a que job1 termine
    job2.join()  // Espera a que job2 termine

    // Imprime el mensaje después de que ambas corrutinas han terminado
    println("Ambas corrutinas terminadas")
}

/**
 * Este ejemplo muestra cómo usar `async` para ejecutar tareas concurrentes que devuelven un valor.
 * 
 * Se lanzan dos corrutinas con `async`, una con un retraso de 1 segundo y la otra de 0.5 segundos.
 * Las corrutinas devuelven resultados que se obtienen usando `await()`, lo que permite continuar con 
 * el flujo del programa sin bloquear el hilo principal.
 */
fun asincrono() = runBlocking {
    // Lanzamos dos corrutinas asíncronas
    val deferred1 = async {
        delay(1000L)  // Simula una tarea larga
        println("Resultado de la primera tarea")
        "Resultado 1"  // Devuelve el resultado de la tarea
    }

    val deferred2 = async {
        delay(500L)  // Simula una tarea más rápida
        println("Resultado de la segunda tarea")
        "Resultado 2"  // Devuelve el resultado de la tarea
    }

    // Aquí esperamos ambos resultados (deferred1 y deferred2) sin bloquear el hilo
    val result1 = deferred1.await()  // Espera el resultado de la primera tarea
    val result2 = deferred2.await()  // Espera el resultado de la segunda tarea

    // Imprime los resultados una vez que ambas corrutinas han terminado
    println("Los resultados obtenidos son: $result1 y $result2")
}
