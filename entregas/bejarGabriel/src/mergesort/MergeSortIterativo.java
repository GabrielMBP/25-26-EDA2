public class MergeSortIterativo {

    public static void main(String[] args) {
        int[] array = {5, 2, 8, 1, 9, 3};
        System.out.println("Estado inicial del array (Merge Sort Iterativo):");
        imprimirArray(array);
        System.out.println("Iniciando proceso de ordenacion...");
        ordenarIterativo(array);
        System.out.println("Proceso finalizado. Estado final del array:");
        imprimirArray(array);
    }

    public static void ordenarIterativo(int[] array) {
        int n = array.length;
        for (int tamano = 1; tamano < n; tamano *= 2) {
            System.out.println("--- Iniciando ciclo externo: tamano de sub-arrays a evaluar = " + tamano + " ---");
            for (int izquierda = 0; izquierda < n - tamano; izquierda += 2 * tamano) {
                int medio = izquierda + tamano - 1;
                int derecha = Math.min(izquierda + 2 * tamano - 1, n - 1);
                
                System.out.println("Definiendo limites para fusion: izquierda=" + izquierda + ", medio=" + medio + ", derecha=" + derecha);
                fusionar(array, izquierda, medio, derecha);
            }
        }
    }

    private static void fusionar(int[] array, int izquierda, int medio, int derecha) {
        int tamanoIzquierda = medio - izquierda + 1;
        int tamanoDerecha = derecha - medio;
        
        int[] mitadIzquierda = new int[tamanoIzquierda];
        int[] mitadDerecha = new int[tamanoDerecha];
        
        System.out.println("Copiando datos a sub-arrays temporales de tamanos " + tamanoIzquierda + " y " + tamanoDerecha);
        for (int i = 0; i < tamanoIzquierda; i++) {
            mitadIzquierda[i] = array[izquierda + i];
        }
        for (int i = 0; i < tamanoDerecha; i++) {
            mitadDerecha[i] = array[medio + 1 + i];
        }
        
        int i = 0;
        int j = 0;
        int k = izquierda;
        
        while (i < tamanoIzquierda && j < tamanoDerecha) {
            System.out.println("Comparando mitadIzquierda[" + i + "] (" + mitadIzquierda[i] + ") <= mitadDerecha[" + j + "] (" + mitadDerecha[j] + ")");
            if (mitadIzquierda[i] <= mitadDerecha[j]) {
                System.out.println("Resultado verdadero: reescribiendo array[" + k + "] con valor " + mitadIzquierda[i]);
                array[k] = mitadIzquierda[i];
                i++;
            } else {
                System.out.println("Resultado falso: reescribiendo array[" + k + "] con valor " + mitadDerecha[j]);
                array[k] = mitadDerecha[j];
                j++;
            }
            k++;
        }
        
        if (i < tamanoIzquierda) {
            System.out.println("Copiando los elementos restantes de la mitad izquierda...");
        }
        while (i < tamanoIzquierda) {
            System.out.println("Reescribiendo array[" + k + "] con valor " + mitadIzquierda[i]);
            array[k] = mitadIzquierda[i];
            i++;
            k++;
        }
        
        if (j < tamanoDerecha) {
            System.out.println("Copiando los elementos restantes de la mitad derecha...");
        }
        while (j < tamanoDerecha) {
            System.out.println("Reescribiendo array[" + k + "] con valor " + mitadDerecha[j]);
            array[k] = mitadDerecha[j];
            j++;
            k++;
        }
        System.out.println("Array despues de la fusion parcial:");
        imprimirArray(array);
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