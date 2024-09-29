package ru.nsu.zarcer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SubTest {
    @Test
    void derivateTest() {
        Sub test = new Sub(new Variable("x"), new Number(2));
        Sub derivateTest = new Sub(new Number(1), new Number(0));
        Sub zero = (Sub)test.derivate("x");
        Number value1Der = (Number)derivateTest.getFirst();
        Number value2Der = (Number)derivateTest.getSecond();
        Number value1Zer = (Number)zero.getFirst();
        Number value2Zer = (Number)zero.getSecond();
        assertTrue(value1Der.getValue()==value1Zer.getValue()&&value2Der.getValue()==value2Zer.getValue());
    }

    @Test
    void evalTest() {
        Expression e = new Sub(new Variable("x"), new Number(2));
        int resultTest = e.eval("x = 10");
        assertEquals(8, resultTest);
    }

}