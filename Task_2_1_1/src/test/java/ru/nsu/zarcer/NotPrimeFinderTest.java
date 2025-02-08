package ru.nsu.zarcer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NotPrimeFinderTest {
    @Test
    public void consistentTest(){
        int[] test = {3, 5, 7};
        assertFalse(NotPrimeFinder.consistent(test));
        test[2] = 6;
        assertTrue(NotPrimeFinder.consistent(test));
    }

    @Test
    public void consistentThreadsTest() {
        int[] test = {3, 5, 7};
        try{
            assertFalse(NotPrimeFinder.consistentThreads(test, 4));
            test[2] = 6;
            assertTrue(NotPrimeFinder.consistentThreads(test, 4));
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void parallelsStreamTest() {
        int[] test = {3, 5, 7};
        assertFalse(NotPrimeFinder.parallelsStreamPrime(test));
        test[2] = 6;
        assertTrue(NotPrimeFinder.parallelsStreamPrime(test));
    }
}