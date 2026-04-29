public class InsertionSortIterativo {

    public static void main(String[] args) {
        int[] array = {5, 2, 8, 1, 9, 3};
        System.out.println("Estado inicial del array (Insertion Sort Iterativo):");
        imprimirArray(array);
        System.out.println("Iniciando proceso de ordenacion...");
        ordenar(array);
        System.out.println("Proceso finalizado. Estado final del array:");
        imprimirArray(array);
    }

    public static void ordenar(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int actual = array[i];
            int j = i - 1;
            System.out.println("--- Evaluando elemento en indice i=" + i + ", valor a insertar=" + actual + " ---");
            while (j >= 0 && array[j] > actual) {
                System.out.println("Comparacion: indice j=" + j + " es >= 0 y array[" + j + "] (" + array[j] + ") es > que el valor a insertar (" + actual + "). Intercambio necesario.");
                array[j + 1] = array[j];
                System.out.println("Desplazamiento: El valor " + array[j + 1] + " se mueve a la posicion " + (j + 1));
                imprimirArray(array);
                j--;
            }
            if (j < 0) {
                System.out.println("Comparacion: indice j=" + j + " es menor que 0. Se alcanzo el inicio del array.");
            } else {
                System.out.println("Comparacion: array[" + j + "] (" + array[j] + ") NO es > que el valor a insertar (" + actual + "). Posicion correcta encontrada.");
            }
            array[j + 1] = actual;
            System.out.println("Insercion: El valor " + actual + " se coloca en la posicion " + (j + 1));
            imprimirArray(array);
        }
    }

    public static void imprimirArray(int[] array) {
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}