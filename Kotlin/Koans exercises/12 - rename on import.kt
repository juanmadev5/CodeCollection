/*
    When you import a class or a function, you can specify a different name for it by adding as NewName after the import directive. 
    It can be useful if you want to use two classes or functions with similar names from different libraries.
*/

import kotlin.random.Random as KRandom
import java.util.Random as JRandom

fun useDifferentRandomClasses(): String {
    return "Kotlin random: " + KRandom.nextInt(2) + " Java random:" + JRandom().nextInt(2) + "."
}