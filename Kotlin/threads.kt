/*
 * @Author: JM Dev
 * 
 * Codigo de demostración del uso de hilos en Kotlin.
 * Este ejemplo muestra cómo crear y manejar hilos usando la clase `Thread` en Kotlin.
 */

fun main() {
    // Llamada a la función que demuestra el uso de hilos
    hiloBasico()
    hiloConNombre()
    hiloConRunnable()
}

/**
 * Demuestra cómo crear un hilo básico usando la clase `Thread`.
 * El hilo ejecuta una tarea en segundo plano.
 */
fun hiloBasico() {
    // Crea un hilo que ejecuta una tarea en paralelo
    val hilo = Thread {
        println("Hilo básico en ejecución")
        // Simula una tarea
        Thread.sleep(1000)
        println("Hilo básico finalizado")
    }

    // Inicia el hilo
    hilo.start()

    // Mensaje del hilo principal
    println("Hilo principal en ejecución")
    
    // Espera a que el hilo termine antes de continuar
    hilo.join()

    println("Hilo principal finalizado")
}

/**
 * Demuestra cómo asignar un nombre a un hilo.
 * Esto es útil para identificar hilos cuando se gestionan múltiples hilos en la aplicación.
 */
fun hiloConNombre() {
    // Crea un hilo con un nombre personalizado
    val hilo = Thread {
        println("${Thread.currentThread().name} está ejecutándose")
        Thread.sleep(1000)
        println("${Thread.currentThread().name} finalizó")
    }

    // Asigna un nombre al hilo
    hilo.name = "MiHiloPersonalizado"
    
    // Inicia el hilo
    hilo.start()

    // Mensaje del hilo principal
    println("Hilo principal en ejecución")
    
    // Espera a que el hilo termine
    hilo.join()

    println("Hilo principal finalizado")
}

/**
 * Demuestra cómo crear un hilo utilizando `Runnable`.
 * `Runnable` es una interfaz funcional que permite ejecutar código en un hilo.
 */
fun hiloConRunnable() {
    // Define un objeto Runnable que contiene la tarea a ejecutar
    val tarea = Runnable {
        println("Hilo con Runnable en ejecución")
        Thread.sleep(1000)
        println("Hilo con Runnable finalizado")
    }

    // Crea un hilo con el objeto Runnable
    val hilo = Thread(tarea)

    // Inicia el hilo
    hilo.start()

    // Mensaje del hilo principal
    println("Hilo principal en ejecución")
    
    // Espera a que el hilo termine
    hilo.join()

    println("Hilo principal finalizado")
}
