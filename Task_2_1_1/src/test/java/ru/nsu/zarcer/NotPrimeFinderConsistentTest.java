package ru.nsu.zarcer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NotPrimeFinderConsistentTest {
    @Test
    public void ConsistentFalse() {
        int[] test = {3, 5, 7};
        assertFalse(new NotPrimeFinderConsistent().checkNonPrime(test));
    }

    @Test
    public void ConsistentTrue() {
        int[] test = {3, 6, 5};
        assertTrue(new NotPrimeFinderConsistent().checkNonPrime(test));
    }

    @Test
    public void ConsistentSameNumbersFalse() {
        int[] test = {3, 3, 3, 3, 3, 3, 3};
        assertFalse(new NotPrimeFinderConsistent().checkNonPrime(test));
    }

    @Test
    public void ConsistentSameNumbersTrue() {
        int[] test = {6, 6, 6, 6, 6, 6, 6};
        assertTrue(new NotPrimeFinderConsistent().checkNonPrime(test));
    }

    @Test
    public void ConsistentZeros() {
        int[] test = {0, 0, 0, 0, 0, 0, 0};
        assertTrue(new NotPrimeFinderConsistent().checkNonPrime(test));
    }

    @Test
    public void ConsistentOnes() {
        int[] test = {1, 1, 1, 1, 1, 1, 1};
        assertTrue(new NotPrimeFinderConsistent().checkNonPrime(test));
    }

}