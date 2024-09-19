package ru.nsu.zarcer;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class DeckTest {

    @Test
    void deckcreationtest() {
        Deck testingDeck = new Deck();
        testingDeck.createDeck();
        for (int i = 0; i < 51; i++) {
            assertNotEquals(testingDeck.getCard(i).getName(), testingDeck.getCard(i + 1).getName());
        }
    }

    @Test
    void drawCardTest() {
        Deck testingDeck = new Deck();
        testingDeck.createDeck();
        Card testing_card = testingDeck.drawCard();
        assertTrue(testing_card.getTaken());
    }

}