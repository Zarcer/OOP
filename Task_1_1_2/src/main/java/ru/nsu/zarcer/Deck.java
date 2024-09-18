package ru.nsu.zarcer;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Deck {

    private Card[] deck_initial;
    {
        deck_initial = new Card[52];
    }
    public void createDeck() {
        int cnt = 0;
        final String[] NUMBER = new String[] {"Двойка", "Тройка", "Четвёрка", "Пятёрка", "Шестёрка", "Семёрка", "Восьмёрка", "Девятка", "Десятка", "Валет", "Дама", "Король", "Туз"};
        final String[] SUIT = new String[] {"Трефы", "Бубны", "Черви", "Пики"};
        for(int i = 0; i < SUIT.length; i++) {
            int cost = 2;
            for(int j = 0; j < NUMBER.length; j++) {
                if(cost > 10) {
                    cost = 10;
                }
                if(j == 12) {
                    cost = 11;
                }
                this.deck_initial[cnt] = new Card((NUMBER[j] + " " + SUIT[i]), cost);
                cost++;
                cnt++;
            }
        }
        List<Card> listDeck = Arrays.asList(this.deck_initial);
        Collections.shuffle(listDeck);
        this.deck_initial = listDeck.toArray(new Card[0]);
    }

    public Card getCard(int i) {
        return this.deck_initial[i];
    }

    public Card drawCard() {
        while(true) {
            int choice = (int)(Math.random()*52);
            if(!this.getCard(choice).getTaken()) {
                this.getCard(choice).setTaken(true);
                return this.getCard(choice);
            }
        }
    }
}
