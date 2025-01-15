/*
    Reuse your solution from the previous task, but replace the interface with the sealed interface. Then you no longer need the else branch in when.
*/

fun eval(expr: Expr): Int =
    when (expr) {
        is Num -> expr.value
        is Sum -> eval(expr.left) + eval(expr.right)
    }

sealed interface Expr
class Num(val value: Int) : Expr
class Sum(val left: Expr, val right: Expr) : Expr