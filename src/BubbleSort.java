
public class BubbleSort<T extends Comparable<T>> {
    public void sort(int[] arrCopyBubble) {
        int n = arrCopyBubble.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arrCopyBubble[j] > arrCopyBubble[j + 1]) {
                    swap(arrCopyBubble, j, j + 1);
                }
            }
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
