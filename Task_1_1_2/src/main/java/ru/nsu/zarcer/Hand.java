package ru.nsu.zarcer;

public class Hand {
    private Card[] cards_in_hand;
    private int number_cards;
    {
        cards_in_hand = new Card[10];
        number_cards = 0;
    }

    public Card getCard(int i) {
        return this.cards_in_hand[i];
    }

    public int getNumber_cards() {
        return this.number_cards;
    }

    public void setCard(Card insert, int place) {
        this.cards_in_hand[place] = insert;
    }

    public void setCards_number(int number) {
        this.number_cards = number;
    }

    public void addCardcnt() {
        this.number_cards++;
    }

    public void withdraw(Deck deck) {
        this.setCard(deck.drawCard(), this.getNumber_cards());
        this.addCardcnt();
    }
}
