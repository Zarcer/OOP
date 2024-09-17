package ru.nsu.zarcer;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Deck {

    public static Card[] createDeck() {
        Card[] deck_for_shuffle = new Card[52];
        for(int i = 0; i < 52; i++) {
            deck_for_shuffle[i] = new Card("", 0);
        }
        int counter = 0;
        int cnt = 0;
        final String[] NUMBER = new String[] {"Двойка", "Тройка", "Четвёрка", "Пятёрка", "Шестёрка", "Семёрка", "Восьмёрка", "Девятка", "Десятка", "Валет", "Дама", "Король", "Туз"};
        final String[] SUIT = new String[] {"Трефы", "Бубны", "Черви", "Пики"};
        for(int i = 0; i < SUIT.length; i++) {
            int cost = 2;
            for(int j = 0; j < NUMBER.length; j++) {
                deck_for_shuffle[cnt].setName(NUMBER[j] + " " + SUIT[i]);
                if(cost > 10) {
                    cost = 10;
                }
                if(j == 12) {
                    cost = 11;
                }
                deck_for_shuffle[cnt].setPoints(cost);
                deck_for_shuffle[cnt].setTaken(false);
                cost++;
                cnt++;
            }
        }
        List<Card> listDeck = Arrays.asList(deck_for_shuffle);
        Collections.shuffle(listDeck);
        return listDeck.toArray(new Card[0]);
    }
}
