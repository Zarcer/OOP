package ru.nsu.zarcer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class RoundTest {
    @Test
    void playershowTesting() {
        Card testingcard1 = new Card("Проверка_1", 1);
        Card testingcard2 = new Card("Проверка_2", 2);
        Card testingcard3 = new Card("Проверка_3", 3);
        Round testinground = new Round();
        Hand testinghand = new Hand();
        testinghand.initializeHand();
        testinghand.setCard(testingcard1, 0);
        testinghand.setCard(testingcard2, 1);
        testinghand.setCard(testingcard3, 2);
        int sum = testinground.playerShowCards(testinghand);
        assertEquals(6, sum);
    }

    @Test
    void dealershowTesting() {
        Hand testinghand = new Hand();
        Round testinground = new Round();
        testinghand.initializeHand();
        Card testingcard1 = new Card("Проверка_1", 1);
        Card testingcard2 = new Card("Проверка_2", 2);
        Card testingcard3 = new Card("Проверка_3", 3);
        testinghand.setCard(testingcard1, 0);
        testinghand.setCard(testingcard2, 1);
        testinghand.setCard(testingcard3, 2);
        int sum = testinground.dealerShowCards(testinghand);
        assertEquals(0, sum);
        sum = testinground.dealerShowCards(testinghand);
        assertEquals(6, sum);
    }

    @Test
    void playerWin() {
        Round testingRound = new Round();
        testingRound.playerWin();
        assertEquals(1, testingRound.getPlayerscore());
    }

    @Test
    void dealerWin() {
        Round testingRound = new Round();
        testingRound.dealerWin();
        assertEquals(1, testingRound.getDealerscore());
    }
}