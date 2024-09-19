package ru.nsu.zarcer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HandsTest {
    @Test
    void initializeTest() {
        Hand testing_hand = new Hand();
        testing_hand.initializeHand();
        assertEquals(0, testing_hand.getNumber_cards());
        for(int i = 0;i<10;i++) {
            assertEquals(0, testing_hand.getCard(i).getPoints());
        }
    }

    @Test
    void setCardTest() {
        Card testing_card = new Card("Проверка", 1);
        Hand testing_hand = new Hand();
        testing_hand.initializeHand();
        testing_hand.setCard(testing_card, 0);
        assertEquals("Проверка", testing_hand.getCard(0).getName());
        assertEquals(1, testing_hand.getCard(0).getPoints());
    }

    @Test
    void lastCardTest() {
        Card testing_card_1 = new Card("Проверка_1", 1);
        Card testing_card_2 = new Card("Проверка_2", 2);
        Card testing_card_3 = new Card("Проверка_3", 3);
        Hand testing_hand = new Hand();
        testing_hand.initializeHand();
        testing_hand.setCard(testing_card_1, 0);
        testing_hand.setCard(testing_card_2, 1);
        testing_hand.setCard(testing_card_3, 2);
        assertEquals(3, testing_hand.getNumber_cards());
        assertEquals("Проверка_3", testing_hand.lastCard().getName());
        assertEquals(3, testing_hand.lastCard().getPoints());
    }

    @Test
    void handSumTest() {
        Card testing_card_1 = new Card("Проверка_1", 1);
        Card testing_card_2 = new Card("Проверка_2", 2);
        Card testing_card_3 = new Card("Проверка_3", 3);
        Hand testing_hand = new Hand();
        testing_hand.initializeHand();
        testing_hand.setCard(testing_card_1, 0);
        testing_hand.setCard(testing_card_2, 1);
        testing_hand.setCard(testing_card_3, 2);
        assertEquals(6, testing_hand.handSum());
    }

    @Test
    void showCardsTest() {
        Card testing_card = new Card("Проверка", 1);
        Hand testing_hand = new Hand();
        testing_hand.initializeHand();
        testing_hand.setCard(testing_card, 0);
        assertEquals("Проверка(1)] -> 1\n\t", testing_hand.showCards(true, 1, 0, false));
        assertEquals("Проверка(1)] -> 1\n\n", testing_hand.showCards(true, 1, 0, true));
        assertEquals("Проверка(1), ", testing_hand.showCards(false, 1, 0, false));
    }

    @Test
    void withdrawTest() {
        Deck testing_deck = new Deck();
        testing_deck.createDeck();
        Hand testing_hand = new Hand();
        testing_hand.initializeHand();
        testing_hand.withdraw(testing_deck);
        assertTrue(testing_hand.getCard(0).getPoints()!=0);

    }


}