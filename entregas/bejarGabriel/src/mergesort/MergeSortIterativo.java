public static void ordenarIterativo(int[] array) {
    int n = array.length;
    for (int tamano = 1; tamano < n; tamano *= 2) {
        for (int izquierda = 0; izquierda < n - tamano; izquierda += 2 * tamano) {
            int medio = izquierda + tamano - 1;
            int derecha = Math.min(izquierda + 2 * tamano - 1, n - 1);
            fusionar(array, izquierda, medio, derecha);
        }
    }
}