package ru.nsu.zarcer;

/**
 * Game process itself.
 */
public class Gameplay {

    public static final int CRITICALNUMBER21 = 21;
    public static final int DEALERSTOP17 = 17;

    /**
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
        Round round_state = new Round();
        playerhand.withdraw(finaldeck);
        playerhand.withdraw(finaldeck);
        dealerhand.withdraw(finaldeck);
        System.out.println("Добро пожаловать в Блэкджек!\nРаунд 1\nДилер раздал карты\n\tВаши карты: ["
                + playerhand.getCard(0).getName() + " (" + playerhand.getCard(0).getPoints() + "), "
                + playerhand.getCard(1).getName() + " (" + playerhand.getCard(1).getPoints() + ")] -> "
                + (playerhand.getCard(0).getPoints() + playerhand.getCard(1).getPoints() + "\n\tКарты дилера: ["
                + dealerhand.getCard(0).getName() + " ("
                + dealerhand.getCard(0).getPoints() + "), <закрытая карта>]"));
        round_state.roundResult(playerhand.getCard(0).getPoints() + playerhand.getCard(1).getPoints(),
                dealerhand.getCard(0).getPoints(), false);
        round_state.choice(playerhand, dealerhand, finaldeck);
    }

    /**
     *
     * @param round_state track all flags and counters
     */
    public static void startGame(Round round_state) {
        Deck finaldeck = new Deck();
        finaldeck.createDeck();
        Hand playerhand = new Hand();
        playerhand.initializeHand();
        Hand dealerhand = new Hand();
        dealerhand.initializeHand();
        playerhand.withdraw(finaldeck);
        playerhand.withdraw(finaldeck);
        dealerhand.withdraw(finaldeck);
        round_state.roundcount++;
        System.out.println("Раунд " + round_state.roundcount + "\nДилер раздал карты\n\tВаши карты: [" +
                playerhand.getCard(0).getName() + " (" + playerhand.getCard(0).getPoints() + "), " +
                playerhand.getCard(1).getName() + " (" + playerhand.getCard(1).getPoints() + ")] -> " +
                (playerhand.getCard(0).getPoints() + playerhand.getCard(1).getPoints() + "\n\tКарты дилера: [" +
                        dealerhand.getCard(0).getName() + " (" + dealerhand.getCard(0).getPoints() + "), <закрытая карта>]"));
        round_state.roundResult(playerhand.getCard(0).getPoints() + playerhand.getCard(1).getPoints(),
                dealerhand.getCard(0).getPoints(), false);
        round_state.choice(playerhand, dealerhand, finaldeck);
    }
}
