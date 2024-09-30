package ru.nsu.zarcer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExpressionTest {
    @Test
    void evalTest() {
        Mul test = new Mul(new Number(3), new Number(4));
        int result = test.eval("x = 10");
        assertEquals(12, result);
    }

}