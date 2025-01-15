/**
    Kotlin supports functional programming. Learn about lambdas in Kotlin.
    Pass a lambda to the any function to check if the collection contains an even number. The any function gets a predicate as an argument and returns true if at least one element satisfies the predicate.
 */

fun containsEven(collection: Collection<Int>): Boolean =
    collection.any { num ->
        num % 2 == 0
    }
