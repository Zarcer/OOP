package ru.nsu.zarcer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    @Test
    void SampleTest() {
        assertEquals(3, Main.sum(1, 2));
    }

    @Test
    void ZeroTest() {
        assertEquals(0, Main.sum(0, 0));
    }

    @Test
    void MinusTest() {
        assertEquals(-5, Main.sum(-5, 0));
    }
}