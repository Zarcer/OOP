package ru.nsu.zarcer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;




class RoundTest {
    @Test
    void playershowTesting() {
        Card testing_card_1 = new Card("Проверка_1", 1);
        Card testing_card_2 = new Card("Проверка_2", 2);
        Card testing_card_3 = new Card("Проверка_3", 3);
        Round testing_round = new Round();
        Hand testing_hand = new Hand();
        testing_hand.initializeHand();
        testing_hand.setCard(testing_card_1, 0);
        testing_hand.setCard(testing_card_2, 1);
        testing_hand.setCard(testing_card_3, 2);
        int sum = testing_round.player_show_cards(testing_hand);
        assertEquals(6, sum);
    }

    @Test
    void dealershowTesting() {
        Hand testing_hand = new Hand();
        Round testing_round = new Round();
        testing_hand.initializeHand();
        Card testing_card_1 = new Card("Проверка_1", 1);
        Card testing_card_2 = new Card("Проверка_2", 2);
        Card testing_card_3 = new Card("Проверка_3", 3);
        testing_hand.setCard(testing_card_1, 0);
        testing_hand.setCard(testing_card_2, 1);
        testing_hand.setCard(testing_card_3, 2);
        int sum = testing_round.dealer_show_cards(testing_hand);
        assertEquals(0, sum);
        sum = testing_round.dealer_show_cards(testing_hand);
        assertEquals(6, sum);
    }



}