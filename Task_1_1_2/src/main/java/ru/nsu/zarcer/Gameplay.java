package ru.nsu.zarcer;

/**
 * Game process itself.
 */
public class Gameplay {

    public static final int CRITICALNUMBER21 = 21;
    public static final int DEALERSTOP17 = 17;

    /**Just main.
     *
     * @param args null
     */
    public static void main(String[] args) {
        Deck finaldeck = new Deck();
        finaldeck.createDeck();
        Hand playerhand = new Hand();
        playerhand.initializeHand();
        Hand dealerhand = new Hand();
        dealerhand.initializeHand();
        playerhand.withdraw(finaldeck);
        playerhand.withdraw(finaldeck);
        dealerhand.withdraw(finaldeck);
        System.out.println("Добро пожаловать в Блэкджек!\nРаунд 1\nДилер раздал карты\n\tВаши карты: ["
                + playerhand.getCard(0).getNamee()
                + " (" + playerhand.getCard(0).getPoints()
                + "), "
                + playerhand.getCard(1).getNamee()
                + " ("
                + playerhand.getCard(1).getPoints()
                + ")] -> "
                + (playerhand.getCard(0).getPoints()
                + playerhand.getCard(1).getPoints()
                + "\n\tКарты дилера: ["
                + dealerhand.getCard(0).getNamee()
                + " ("
                + dealerhand.getCard(0).getPoints()
                + "), <закрытая карта>]"));
        Round roundstate = new Round();
        roundstate.roundResult(playerhand.getCard(0).getPoints()
                        + playerhand.getCard(1).getPoints(),
                dealerhand.getCard(0).getPoints(), false);
        roundstate.choice(playerhand, dealerhand, finaldeck);
    }

    /**Start game for round 2+.
     *
     * @param roundstate track all flags and counters
     */
    public static void startGame(Round roundstate) {
        Deck finaldeck = new Deck();
        finaldeck.createDeck();
        Hand playerhand = new Hand();
        playerhand.initializeHand();
        Hand dealerhand = new Hand();
        dealerhand.initializeHand();
        playerhand.withdraw(finaldeck);
        playerhand.withdraw(finaldeck);
        dealerhand.withdraw(finaldeck);
        roundstate.roundcount++;
        System.out.println("Раунд "
                + roundstate.roundcount
                + "\nДилер раздал карты\n\tВаши карты: ["
                + playerhand.getCard(0).getNamee()
                + " ("
                + playerhand.getCard(0).getPoints()
                + "), "
                + playerhand.getCard(1).getNamee()
                + " ("
                + playerhand.getCard(1).getPoints()
                + ")] -> "
                + (playerhand.getCard(0).getPoints()
                + playerhand.getCard(1).getPoints()
                + "\n\tКарты дилера: ["
                + dealerhand.getCard(0).getNamee()
                + " ("
                + dealerhand.getCard(0).getPoints()
                + "), <закрытая карта>]"));
        roundstate.roundResult(playerhand.getCard(0).getPoints()
                        + playerhand.getCard(1).getPoints(),
                dealerhand.getCard(0).getPoints(), false);
        roundstate.choice(playerhand, dealerhand, finaldeck);
    }
}
