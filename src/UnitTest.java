import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class UnitTest {

    @Test
    void testBubbleSort() {
        int[] arr = { 64, 34, 25, 12, 22, 11, 90 };
        int[] expected = { 11, 12, 22, 25, 34, 64, 90 };
        BubbleSort<Integer> bubbleSort = new BubbleSort<>();
        bubbleSort.sort(arr);
        assertArrayEquals(expected, arr);
    }

    @Test
    void testGnomeSort() {
        int[] arr = { 64, 34, 25, 12, 22, 11, 90 };
        int[] expected = { 11, 12, 22, 25, 34, 64, 90 };
        GnomeSort gnomeSort = new GnomeSort();
        gnomeSort.sort(arr);
        assertArrayEquals(expected, arr);
    }

    @Test
    void testMergeSort() {
        int[] arr = { 64, 34, 25, 12, 22, 11, 90 };
        int[] expected = { 11, 12, 22, 25, 34, 64, 90 };
        MergeSort mergeSort = new MergeSort();
        mergeSort.sort(arr);
        assertArrayEquals(expected, arr);
    }

    @Test
    void testQuickSort() {
        Integer[] arr = { 64, 34, 25, 12, 22, 11, 90 };
        Integer[] expected = { 11, 12, 22, 25, 34, 64, 90 };
        QuickSort quickSort = new QuickSort();
        quickSort.sort(arr);
        assertArrayEquals(expected, arr);
    }

    @Test
    void testRadixSort() {
        int[] arr = { 170, 45, 75, 90, 802, 24, 2, 66 };
        int[] expected = { 2, 24, 45, 66, 75, 90, 170, 802 };
        RadixSort radixSort = new RadixSort();
        radixSort.sort(arr);
        assertArrayEquals(expected, arr);
    }
}
