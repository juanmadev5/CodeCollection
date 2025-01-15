/*
    Learn about extension functions. Then implement the extension functions Int.r() and Pair.r() and make them convert Int and Pair to a RationalNumber.
    Pair is a class defined in the standard library:
    data class Pair<out A, out B>(
        val first: A,
        val second: B
    )
    In the case of Int, the denominator is 1.
*/

fun Int.r(): RationalNumber = RationalNumber(this, 1)

fun Pair<Int, Int>.r(): RationalNumber = RationalNumber(first, second)

data class RationalNumber(val numerator: Int, val denominator: Int)