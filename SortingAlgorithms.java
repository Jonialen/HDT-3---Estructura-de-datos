import java.util.Arrays;
import java.util.Random;

public class SortingAlgorithms {
    // Implementación de Gnome sort
    public static <T extends Comparable<T>> void gnomeSort(T[] arr) {
        int index = 0;
        while (index < arr.length) {
            if (index == 0 || arr[index].compareTo(arr[index - 1]) >= 0) {
                index++;
            } else {
                swap(arr, index, index - 1);
                index--;
            }
        }
    }

    // Implementación de Merge sort
    public static <T extends Comparable<T>> void mergeSort(T[] arr) {
        if (arr.length > 1) {
            int mid = arr.length / 2;
            T[] leftArray = Arrays.copyOfRange(arr, 0, mid);
            T[] rightArray = Arrays.copyOfRange(arr, mid, arr.length);

            mergeSort(leftArray);
            mergeSort(rightArray);

            merge(arr, leftArray, rightArray);
        }
    }

    private static <T extends Comparable<T>> void merge(T[] arr, T[] left, T[] right) {
        int leftIndex = 0, rightIndex = 0, mergedIndex = 0;

        while (leftIndex < left.length && rightIndex < right.length) {
            if (left[leftIndex].compareTo(right[rightIndex]) <= 0) {
                arr[mergedIndex++] = left[leftIndex++];
            } else {
                arr[mergedIndex++] = right[rightIndex++];
            }
        }

        while (leftIndex < left.length) {
            arr[mergedIndex++] = left[leftIndex++];
        }

        while (rightIndex < right.length) {
            arr[mergedIndex++] = right[rightIndex++];
        }
    }

    // Implementación de Quick sort
    public static <T extends Comparable<T>> void quickSort(T[] arr, int low, int high) {
        if (low < high) {
            int partitionIndex = partition(arr, low, high);

            quickSort(arr, low, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, high);
        }
    }

    private static <T extends Comparable<T>> int partition(T[] arr, int low, int high) {
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

    // Implementación de Radix sort (para enteros)
    public static void radixSort(int[] arr) {
        if (arr.length == 0) return;

        int maxValue = Arrays.stream(arr).max().getAsInt();
        for (int exp = 1; maxValue / exp > 0; exp *= 10) {
            countSort(arr, exp);
        }
    }

    private static void countSort(int[] arr, int exp) {
        int n = arr.length;
        int[] output = new int[n];
        int[] count = new int[10];

        Arrays.fill(count, 0);

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

        for (int i = 0; i < n; i++) {
            arr[i] = output[i];
        }
    }

    // Método auxiliar para intercambiar elementos en un arreglo
    private static <T extends Comparable<T>> void swap(T[] arr, int i, int j) {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // Método para generar números aleatorios y guardarlos en un archivo
    public static void generateRandomNumbers(int count) {
        Random random = new Random();
        try (PrintWriter writer = new PrintWriter("random_numbers.txt")) {
            for (int i = 0; i < count; i++) {
                writer.println(random.nextInt());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método principal para ordenar los números y medir el tiempo de ejecución
    public static void main(String[] args) {
        int[] numbers = readNumbersFromFile("random_numbers.txt");
        int[] copyOfNumbers = Arrays.copyOf(numbers, numbers.length);

        long startTime = System.nanoTime();
        radixSort(numbers);
        long endTime = System.nanoTime();
        long duration = (endTime - startTime) / 1000000; // Convertir a milisegundos
        System.out.println("Radix Sort Time: " + duration + " milliseconds");

    }
}
