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


}