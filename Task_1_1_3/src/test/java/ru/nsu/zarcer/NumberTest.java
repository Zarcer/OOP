package ru.nsu.zarcer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class NumberTest {
    @Test
    void derivateTesting() {
        Number test = new Number(5);
        Number testDerivate = (Number)test.derivate("x");
        Number testZero = new Number(0);
        assertTrue(testDerivate.equals(testZero));
    }

    @Test
    void evalTest() {
        Number test = new Number(5);
        assertEquals(5, test.eval("x = 10"));
    }

    @Test
    void toStringTest() {
        Expression test = new Number(5);
        String stringTest = test.toString();
        assertEquals("5", stringTest);
    }


}