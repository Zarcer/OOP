package ru.nsu.zarcer;

/**
 * Hands with cards of participant.
 */
public class Hand {
    private Card[] cardsinhand;
    private int numberCards;

    {
        cardsinhand = new Card[10];
        numberCards = 0;
    }

    /**
     * Initialization of hand.
     */
    void initializeHand() {
        for (int i = 0; i < 10; i++) {
            this.cardsinhand[i] = new Card("", 0);
        }
    }

    /**Just getter.
     *
     * @param i index of card
     *
     * @return getter
     */
    Card getCard(int i) {
        return this.cardsinhand[i];
    }

    /**Just getter.
     *
     * @return getter
     */
    int getNumberCards() {
        return this.numberCards;
    }

    /**Just setter.
     *
     * @param insert which card to insert
     *
     * @param place at what index insert
     */
    void setCard(Card insert, int place) {
        this.cardsinhand[place] = insert;
        this.numberCards++;
    }

    /**Returns last card in hand.
     *
     * @return getter of last card
     */
    Card lastCard() {
        return this.getCard(this.getNumberCards() - 1);
    }

    /**Calculates sum of cards in hand.
     *
     * @return sum of cards in hand
     */
    int handSum() {
        int index = 0;
        int sum = 0;
        while (this.getCard(index).getPoints() != 0) {
            sum = sum + this.getCard(index).getPoints();
            index++;
        }
        return sum;
    }

    /**Return one card from hand at a time.
     *
     * @param last if it last card
     *
     * @param sum sum of cards in hand
     *
     * @param index index of card to be outputed
     *
     * @param dealer if it is dealer cards
     *
     * @return returns string with card
     */
    String showCards(boolean last, int sum, int index, boolean dealer) {
        if (last && !dealer) {
            return (this.getCard(index).getNamee()
                    + "("
                    + this.getCard(index).getPoints()
                    + ")] -> "
                    + sum
                    + "\n\t");
        }
        if (last && dealer) {
            return (this.getCard(index).getNamee()
                    + "("
                    + this.getCard(index).getPoints()
                    + ")] -> "
                    + sum
                    + "\n\n");
        }
        return (this.getCard(index).getNamee()
                + "("
                + this.getCard(index).getPoints()
                + "), ");
    }

    /**Draw random card and sets it in the hand.
     *
     * @param deck shuffled deck with cards
     */
    void withdraw(Deck deck) {
        this.setCard(deck.drawCard(), this.getNumberCards());
    }
}
