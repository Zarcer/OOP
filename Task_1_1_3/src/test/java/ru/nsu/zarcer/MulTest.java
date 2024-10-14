package ru.nsu.zarcer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class MulTest {

    @Test
    void derivateTest() {
        Mul test = new Mul(new Variable("x"), new Number(2));
        Add derivateTest = new Add(new Mul(new Number(1), new Number(2)),
                new Mul(new Variable("x"), new Number(0)));
        Add zero = (Add) test.derivate("x");
        assertTrue(derivateTest.equals(zero));
    }

    @Test
    void evalTest() {
        Expression e = new Mul(new Variable("x"), new Number(2));
        int resultTest = e.eval("x = 10");
        assertEquals(20, resultTest);
    }

    @Test
    void toStringTest() {
        Expression test = new Mul(new Number(1), new Number(2));
        String stringTest = test.toString();
        assertEquals("(1*2)", stringTest);
    }

    @Test
    void cutTest() {
        Expression e = new Mul(new Number(6), new Number(2));
        Expression cuted = e.cut();
        assertEquals(cuted, new Number(12));
        Expression testFirst = new Add(new Variable("x"), new Mul(new Number(0), new Number(5)));
        assertEquals(new Add(new Variable("x"), new Number(0)), testFirst.cut());
        Expression testSecond = new Add(new Variable("x"), new Mul(new Number(1), new Number(5)));
        assertEquals(new Add(new Variable("x"), new Number(5)), testSecond.cut());
    }

    @Test
    void checkVariableTest() {
        Expression e = new Mul(new Number(6), new Number(2));
        assertFalse(e.checkVariable());
    }
}