package ru.nsu.zarcer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MulTest {
    @Test
    void derivateTest() {
        Mul test = new Mul(new Variable("x"), new Number(2));
        Add derivateTest = new Add(new Mul(new Number(1), new Number(2)), new Mul(new Variable("x"), new Number(0)));
        Add zero = (Add)test.derivate("x");
        assertTrue(derivateTest.equals(zero));
    }

    @Test
    void evalTest() {
        Expression e = new Mul(new Variable("x"), new Number(2));
        int resultTest = e.eval("x = 10");
        assertEquals(20, resultTest);
    }

}