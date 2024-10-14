package ru.nsu.zarcer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class AddTest {
    @Test
    void derivateTest() {
        Add test = new Add(new Variable("x"), new Number(2));
        Add derivateTest = new Add(new Number(1), new Number(0));
        Add zero = (Add) test.derivate("x");
        assertTrue(derivateTest.equals(zero));
    }

    @Test
    void evalTest() {
        Expression e = new Add(new Variable("x"), new Number(2));
        int resultTest = e.eval("x = 10");
        assertEquals(12, resultTest);
    }

    @Test
    void toStringTest() {
        Expression test = new Add(new Number(1), new Number(2));
        String stringTest = test.toString();
        assertEquals("(1+2)", stringTest);
    }

    @Test
    void cutTest() {
        Expression e = new Add(new Number(3), new Number(5));
        Expression cuted = e.cut();
        assertEquals(cuted, new Number(8));
    }

    @Test
    void checkVariableTest() {
        Expression e = new Add(new Number(3), new Number(5));
        assertFalse(e.checkVariable());
    }
}