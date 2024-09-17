package ru.nsu.zarcer;

public class Hands {

    public static Card[] createhand() {
        Card[] hand = new Card[52];
        for(int i = 0;i<52;i++) {
            hand[i] = new Card("", 0);
        }
        return hand;
    }

    public static void withdraw(Card[] hand, Card[] deck, int[] number_cards) {
        int check = 0;
        int index = number_cards[0];
        while(check == 0) {
            int choice = (int)(Math.random()*52);
            if(deck[choice].getTaken()) {
                continue;
            }
            hand[index].setPoints(deck[choice].getPoints());
            hand[index].setName(deck[choice].getName());
            deck[choice].setTaken(true);
            check = 1;
            number_cards[0]++;
        }
    }
}
