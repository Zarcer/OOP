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
            assertNotEquals(testingDeck.getCard(i).getNamee(),
                    testingDeck.getCard(i + 1).getNamee());
        }
    }

    @Test
    void drawCardTest() {
        Deck testingDeck = new Deck();
        testingDeck.createDeck();
        Card testingCard = testingDeck.drawCard();
        assertTrue(testingCard.getTaken());
    }

}