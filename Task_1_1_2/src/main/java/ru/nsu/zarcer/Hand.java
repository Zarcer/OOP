package ru.nsu.zarcer;

public class Hand {
    private Card[] cards_in_hand;
    private int number_cards;
    {
        cards_in_hand = new Card[10];
        number_cards = 0;
    }

    public void initializeHand() {
        for(int i = 0;i<10;i++) {
            this.cards_in_hand[i] = new Card("", 0);
        }
    }

    public Card getCard(int i) {
        return this.cards_in_hand[i];
    }

    public int getNumber_cards() {
        return this.number_cards;
    }

    private void setCard(Card insert, int place) {
        this.cards_in_hand[place] = insert;
    }

    private void addCardcnt() {
        this.number_cards++;
    }

    public Card lastCard() {
        return this.getCard(this.getNumber_cards()-1);
    }

    public int handSum() {
        int index = 0;
        int sum = 0;
        while (this.getCard(index).getPoints() != 0) {
            sum = sum + this.getCard(index).getPoints();
            index++;
        }
        return sum;
    }

    public String showCards(boolean last, int sum, int index, boolean dealer) {
        if(last && !dealer) {
            return this.getCard(index).getName() + "(" + this.getCard(index).getPoints() + ")] -> " + sum + "\n\t";
        }
        if(last && dealer) {
            return this.getCard(index).getName() + "(" + this.getCard(index).getPoints() + ")] -> " + sum + "\n\n";
        }
        return this.getCard(index).getName() + "(" + this.getCard(index).getPoints() + "), ";
    }

    public void withdraw(Deck deck) {
        this.setCard(deck.drawCard(), this.getNumber_cards());
        this.addCardcnt();
    }
}
