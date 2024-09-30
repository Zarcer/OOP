package ru.nsu.zarcer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    @Test
    void parseTest() {
        Expression test = Main.parseIntoExpr("(((6/2)*3)+2)");
        int result = test.eval("x = 10");
        assertEquals(11, result);
    }

}