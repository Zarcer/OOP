package ru.nsu.zarcer;

import java.util.Scanner;

public class Gameplay {

    public static final Scanner IN = new Scanner(System.in);
    public static final int CRITICAL_NUMBER_21 = 21;
    public static final int DEALER_STOP_17 = 17;
    public static int[] player_score = new int[] {0};
    public static int[] dealer_score = new int[] {0};
    public static int[] round_count = new int[] {1};
    public static boolean[] round_start = new boolean[] {true};
    public static boolean[] player_turn_start_check = new boolean[] {true};
    public static boolean[] dealer_round_start = new boolean[] {true};


    public static void main(String[] args) {
        Card[] Deck = ru.nsu.zarcer.Deck.createDeck();
        Card[] player_hand = Hands.createhand();
        Card[] dealer_hand = Hands.createhand();
        int[] player_card = new int[] {0};
        int[] dealer_card = new int[] {0};
        Hands.withdraw(player_hand, Deck, player_card);
        Hands.withdraw(player_hand, Deck, player_card);
        Hands.withdraw(dealer_hand, Deck, dealer_card);
        System.out.println("Добро пожаловать в Блэкджек!\nРаунд 1\nДилер раздал карты\n\tВаши карты: ["+player_hand[0].getName()+" ("+player_hand[0].getPoints()+"), "+player_hand[1].getName()+" (" + player_hand[1].getPoints() + ")] -> "+(player_hand[0].getPoints()+player_hand[1].getPoints()+"\n\tКарты дилера: ["+dealer_hand[0].getName()+" ("+dealer_hand[0].getPoints()+"), <закрытая карта>]"));
        Round.round_result(player_hand[0].getPoints()+player_hand[1].getPoints(), dealer_hand[0].getPoints(), false);
        Round.choice(player_hand, dealer_hand, player_card, dealer_card, Deck);
    }

    public static void start_game() {
        Gameplay.player_turn_start_check[0] = true;
        Card[] Deck = ru.nsu.zarcer.Deck.createDeck();
        Card[] player_hand = Hands.createhand();
        Card[] dealer_hand = Hands.createhand();
        int[] player_card = new int[] {0};
        int[] dealer_card = new int[] {0};
        Hands.withdraw(player_hand, Deck, player_card);
        Hands.withdraw(player_hand, Deck, player_card);
        Hands.withdraw(dealer_hand, Deck, dealer_card);
        Gameplay.round_count[0]++;
        System.out.print("Раунд "+Gameplay.round_count[0]+"\nДилер раздал карты\n\tВаши карты: ["+player_hand[0].getName()+" (" + player_hand[0].getPoints()+"), "+player_hand[1].getName()+" ("+player_hand[1].getPoints()+")] -> "+(player_hand[0].getPoints()+player_hand[1].getPoints())+"\n\tКарты дилера: ["+dealer_hand[0].getName()+" ("+dealer_hand[0].getPoints()+"), <закрытая карта>]\n");
        Round.choice(player_hand, dealer_hand, player_card, dealer_card, Deck);
    }
}
