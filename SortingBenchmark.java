class SortingBenchmark {
    private static final int NUMBERS_COUNT = 3000;
    private static final String FILE_NAME = "random_numbers.txt";

    public void runBenchmark() {
        generateRandomNumbers(FILE_NAME, NUMBERS_COUNT);
        int[] numbers = readNumbersFromFile(FILE_NAME);

        GnomeSort gnomeSort = new GnomeSort();
        long gnomeSortTime = measureTime(() -> gnomeSort.sort(numbers.clone()));

        MergeSort mergeSort = new MergeSort();
        long mergeSortTime = measureTime(() -> mergeSort.sort(numbers.clone()));

        QuickSort quickSort = new QuickSort();
        long quickSortTime = measureTime(() -> quickSort.sort(numbers.clone()));

        RadixSort radixSort = new RadixSort();
        long radixSortTime = measureTime(() -> radixSort.sort(numbers.clone()));

        printSortingTimes(gnomeSortTime, mergeSortTime, quickSortTime, radixSortTime);
    }

    private void generateRandomNumbers(String fileName, int count) {
        try (PrintWriter writer = new PrintWriter(fileName)) {
            for (int i = 0; i < count; i++) {
                writer.println((int) (Math.random() * 1000)); // Genera números aleatorios entre 0 y 999
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private int[] readNumbersFromFile(String fileName) {
        int[] numbers = new int[NUMBERS_COUNT];
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            int index = 0;
            while ((line = reader.readLine()) != null) {
                numbers[index++] = Integer.parseInt(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return numbers;
    }

    private long measureTime(Runnable task) {
        long startTime = System.nanoTime();
        task.run();
        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000; // Convertir a milisegundos
    }

    private void printSortingTimes(long gnomeSortTime, long mergeSortTime, long quickSortTime, long radixSortTime) {
        System.out.println("Gnome Sort Time: " + gnomeSortTime + " milliseconds");
        System.out.println("Merge Sort Time: " + mergeSortTime + " milliseconds");
        System.out.println("Quick Sort Time: " + quickSortTime + " milliseconds");
        System.out.println("Radix Sort Time: " + radixSortTime + " milliseconds");
    }
}
