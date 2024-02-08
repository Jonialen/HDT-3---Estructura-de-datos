/**
 * Clase que implementa el algoritmo de ordenamiento Quick Sort.
 * 
 * <p>
 * El Quick Sort es un algoritmo de ordenamiento eficiente que utiliza el
 * enfoque de dividir y conquistar. Selecciona un elemento pivote y reorganiza
 * los elementos del arreglo de manera que los elementos menores al pivote
 * estén a su izquierda y los mayores a su derecha. Luego, aplica recursión
 * sobre los subarreglos izquierdo y derecho del pivote.
 * </p>
 * 
 * <p>
 * Programadores: Anggie Quezada y Jonathan Diaz
 * </p>
 */
public class QuickSort implements SortAlgorithm {
    @Override
    public <T extends Comparable<T>> void sort(T[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    private <T extends Comparable<T>> void sort(T[] arr, int low, int high) {
        if (low < high) {
            int partitionIndex = partition(arr, low, high);

            sort(arr, low, partitionIndex - 1);
            sort(arr, partitionIndex + 1, high);
        }
    }

    private <T extends Comparable<T>> int partition(T[] arr, int low, int high) {
        T pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j].compareTo(pivot) <= 0) {
                i++;
                swap(arr, i, j);
            }
        }

        swap(arr, i + 1, high);
        return i + 1;
    }
}
