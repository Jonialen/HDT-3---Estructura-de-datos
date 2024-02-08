/**
 * Clase que implementa el algoritmo de ordenamiento Gnome Sort.
 * 
 * <p>
 * El Gnome Sort es un algoritmo de ordenamiento similar al Bubble Sort,
 * pero más eficiente en algunos casos. Recorre el arreglo desplazándose hacia
 * adelante o hacia atrás según sea necesario, comparando y moviendo los
 * elementos para ordenarlos correctamente.
 * </p>
 * 
 * <p>
 * Programadores: Anggie Quezada y Jonathan Diaz
 * </p>
 */
public class GnomeSort {
    /**
     * Ordena el arreglo dado utilizando el algoritmo Gnome Sort.
     * 
     * @param arr Arreglo que se va a ordenar.
     */
    public void sort(int[] arr) {
        int index = 0;
        while (index < arr.length) {
            if (index == 0 || arr[index] >= arr[index - 1]) {
                index++;
            } else {
                swap(arr, index, index - 1);
                index--;
            }
        }
    }

    /**
     * Intercambia dos elementos en el arreglo.
     * 
     * @param arr Arreglo en el que se van a intercambiar los elementos.
     * @param i   Índice del primer elemento a intercambiar.
     * @param j   Índice del segundo elemento a intercambiar.
     */
    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
