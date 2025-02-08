package ru.nsu.zarcer;

import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;

import static org.junit.jupiter.api.Assertions.*;

class PrimeCoreTest {
    @Test
    public void CoreTest(){
        ArrayDeque<Integer> testFirst = new ArrayDeque<>();
        ArrayDeque<Integer> testSecond = new ArrayDeque<>();
        testSecond.push(3);
        testSecond.push(6);
        testFirst.push(3);
        testFirst.push(5);
        PrimeCore firstCore = new PrimeCore(testFirst);
        PrimeCore secondCore = new PrimeCore(testSecond);
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