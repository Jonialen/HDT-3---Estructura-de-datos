import java.io.*;
import java.util.Random;

/**
 * Clase principal que realiza la generación de números aleatorios, los escribe
 * en un archivo, los lee del archivo, los guarda en un array y los ordena
 * utilizando diferentes algoritmos de ordenamiento.
 * 
 * <p>
 * Programadores: Anggie Quezada y Jonathan Diaz
 * </p>
 */
public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        GnomeSort gnomeSort = new GnomeSort();
        MergeSort mergeSort = new MergeSort();
        QuickSort quickSort = new QuickSort();
        RadixSort radixSort = new RadixSort();
        BubbleSort bubbleSort = new BubbleSort();
        System.out.println("Iniciar ");

        // Generar y escribir números aleatorios en el archivo
        String filename = "random_numbers.txt";
        try (PrintWriter writer = new PrintWriter(filename)) {
            for (int i = 0; i < 3000; i++) {
                writer.println(random.nextInt(1000));
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error al escribir en el archivo.");
            return;
        }

        // Leer números del archivo y guardarlos en un array
        int[] arr = new int[3000];
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            int index = 0;
            while ((line = reader.readLine()) != null && index < 3000) {
                arr[index] = Integer.parseInt(line);
                index++;
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo.");
            return;
        }

        // Ordenar utilizando distintos algoritmos
        int[] arrCopyBubble = arr.clone();
        bubbleSort.sort(arrCopyBubble);

        int[] arrCopyGnome = arr.clone();
        gnomeSort.sort(arrCopyGnome);

        int[] arrCopyMerge = arr.clone();
        mergeSort.sort(arrCopyMerge);

        Integer[] arrCopyQuick = new Integer[arr.length];
        for (int i = 0; i < arr.length; i++) {
            arrCopyQuick[i] = arr[i];
        }
        quickSort.sort(arrCopyQuick);

        int[] arrCopyRadix = arr.clone();
        radixSort.sort(arrCopyRadix);

        System.out.println("Ordenamiento completado.");
    }
}
