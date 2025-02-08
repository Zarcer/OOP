package ru.nsu.zarcer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PrimeOperationsTest {
    @Test
    public void isNotPrimeTest() {
        assertTrue(PrimeOperations.isNotPrime(6));
        assertFalse(PrimeOperations.isNotPrime(5));
    }

    @Test
    public void primeGeneratorTest(){
        int[] test = PrimeOperations.primeGenerator(5);
        int[] testing = {5, 3, 2};
        assertArrayEquals(test, testing);
    }

}