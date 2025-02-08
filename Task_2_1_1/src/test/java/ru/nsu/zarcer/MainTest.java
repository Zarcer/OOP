package ru.nsu.zarcer;

import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    @Test
    public void consistentTest(){
        ArrayDeque<Integer> test = new ArrayDeque<>();
        test.push(3);
        test.push(5);
        assertFalse(Main.consistent(test));
        test.push(6);
        assertTrue(Main.consistent(test));
    }

    @Test
    public void consistentThreadsTest() {
        ArrayDeque<Integer> test = new ArrayDeque<>();
        test.push(3);
        test.push(5);
        try{
            assertFalse(Main.consistentThreads(test, 4));
            test.push(6);
            assertTrue(Main.consistentThreads(test, 4));
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void parallelsStreamTest() {
        ArrayDeque<Integer> test = new ArrayDeque<>();
        test.push(3);
        test.push(5);
        assertFalse(Main.parallelsStreamPrime(test));
        test.push(6);
        assertTrue(Main.parallelsStreamPrime(test));
    }

    @Test
    public void isNotPrimeTest() {
        assertTrue(Main.isNotPrime(6));
        assertFalse(Main.isNotPrime(5));
    }

    @Test
    public void primeGeneratorTest(){
        ArrayDeque<Integer> test = Main.primeGenerator(5);
        ArrayDeque<Integer> testing = new ArrayDeque<>();
        testing.push(2);
        testing.push(3);
        testing.push(5);
        assertEquals(new ArrayList<>(test), new ArrayList<>(testing));
    }
}