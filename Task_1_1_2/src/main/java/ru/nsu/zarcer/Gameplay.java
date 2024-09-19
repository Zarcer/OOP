package ru.nsu.zarcer;

import java.util.Scanner;

public class Gameplay {

    public static final int CRITICAL_NUMBER_21 = 21;
    public static final int DEALER_STOP_17 = 17;

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
        System.out.println("Добро пожаловать в Блэкджек!\nРаунд 1\nДилер раздал карты\n\tВаши карты: [" + playerhand.getCard(0).getName() + " (" + playerhand.getCard(0).getPoints() + "), " + playerhand.getCard(1).getName() + " (" + playerhand.getCard(1).getPoints() + ")] -> " + (playerhand.getCard(0).getPoints() + playerhand.getCard(1).getPoints() + "\n\tКарты дилера: [" + dealerhand.getCard(0).getName() + " (" + dealerhand.getCard(0).getPoints() + "), <закрытая карта>]"));
        round_state.roundResult(playerhand.getCard(0).getPoints() + playerhand.getCard(1).getPoints(), dealerhand.getCard(0).getPoints(), false);
        round_state.choice(playerhand, dealerhand, finaldeck);
    }

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
        round_state.round_count++;
        System.out.println("Раунд " + round_state.round_count + "\nДилер раздал карты\n\tВаши карты: [" + playerhand.getCard(0).getName() + " (" + playerhand.getCard(0).getPoints() + "), " + playerhand.getCard(1).getName() + " (" + playerhand.getCard(1).getPoints() + ")] -> " + (playerhand.getCard(0).getPoints() + playerhand.getCard(1).getPoints() + "\n\tКарты дилера: [" + dealerhand.getCard(0).getName() + " (" + dealerhand.getCard(0).getPoints() + "), <закрытая карта>]"));
        round_state.roundResult(playerhand.getCard(0).getPoints() + playerhand.getCard(1).getPoints(), dealerhand.getCard(0).getPoints(), false);
        round_state.choice(playerhand, dealerhand, finaldeck);
    }
}
