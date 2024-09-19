package ru.nsu.zarcer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class HandsTest {
    @Test
    void initializeTest() {
        Hand testinghand = new Hand();
        testinghand.initializeHand();
        assertEquals(0, testinghand.getNumberCards());
        for (int i = 0; i < 10; i++) {
            assertEquals(0, testinghand.getCard(i).getPoints());
        }
    }

    @Test
    void setCardTest() {
        Card testingcard = new Card("Проверка", 1);
        Hand testinghand = new Hand();
        testinghand.initializeHand();
        testinghand.setCard(testingcard, 0);
        assertEquals("Проверка", testinghand.getCard(0).getNamee());
        assertEquals(1, testinghand.getCard(0).getPoints());
    }

    @Test
    void lastCardTest() {
        Card testingcard1 = new Card("Проверка_1", 1);
        Card testingcard2 = new Card("Проверка_2", 2);
        Card testingcard3 = new Card("Проверка_3", 3);
        Hand testinghand = new Hand();
        testinghand.initializeHand();
        testinghand.setCard(testingcard1, 0);
        testinghand.setCard(testingcard2, 1);
        testinghand.setCard(testingcard3, 2);
        assertEquals(3, testinghand.getNumberCards());
        assertEquals("Проверка_3", testinghand.lastCard().getNamee());
        assertEquals(3, testinghand.lastCard().getPoints());
    }

    @Test
    void handSumTest() {
        Card testingcard1 = new Card("Проверка_1", 1);
        Card testingcard2 = new Card("Проверка_2", 2);
        Card testingcard3 = new Card("Проверка_3", 3);
        Hand testinghand = new Hand();
        testinghand.initializeHand();
        testinghand.setCard(testingcard1, 0);
        testinghand.setCard(testingcard2, 1);
        testinghand.setCard(testingcard3, 2);
        assertEquals(6, testinghand.handSum());
    }

    @Test
    void showCardsTest() {
        Card testingcard = new Card("Проверка", 1);
        Hand testinghand = new Hand();
        testinghand.initializeHand();
        testinghand.setCard(testingcard, 0);
        assertEquals("Проверка(1)] -> 1\n\t", testinghand.showCards(true, 1, 0, false));
        assertEquals("Проверка(1)] -> 1\n\n", testinghand.showCards(true, 1, 0, true));
        assertEquals("Проверка(1), ", testinghand.showCards(false, 1, 0, false));
    }

    @Test
    void withdrawTest() {
        Deck testingdeck = new Deck();
        testingdeck.createDeck();
        Hand testinghand = new Hand();
        testinghand.initializeHand();
        testinghand.withdraw(testingdeck);
        assertTrue(testinghand.getCard(0).getPoints() != 0);

    }


}