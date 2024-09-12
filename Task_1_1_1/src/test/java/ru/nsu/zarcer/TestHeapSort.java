package ru.nsu.zarcer;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

/**
 * Tests.
 */

class TestHeapSort {

    @Test
    void ordinarySort() {
        int[] arr = new int[]{5, 4, 3, 2, 1};
        HeapSort.heapsort(arr);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, arr);
    }

    @Test
    void alreadySorted() {
        int[] arr = new int[]{1, 2, 3, 4, 5};
        HeapSort.heapsort(arr);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, arr);
    }

    @Test
    void zeroArray() {
        int[] arr = new int[]{0, 0, 0, 0, 0};
        HeapSort.heapsort(arr);
        assertArrayEquals(new int[]{0, 0, 0, 0, 0}, arr);
    }

    @Test
    void singleElement() {
        int[] arr = new int[]{99};
        HeapSort.heapsort(arr);
        assertArrayEquals(new int[]{99}, arr);
    }

    @Test
    void heapify() {
        int[] arr = new int[]{4, 10, 3, 5, 1};
        int n = arr.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            HeapSort.heapify(arr, n, i);
        }
        assertArrayEquals(new int[]{10, 5, 3, 4, 1}, arr);
    }

    @Test
    void duplicates() {
        int[] arr = new int[]{5, 5, 3, 3, 1};
        HeapSort.heapsort(arr);
        assertArrayEquals(new int[]{1, 3, 3, 5, 5}, arr);
    }

    @Test
    void allNegatives() {
        int[] arr = new int[]{-1, -4, -3, -2, -5};
        HeapSort.heapsort(arr);
        assertArrayEquals(new int[]{-5, -4, -3, -2, -1}, arr);
    }

    @Test
    void mixedNegative() {
        int[] arr = new int[]{-5, 5, 1, -7, 2};
        HeapSort.heapsort(arr);
        assertArrayEquals(new int[]{-7, -5, 1, 2, 5}, arr);
    }

    @Test
    void empty() {
        int[] arr = new int[]{};
        HeapSort.heapsort(arr);
        assertArrayEquals(new int[]{}, arr);
    }

    @Test
    void mainTest() {
        HeapSort.main(null);
        assertTrue(true);
    }


}