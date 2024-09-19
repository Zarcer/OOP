package ru.nsu.zarcer;

import org.junit.jupiter.api.Assertions;
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

    @Test
    void setNameTest() {
        Card TestingCard = new Card("Проверка", 1);
        TestingCard.setName("Совпадает");
        assertEquals("Совпадает", TestingCard.getName());
    }

    @Test
    void setPointsTest() {
        Card TestingCard = new Card("Проверка", 1);
        TestingCard.setPoints(10);
        assertEquals(10, TestingCard.getPoints());
    }

    @Test
    void setTakenTest() {
        Card TestingCard = new Card("Проверка", 1);
        TestingCard.setTaken(true);
        assertTrue(TestingCard.getTaken());
    }

    @Test
    void getNameTest() {
        Card TestingCard = new Card("Проверка", 1);
        assertEquals("Проверка", TestingCard.getName());
    }

    @Test
    void getPointsTest() {
        Card TestingCard = new Card("Проверка", 1);
        assertEquals(1, TestingCard.getPoints());
    }

    @Test
    void getTakenTest() {
        Card TestingCard = new Card("Проверка", 1);
        assertFalse(TestingCard.getTaken());
    }



}