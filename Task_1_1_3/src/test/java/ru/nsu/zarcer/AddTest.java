package ru.nsu.zarcer;

import org.junit.jupiter.api.Test;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;
class AddTest {
    @Test
    void derivateTest() {
        Add test = new Add(new Variable("x"), new Number(2));
        Add derivateTest = new Add(new Number(1), new Number(0));
        Add zero = (Add)test.derivate("x");
        assertTrue(derivateTest.equals(zero));
    }

    @Test
    void evalTest() {
        Expression e = new Add(new Variable("x"), new Number(2));
        int resultTest = e.eval("x = 10");
        assertEquals(12, resultTest);
    }
  
}