package ru.nsu.zarcer;

import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.jupiter.api.Assertions.*;

class PrimeCoreTest {
    @Test
    public void CoreTest(){
        int[] testFirst = {2, 3, 5};
        int [] testSecond = {2, 3, 6};
        AtomicInteger first = new AtomicInteger(0);
        AtomicInteger second = new AtomicInteger(0);
        PrimeCore firstCore = new PrimeCore(testFirst, first, testFirst.length);
        PrimeCore secondCore = new PrimeCore(testSecond, second, testSecond.length);
        firstCore.start();
        secondCore.start();
        try{
            firstCore.join();
            secondCore.join();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        assertFalse(firstCore.notPrimeFoundGetter());
        assertTrue(secondCore.notPrimeFoundGetter());

    }

}