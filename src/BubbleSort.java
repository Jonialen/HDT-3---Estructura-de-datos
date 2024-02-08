/**
 * Clase que implementa el algoritmo de ordenamiento Bubble Sort.
 * 
 * <p>
 * El Bubble Sort es un algoritmo simple de ordenamiento que compara pares de
 * elementos adyacentes y los intercambia si están en el orden incorrecto.
 * Este proceso se repite hasta que no se requieran más intercambios, lo que
 * indica que el arreglo está ordenado.
 * </p>
 * 
 * <p>
 * Programadores: Anggie Quezada y Jonathan Diaz
 * </p>
 *
 * @param <T> Tipo de datos que se pueden ordenar con este algoritmo.
 */
public class BubbleSort<T extends Comparable<T>> {
    /**
     * Ordena el arreglo dado utilizando el algoritmo Bubble Sort.
     * 
     * @param arrCopyBubble Arreglo que se va a ordenar.
     */
    public void sort(int[] arrCopyBubble) {
        int n = arrCopyBubble.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arrCopyBubble[j] > arrCopyBubble[j + 1]) {
                    swap(arrCopyBubble, j, j + 1);
                }
            }
        }
    }

    /**
     * Intercambia dos elementos en el arreglo.
     * 
     * @param arr Arreglo en el que se van a intercambiar los elementos.
     * @param i   Índice del primer elemento a intercambiar.
     * @param j   Índice del segundo elemento a intercambiar.
     */
    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
