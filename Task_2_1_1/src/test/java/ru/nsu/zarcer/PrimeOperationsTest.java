package ru.nsu.zarcer;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

class PrimeOperationsTest {
    @Test
    public void isNotPrimeTestTrue() {
        assertTrue(PrimeOperations.isNotPrime(6));
    }

    @Test
    public void isNotPrimeTestFalse() {
        assertFalse(PrimeOperations.isNotPrime(5));
    }

    @Test
    public void isNotPrimeTestZero() {
        assertTrue(PrimeOperations.isNotPrime(0));
    }

    @Test
    public void isNotPrimeTestOne() {
        assertTrue(PrimeOperations.isNotPrime(1));
    }

    @Test
    public void primeGeneratorTestOrdinary() {
        int[] test = PrimeOperations.primeGenerator(5);
        int[] testing = {5, 3, 2};
        assertArrayEquals(test, testing);
    }

    @Test
    public void primeGeneratorTestZero() {
        int[] test = PrimeOperations.primeGenerator(0);
        int[] testing = {};
        assertArrayEquals(test, testing);
    }

    @Test
    public void primeGeneratorTestOne() {
        int[] test = PrimeOperations.primeGenerator(1);
        int[] testing = {};
        assertArrayEquals(test, testing);
    }

    @Test
    public void countPrimeSpeedTest() {
        int[] test = {3, 5, 6};
        assertTrue(PrimeOperations.findNonPrimeCountSpeed(new NotPrimeFinderConsistent(), test) instanceof String);
    }


}