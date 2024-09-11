package ru.nsu.zarcer;


public class HeapSort {
    /**
     * Sort process
     *
     * @param arr array
     */
    public static void heapsort(int[] arr) {
        int length = arr.length;
        for (int i = length / 2 - 1; i >= 0; i--) {
            heapify(arr, length, i);
        }
        for (int i = length - 1; i >= 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapify(arr, i, 0);
        }
    }
    /**
     * Transform array into a heap
     *
     * @param arr array
     *
     * @param length variable
     *
     * @param i variable
     */
    static void heapify(int[] arr, int length, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        if (left < length && arr[left] > arr[largest]) {
            largest = left;
        }
        if (right < length && arr[right] > arr[largest]) {
            largest = right;
        }
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
            heapify(arr, length, largest);
        }
    }

    /**
     * Starts sorting and prints final array
     *
     * @param args variable
     */
    public static void main(String[] args) {
        int[] arr = new int[]{5, 4, 3, 2, 1};
        int length = arr.length;
        heapsort(arr);
        System.out.print("[");
        for (int i = 0; i < length; i++) {
            if (i == length - 1) {
                System.out.print(arr[i] + "]");
                break;
            }
            System.out.print(arr[i] + ", ");
        }
    }
}