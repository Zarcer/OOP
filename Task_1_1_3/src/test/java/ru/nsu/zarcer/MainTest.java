package ru.nsu.zarcer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class MainTest {
    @Test
    void parseTest() {
        Expression test = Main.parseIntoExpr("(((6/2)*3)+2)");
        int result = test.eval("x = 10");
        assertEquals(11, result);
    }

}