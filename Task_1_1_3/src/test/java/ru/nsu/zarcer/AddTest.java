package ru.nsu.zarcer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class AddTest {
    @Test
    void derivateTest() {
        Add test = new Add(new Variable("x"), new Number(2));
        Add derivateTest = new Add(new Number(1), new Number(0));
        Add zero = (Add)test.derivate("x");
        Number value1Der = (Number)derivateTest.getFirst();
        Number value2Der = (Number)derivateTest.getSecond();
        Number value1Zer = (Number)zero.getFirst();
        Number value2Zer = (Number)zero.getSecond();
        assertTrue(value1Der.getValue()==value1Zer.getValue()&&value2Der.getValue()==value2Zer.getValue());
    }

    @Test
    void evalTest() {
        Expression e = new Add(new Variable("x"), new Number(2));
        int resultTest = e.eval("x = 10");
        assertEquals(12, resultTest);
    }
  
}