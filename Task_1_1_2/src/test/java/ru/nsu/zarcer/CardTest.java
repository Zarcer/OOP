package ru.nsu.zarcer;

import org.junit.jupiter.api.Test;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class CardTest {

    @Test
    void cardcreationtest() {
        Card TestingCard = new Card("Проверка", 1);
        assertEquals(1, TestingCard.getPoints());
        assertFalse(TestingCard.getTaken());
        assertEquals("Проверка", TestingCard.getName());
    }
}