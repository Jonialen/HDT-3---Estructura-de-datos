public class Main {
    public static void main(String[] args) {
        int[] numbers = generateRandomNumbers(3000);

        GnomeSort gnomeSort = new GnomeSort();
        runSortAlgorithm("Gnome Sort", numbers.clone(), gnomeSort);

        MergeSort mergeSort = new MergeSort();
        runSortAlgorithm("Merge Sort", numbers.clone(), mergeSort);

        QuickSort quickSort = new QuickSort();
        runSortAlgorithm("Quick Sort", numbers.clone(), quickSort);

        RadixSort radixSort = new RadixSort();
        runRadixSort("Radix Sort", numbers.clone(), radixSort);
    }

    private static int[] generateRandomNumbers(int count) {
        int[] numbers = new int[count];
        for (int i = 0; i < count; i++) {
            numbers[i] = (int) (Math.random() * 1000); // Genera números aleatorios entre 0 y 999
        }
        return numbers;
    }

    private static void runSortAlgorithm(String algorithmName, int[] numbers, SortAlgorithm sortAlgorithm) {
        long startTime = System.nanoTime();
        sortAlgorithm.sort(numbers);
        long endTime = System.nanoTime();
        long duration = (endTime - startTime) / 1000000; // Convertir a milisegundos
        System.out.println(algorithmName + " Time: " + duration + " milliseconds");
    }

    private static void runRadixSort(String algorithmName, int[] numbers, RadixSort radixSort) {
        long startTime = System.nanoTime();
        radixSort.sort(numbers);
        long endTime = System.nanoTime();
        long duration = (endTime - startTime) / 1000000; // Convertir a milisegundos
        System.out.println(algorithmName + " Time: " + duration + " milliseconds");
    }
}
