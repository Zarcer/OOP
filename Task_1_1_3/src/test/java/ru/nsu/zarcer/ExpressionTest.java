package ru.nsu.zarcer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class ExpressionTest {
    @Test
    void evalTest() {
        Mul test = new Mul(new Number(3), new Number(4));
        int result = test.eval("x = 10");
        assertEquals(12, result);
    }

    @Test
    void checkAndFinaleTest(){
        Expression first = new Number(3);
        Expression second = new Number(4);
        Mul test = new Mul(first, second);
        assertEquals(new Number(12), test.checkAndFinale(first, second));
    }

}