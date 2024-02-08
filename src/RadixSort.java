import java.util.Arrays;

/**
 * Clase que implementa el algoritmo de ordenamiento Radix Sort.
 * 
 * <p>
 * El Radix Sort es un algoritmo de ordenamiento no comparativo que ordena los
 * elementos por sus dígitos individuales, comenzando por el dígito menos
 * significativo y moviéndose hacia el más significativo. Utiliza el método de
 * ordenamiento por conteo para ordenar los dígitos.
 * </p>
 * 
 * <p>
 * Programadores: Anggie Quezada y Jonathan Diaz
 * </p>
 */
class RadixSort {
    public void sort(int[] arr) {
        if (arr.length == 0)
            return;
        int max = Arrays.stream(arr).max().getAsInt();
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countSort(arr, exp);
        }
    }

    private void countSort(int[] arr, int exp) {
        int n = arr.length;
        int[] output = new int[n];
        int[] count = new int[10];

        for (int i = 0; i < n; i++) {
            count[(arr[i] / exp) % 10]++;
        }

        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        for (int i = n - 1; i >= 0; i--) {
            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
        }

        System.arraycopy(output, 0, arr, 0, n);
    }
}