package ru.nsu.zarcer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class VariableTest {
    @Test
    void methodsTesting() {
        Variable first = new Variable("x");
        Variable second = new Variable("y");
        Expression testing = new Add(first, second);
        Add testingDerivate = (Add) testing.derivate("x");
        Add afterTesting = new Add(new Number(1), new Number(0));
        assertTrue(testingDerivate.equals(afterTesting));
    }

    @Test
    void evalTesting() {
        Variable first = new Variable("x");
        Variable second = new Variable("y");
        Expression testing = new Add(first, second);
        int result = testing.eval("x = 10; y = 15");
        assertEquals(25, result);
    }

    @Test
    void toStringTest() {
        Expression test = new Variable("x");
        String stringTest = test.toString();
        assertEquals("x", stringTest);
    }

    @Test
    void cutTest() {
        Expression e = new Variable("x");
        Expression cuted = e.cut();
        assertEquals(cuted, new Variable("x"));
    }

    @Test
    void checkVariableTest() {
        Expression e = new Variable("x");
        assertTrue(e.checkVariable());
    }
}