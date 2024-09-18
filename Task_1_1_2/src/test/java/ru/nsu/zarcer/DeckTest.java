package ru.nsu.zarcer;

import org.junit.jupiter.api.Test;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class DeckTest {

    @Test
    void deckcreationtest() {
        Deck testing_deck = new Deck();
        testing_deck.createDeck();
        int check = 0;
        for(int i = 0;i<52;i++) {
            if(i==51) {
                break;
            }
            if(Objects.equals(testing_deck.getCard(i).getName(), testing_deck.getCard(i + 1).getName())) {
                check = 1;
                break;
            }
        }
        assertEquals(check, 0);
    }
}