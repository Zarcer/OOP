package ru.nsu.zarcer;

import java.util.Scanner;

public class Gameplay {

    public static final Scanner IN = new Scanner(System.in);
    public static final int CRITICAL_NUMBER_21 = 21;
    public static final int DEALER_STOP_17 = 17;

    public static void main(String[] args) {
        Deck final_deck = new Deck();
        final_deck.createDeck();
        Hand player_hand = new Hand();
        player_hand.initializeHand();
        Hand dealer_hand = new Hand();
        dealer_hand.initializeHand();
        Round round_state = new Round();
        player_hand.withdraw(final_deck);
        player_hand.withdraw(final_deck);
        dealer_hand.withdraw(final_deck);
        System.out.println("Добро пожаловать в Блэкджек!\nРаунд 1\nДилер раздал карты\n\tВаши карты: [" + player_hand.getCard(0).getName() + " (" + player_hand.getCard(0).getPoints() + "), " + player_hand.getCard(1).getName() + " (" + player_hand.getCard(1).getPoints() + ")] -> " + (player_hand.getCard(0).getPoints() + player_hand.getCard(1).getPoints() + "\n\tКарты дилера: [" + dealer_hand.getCard(0).getName() + " (" + dealer_hand.getCard(0).getPoints() + "), <закрытая карта>]"));
        round_state.round_result(player_hand.getCard(0).getPoints() + player_hand.getCard(1).getPoints(), dealer_hand.getCard(0).getPoints(), false);
        round_state.choice(player_hand, dealer_hand, final_deck);
    }

    public static void start_game(Round round_state) {
        Deck final_deck = new Deck();
        final_deck.createDeck();
        Hand player_hand = new Hand();
        player_hand.initializeHand();
        Hand dealer_hand = new Hand();
        dealer_hand.initializeHand();
        player_hand.withdraw(final_deck);
        player_hand.withdraw(final_deck);
        dealer_hand.withdraw(final_deck);
        round_state.round_count++;
        System.out.println("Раунд " + round_state.round_count + "\nДилер раздал карты\n\tВаши карты: [" + player_hand.getCard(0).getName() + " (" + player_hand.getCard(0).getPoints() + "), " + player_hand.getCard(1).getName() + " (" + player_hand.getCard(1).getPoints() + ")] -> " + (player_hand.getCard(0).getPoints() + player_hand.getCard(1).getPoints() + "\n\tКарты дилера: [" + dealer_hand.getCard(0).getName() + " (" + dealer_hand.getCard(0).getPoints() + "), <закрытая карта>]"));
        round_state.round_result(player_hand.getCard(0).getPoints() + player_hand.getCard(1).getPoints(), dealer_hand.getCard(0).getPoints(), false);
        round_state.choice(player_hand, dealer_hand, final_deck);
    }
}
