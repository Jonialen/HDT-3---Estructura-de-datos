public interface SortAlgorithm {
    <T extends Comparable<T>> void sort(T[] arr);

    default <T> void swap(T[] arr, int i, int j) {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
