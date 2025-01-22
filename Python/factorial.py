# Autor: JM Dev

# El factorial de un numero consiste en multiplicar todos los numeros enteros positivos desde 1 hasta n. 
# Por ejemplo, el factorial de 5 es 5*4*3*2*1 = 120.
# Este tambien es un ejemplo sencillo como usar recursividad.

def factorial(n):
    if n == 0:
        return 1
    else:
        return n * factorial(n - 1)

numero = 5
print(f"El factorial de {numero} es {factorial(numero)}")