package ru.nsu.zarcer;

import org.junit.jupiter.api.Test;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class DeckTest {

    @Test
    void deckcreationtest() {
        Deck testing_deck = new Deck();
        testing_deck.createDeck();
        for(int i = 0;i<51;i++) {
            assertNotEquals(testing_deck.getCard(i).getName(), testing_deck.getCard(i + 1).getName());
        }
    }

    @Test
    void drawCardTest() {
        Deck testing_deck = new Deck();
        testing_deck.createDeck();
        Card testing_card = testing_deck.drawCard();
        assertTrue(testing_card.getTaken());
    }

}