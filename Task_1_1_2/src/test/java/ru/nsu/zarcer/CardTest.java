package ru.nsu.zarcer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class CardTest {

    @Test
    void cardcreationtest() {
        Card testingCard = new Card("Проверка", 1);
        assertEquals(1, testingCard.getPoints());
        assertFalse(testingCard.getTaken());
        assertEquals("Проверка", testingCard.getName());
    }

    @Test
    void setNameTest() {
        Card testingCard = new Card("Проверка", 1);
        testingCard.setName("Совпадает");
        assertEquals("Совпадает", testingCard.getName());
    }

    @Test
    void setPointsTest() {
        Card testingCard = new Card("Проверка", 1);
        testingCard.setPoints(10);
        assertEquals(10, testingCard.getPoints());
    }

    @Test
    void setTakenTest() {
        Card testingCard = new Card("Проверка", 1);
        testingCard.setTaken(true);
        assertTrue(testingCard.getTaken());
    }

    @Test
    void getNameTest() {
        Card testingCard = new Card("Проверка", 1);
        assertEquals("Проверка", testingCard.getName());
    }

    @Test
    void getPointsTest() {
        Card testingCard = new Card("Проверка", 1);
        assertEquals(1, testingCard.getPoints());
    }

    @Test
    void getTakenTest() {
        Card testingCard = new Card("Проверка", 1);
        assertFalse(testingCard.getTaken());
    }


}