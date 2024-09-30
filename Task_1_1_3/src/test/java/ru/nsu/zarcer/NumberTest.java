package ru.nsu.zarcer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumberTest {
    @Test
    void methodsTesting() {
        Number test = new Number(5);
        assertEquals(5, test.eval("x = 10"));
        Number testDerivate = (Number)test.derivate("x");
        Number testZero = new Number(0);
        assertTrue(testDerivate.equals(testZero));
    }
}