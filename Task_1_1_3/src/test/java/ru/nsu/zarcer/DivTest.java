package ru.nsu.zarcer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class DivTest {
    @Test
    void derivateTest() {
        Div test = new Div(new Number(6), new Number(2));
        Div zero = (Div) test.derivate("x");
        Div afterDer = new Div(new Sub(new Mul(new Number(0), new Number(2)),
                new Mul(new Number(6),
                        new Number(0))), new Mul(new Number(2), new Number(2)));
        assertTrue(zero.equals(afterDer));
    }

    @Test
    void evalTest() {
        Div test = new Div(new Variable("x"), new Number(2));
        int resultTest = test.eval("x = 10");
        assertEquals(5, resultTest);
    }

    @Test
    void toStringTest() {
        Expression test = new Div(new Number(6), new Number(2));
        String stringTest = test.toString();
        assertEquals("(6/2)", stringTest);
    }

    @Test
    void cutTest() {
        Expression e = new Div(new Number(6), new Number(2));
        Expression cuted = e.cut();
        assertEquals(cuted, new Number(3));
    }

    @Test
    void checkVariableTest() {
        Expression e = new Div(new Number(6), new Number(2));
        assertFalse(e.checkVariable());
    }
}