package ru.nsu.zarcer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

class SubTest {
    @Test
    void derivateTest() {
        Sub test = new Sub(new Variable("x"), new Number(2));
        Sub derivateTest = new Sub(new Number(1), new Number(0));
        Sub zero = (Sub) test.derivate("x");
        assertTrue(derivateTest.equals(zero));
    }

    @Test
    void evalTest() {
        Expression e = new Sub(new Variable("x"), new Number(2));
        int resultTest = e.eval("x = 10");
        assertEquals(8, resultTest);
    }

    @Test
    void toStringTest() {
        Expression test = new Sub(new Number(3), new Number(2));
        String stringTest = test.toString();
        assertEquals("(3-2)", stringTest);
    }

    @Test
    void cutTest() {
        Expression e = new Sub(new Number(6), new Number(3));
        Expression cuted = e.cut();
        assertEquals(cuted, new Number(3));
        Expression test = new Add(new Variable("x"), new Sub(new Number(5), new Number(5)));
        assertEquals(new Add(new Variable("x"), new Number(0)), test.cut());
    }

    @Test
    void checkVariableTest() {
        Expression e = new Sub(new Number(6), new Number(3));
        assertFalse(e.checkVariable());
    }

}