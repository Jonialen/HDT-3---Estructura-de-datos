import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        GnomeSort gnomeSort = new GnomeSort();
        MergeSort mergeSort = new MergeSort();
        QuickSort quickSort = new QuickSort();
        RadixSort radixSort = new RadixSort();
        BubbleSort bubbleSort = new BubbleSort();
        int a;
        System.out.println("Iniciar ");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();

        for (int size = 10; size <= 3000; size++) {
            int[] arr = new int[size];
            for (int i = 0; i < size; i++) {
                arr[i] = random.nextInt(1000);
            }
            // Bubble Sort
            int[] arrCopyBubble = arr.clone();
            bubbleSort.sort(arrCopyBubble);

            // Gnome Sort
            int[] arrCopyGnome = arr.clone();
            gnomeSort.sort(arrCopyGnome);

            // Merge Sort
            int[] arrCopyMerge = arr.clone();
            mergeSort.sort(arrCopyMerge);

            // Quick Sort
            Integer[] arrCopyQuick = new Integer[arr.length];
            for (int i = 0; i < arr.length; i++) {
                arrCopyQuick[i] = arr[i];
            }
            quickSort.sort(arrCopyQuick);

            // Radix Sort
            int[] arrCopyRadix = arr.clone();
            radixSort.sort(arrCopyRadix);
        }
        System.out.println();
    }
}
