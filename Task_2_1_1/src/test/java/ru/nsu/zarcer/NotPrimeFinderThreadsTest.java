package ru.nsu.zarcer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NotPrimeFinderThreadsTest {

    @Test
    public void consistentThreadsTestFalse() {
        int[] test = {3, 5, 7};
        assertFalse(new NotPrimeFinderThreads(4).checkNonPrime(test));
    }

    @Test
    public void consistentThreadsTestTrue() {
        int[] test = {3, 6, 5};
        assertTrue(new NotPrimeFinderThreads(4).checkNonPrime(test));
    }

    @Test
    public void consistentThreadsTestSameNumbersFalse() {
        int[] test = {3, 3, 3, 3, 3, 3, 3};
        assertFalse(new NotPrimeFinderThreads(4).checkNonPrime(test));
    }

    @Test
    public void consistentThreadsTestSameNumbersTrue() {
        int[] test = {6, 6, 6, 6, 6, 6, 6};
        assertTrue(new NotPrimeFinderThreads(4).checkNonPrime(test));
    }

    @Test
    public void consistentThreadsTestZeros() {
        int[] test = {0, 0, 0, 0, 0, 0, 0};
        assertTrue(new NotPrimeFinderThreads(4).checkNonPrime(test));
    }

    @Test
    public void consistentThreadsTestOnes() {
        int[] test = {1, 1, 1, 1, 1, 1, 1};
        assertTrue(new NotPrimeFinderThreads(4).checkNonPrime(test));
    }
}