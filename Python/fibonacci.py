# Autor: JM Dev

# La secuencia de fibonacci es una serie de numeros en la que cada numero es la suma de los dos anteriores.
# por ejemplo, la secuencia de fibonacci hasta el termino 8 es: 0, 1, 1, 2, 3, 5, 8, 13
# por que 0+1=1, 1+1=2, 1+2=3, 2+3=5, 3+5=8, 5+8=13
# el algoritmo lo que hace es sumar los dos ultimos numeros de la lista para obtener el siguiente numero.

def fibonacci(n):
    if n <= 0:
        return [0]
    elif n == 1:
        return [0, 1]
    
    fib = [0, 1]
    for i in range(2, n):
        fib.append(fib[i-1] + fib[i-2])
    return fib

n = 8
print(f"La secuencia de Fibonacci hasta el término {n} es:")
print(fibonacci(n))
