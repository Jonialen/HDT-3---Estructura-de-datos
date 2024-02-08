/**
 * Interfaz que define un algoritmo de ordenamiento genérico.
 * 
 * <p>
 * Un algoritmo de ordenamiento debe implementar esta interfaz para asegurar
 * que proporciona un método para ordenar un arreglo genérico.
 * </p>
 * 
 * <p>
 * Programadores: Anggie Quezada y Jonathan Diaz
 * </p>
 */
public interface SortAlgorithm {
    /**
     * Ordena el arreglo dado utilizando el algoritmo específico.
     * 
     * @param <T> Tipo de datos del arreglo.
     * @param arr Arreglo que se va a ordenar.
     */
    <T extends Comparable<T>> void sort(T[] arr);

    /**
     * Intercambia dos elementos en el arreglo.
     * 
     * @param <T> Tipo de datos del arreglo.
     * @param arr Arreglo en el que se van a intercambiar los elementos.
     * @param i   Índice del primer elemento a intercambiar.
     * @param j   Índice del segundo elemento a intercambiar.
     */
    default <T> void swap(T[] arr, int i, int j) {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
