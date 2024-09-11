package ru.nsu.zarcer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HeapSortTest {
    @Test
    void ordinarysort() {
        int arr[] = new int[] {5, 4, 3, 2, 1};
        HeapSort.heapsort(arr);
        assertArrayEquals(new int[] {1, 2, 3, 4, 5}, arr);
    }

    @Test
    void AlreadySorted() {
        int arr[] = new int[] {1, 2, 3, 4, 5};
        HeapSort.heapsort(arr);
        assertArrayEquals(new int[] {1, 2, 3, 4, 5}, arr);
    }

    @Test
    void ZeroArray() {
        int arr[] = new int[] {0, 0, 0, 0, 0};
        HeapSort.heapsort(arr);
        assertArrayEquals(new int[] {0, 0, 0, 0, 0}, arr);
    }

    @Test
    void SingleElement() {
        int arr[] = new int[] {99};
        HeapSort.heapsort(arr);
        assertArrayEquals(new int[] {99}, arr);
    }

    @Test
    void TestHeapify() {
        int arr[] = new int[] {4, 10, 3, 5, 1};
        int n = arr.length;
        for(int i = n/2-1; i>=0;i--) {
            HeapSort.heapify(arr, n, i);
        }
        assertArrayEquals(new int[] {10, 5, 3, 4, 1}, arr);
    }

    @Test
    void Duplicates() {
        int arr[] = new int[] {5, 5, 3, 3, 1};
        HeapSort.heapsort(arr);
        assertArrayEquals(new int[] {1, 3, 3, 5, 5}, arr);
    }

    @Test
    void AllNegatives() {
        int arr[] = new int[] {-1, -4, -3, -2, -5};
        HeapSort.heapsort(arr);
        assertArrayEquals(new int[] {-5, -4, -3, -2, -1}, arr);
    }

    @Test
    void MixedNegative() {
        int arr[] = new int[] {-5, 5, 1, -7, 2};
        HeapSort.heapsort(arr);
        assertArrayEquals(new int[] {-7, -5, 1, 2, 5}, arr);
    }


}