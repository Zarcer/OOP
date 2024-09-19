package ru.nsu.zarcer;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Deck class.
 */
public class Deck {

    
    private Card[] deckInitial;

    {
        deckInitial = new Card[52];
    }

    /**
     * Creation of deck.
     */
    public void createDeck() {
        int cnt = 0;
        final String[] number = new String[] {"Двойка", "Тройка", "Четвёрка", "Пятёрка",
            "Шестёрка", "Семёрка", "Восьмёрка", "Девятка",
            "Десятка", "Валет", "Дама", "Король", "Туз"};
        final String[] suit = new String[]{"Трефы", "Бубны", "Черви", "Пики"};
        for (int i = 0; i < suit.length; i++) {
            int cost = 2;
            for (int j = 0; j < number.length; j++) {
                if (cost > 10) {
                    cost = 10;
                }
                if (j == 12) {
                    cost = 11;
                }
                this.deckInitial[cnt] = new Card((number[j] + " " + suit[i]), cost);
                cost++;
                cnt++;
            }
        }
        List<Card> listDeck = Arrays.asList(this.deckInitial);
        Collections.shuffle(listDeck);
        this.deckInitial = listDeck.toArray(new Card[0]);
    }

    /**Just getter.
     *
     * @param i index of card
     *
     * @return getter
     */
    public Card getCard(int i) {
        return this.deckInitial[i];
    }

    /**Needs to draw cards randomly.
     *
     * @return random card drawing
     */
    public Card drawCard() {
        while (true) {
            int choice = (int) (Math.random() * 52);
            if (!this.getCard(choice).getTaken()) {
                this.getCard(choice).setTaken(true);
                return this.getCard(choice);
            }
        }
    }
}
