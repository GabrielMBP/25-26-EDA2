# Resolución: SEND + MORE = MONEY

---

## Integrantes del Grupo
 **Gabriel Béjar** 
 **Miguel Gómez**
 **Carlos Alvarado**
 **Nicolás Navas**
 **Samuel Herrera**

---

## Propuesta Inicial
> **Nota:** Estrategia basada en búsqueda exhaustiva mediante Backtracking.

* Se asignan dígitos a las letras una a una en el orden: `(S, E, N, D, M, O, R, Y)`.
* Cada vez que se elige un número, se reserva para evitar repeticiones (memoización).
* En cada paso, se comprueba si la suma mantiene la posibilidad de ser válida.
* Si en algún punto la combinación deja de ser viable, el algoritmo retrocede (**backtrack**) y prueba con el siguiente número disponible.
* Al completar la asignación de todas las letras, se valida la ecuación fundamental:  

---

## Justificación del Diseño Algorítmico

El algoritmo finaliza cuando el índice de búsqueda alcanza la longitud total del arreglo de letras. En este punto, se realiza la conversión de las letras asignadas a sus valores numéricos y se verifica si la identidad aritmética se cumple satisfactoriamente.

Mientras no se alcance el final del arreglo, el sistema identifica el carácter actual según la profundidad de la recursión (el índice), preparándolo para la asignación de un valor.

Se ejecuta un ciclo iterativo del **0 al 9** para cada letra. Se aplica una técnica de **poda (pruning)** esencial: se restringe que las letras que inician una palabra (**S** y **M**) tomen el valor de **0**, garantizando la coherencia matemática del problema.

Se emplea un arreglo auxiliar de estados para marcar un dígito como "usado" y se vincula a la letra actual.
2.  **Hacer:** Se invoca la función recursiva aumentando en 1 el índice para procesar la siguiente letra.
3.  **Deshacer:** Siguiendo el principio de deshacer caminos incorrectos, al regresar en la llamada recursiva, se "desmarca" el dígito utilizado, permitiendo que sea probado en otras combinaciones.

---