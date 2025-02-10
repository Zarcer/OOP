package ru.nsu.zarcer;

import org.junit.jupiter.api.Test;

import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.jupiter.api.Assertions.*;

class PrimeCoreTest {
    @Test
    public void CoreTestFalse() {
        int[] testFirst = {2, 3, 5};;
        AtomicInteger first = new AtomicInteger(0);
        PrimeCore firstCore = new PrimeCore(testFirst, first, testFirst.length);
        firstCore.start();
        try{
            firstCore.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        assertFalse(firstCore.notPrimeFoundGetter());
    }

    @Test
    public void CoreTestTrue() {
        int[] testSecond = {2, 3, 6};
        AtomicInteger second = new AtomicInteger(0);
        PrimeCore secondCore = new PrimeCore(testSecond, second, testSecond.length);
        secondCore.start();
        try{
            secondCore.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        assertTrue(secondCore.notPrimeFoundGetter());
    }

    @Test
    public void CoreTestSameNumbersTrue() {
        int[] testSecond = {6, 6, 6, 6, 6, 6};
        AtomicInteger second = new AtomicInteger(0);
        PrimeCore secondCore = new PrimeCore(testSecond, second, testSecond.length);
        secondCore.start();
        try{
            secondCore.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        assertTrue(secondCore.notPrimeFoundGetter());
    }

    @Test
    public void CoreTestSameNumbersFalse() {
        int[] testSecond = {3, 3, 3, 3, 3, 3};
        AtomicInteger second = new AtomicInteger(0);
        PrimeCore secondCore = new PrimeCore(testSecond, second, testSecond.length);
        secondCore.start();
        try{
            secondCore.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        assertFalse(secondCore.notPrimeFoundGetter());
    }

    @Test
    public void CoreTestSameNumbersZeros() {
        int[] testSecond = {0, 0, 0, 0, 0, 0};
        AtomicInteger second = new AtomicInteger(0);
        PrimeCore secondCore = new PrimeCore(testSecond, second, testSecond.length);
        secondCore.start();
        try{
            secondCore.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        assertTrue(secondCore.notPrimeFoundGetter());
    }

}