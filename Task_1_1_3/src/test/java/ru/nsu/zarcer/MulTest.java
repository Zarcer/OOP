package ru.nsu.zarcer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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
    void  cutTest(){
        Expression e = new Mul(new Number(6), new Number(2));
        Expression cuted = e.cut();
        assertEquals(cuted, new Number(12));
    }

    @Test
    void checkVariableTest(){
        Expression e = new Mul(new Number(6), new Number(2));
        assertFalse(e.checkVariable());
    }
}