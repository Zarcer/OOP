package ru.nsu.zarcer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VariableTest {
    @Test
    void methodsTesting() {
        Variable first = new Variable("x");
        Variable second = new Variable("y");
        Expression testing = new Add(first, second);
        Add testingDerivate = (Add)testing.derivate("x");
        Add afterTesting = new Add(new Number(1), new Number(0));
        assertTrue(testingDerivate.equals(afterTesting));
        int result = testing.eval("x = 10; y = 15");
        assertEquals(25, result);
    }

}