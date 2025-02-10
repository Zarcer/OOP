package ru.nsu.zarcer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NotPrimeFinderParallelStreamTest {
    @Test
    public void ParallelStreamFalse() {
        int[] test = {3, 5, 7};
        assertFalse(new NotPrimeFinderParallelStream().checkNonPrime(test));
    }

    @Test
    public void ParallelStreamTrue() {
        int[] test = {3, 6, 5};
        assertTrue(new NotPrimeFinderParallelStream().checkNonPrime(test));
    }

    @Test
    public void ParallelStreamSameNumbersFalse() {
        int[] test = {3, 3, 3, 3, 3, 3, 3};
        assertFalse(new NotPrimeFinderParallelStream().checkNonPrime(test));
    }

    @Test
    public void ParallelStreamSameNumbersTrue() {
        int[] test = {6, 6, 6, 6, 6, 6, 6};
        assertTrue(new NotPrimeFinderParallelStream().checkNonPrime(test));
    }

    @Test
    public void ParallelStreamZeros() {
        int[] test = {0, 0, 0, 0, 0, 0, 0};
        assertTrue(new NotPrimeFinderParallelStream().checkNonPrime(test));
    }

    @Test
    public void ParallelStreamOnes() {
        int[] test = {1, 1, 1, 1, 1, 1, 1};
        assertTrue(new NotPrimeFinderParallelStream().checkNonPrime(test));
    }
}