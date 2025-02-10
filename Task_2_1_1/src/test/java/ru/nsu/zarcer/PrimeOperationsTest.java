package ru.nsu.zarcer;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestTemplate;

import static org.junit.jupiter.api.Assertions.*;

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
    public void isNotPrimeTestZero(){
        assertTrue(PrimeOperations.isNotPrime(0));
    }

    @Test
    public void isNotPrimeTestOne(){
        assertTrue(PrimeOperations.isNotPrime(1));
    }

    @Test
    public void primeGeneratorTestOrdinary(){
        int[] test = PrimeOperations.primeGenerator(5);
        int[] testing = {5, 3, 2};
        assertArrayEquals(test, testing);
    }

    @Test
    public void primeGeneratorTestZero(){
        int[] test = PrimeOperations.primeGenerator(0);
        int[] testing = {};
        assertArrayEquals(test, testing);
    }

    @Test
    public void primeGeneratorTestOne(){
        int[] test = PrimeOperations.primeGenerator(1);
        int[] testing = {};
        assertArrayEquals(test, testing);
    }



}