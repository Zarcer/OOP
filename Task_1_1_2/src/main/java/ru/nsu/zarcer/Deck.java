package ru.nsu.zarcer;

public class Deck {

    public static Card[] createDeck() {
        Card[] deck_for_play = new Card[52];
        Card[] deck_for_shuffle = new Card[52];
        for(int i = 0; i < 52; i++) {
            deck_for_play[i] = new Card("", 0);
            deck_for_shuffle[i] = new Card("", 0);
        }
        int counter = 0;
        int cnt = 0;
        String[] number = new String[] {"Двойка", "Тройка", "Четвёрка", "Пятёрка", "Шестёрка", "Семёрка", "Восьмёрка", "Девятка", "Десятка", "Валет", "Дама", "Король", "Туз"};
        String[] suit = new String[] {"Трефы", "Бубны", "Черви", "Пики"};
        for(int i = 0; i < 4; i++) {
            int cost = 2;
            for(int j = 0; j < 13; j++) {
                deck_for_shuffle[cnt].setName(number[j] + " " + suit[i]);
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
        while(counter != 52) {
            int i = (int)(Math.random() * 52);
            if (deck_for_shuffle[i].getTaken()) {
                continue;
            }
            deck_for_play[counter].setPoints(deck_for_shuffle[i].getPoints());
            deck_for_play[counter].setName(deck_for_shuffle[i].getName());
            deck_for_shuffle[i].setTaken(true);
            counter++;
        }
        return deck_for_play;
    }
}
