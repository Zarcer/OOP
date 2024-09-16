package ru.nsu.zarcer;

public class Gameplay {
    public static int[] player_score = new int[] {0};
    public static int[] dealer_score = new int[] {0};
    public static int[] round_count = new int[] {1};
    public static boolean[] round_start = new boolean[] {true};
    public static boolean[] player_turn_start_check = new boolean[] {true};
    public static void main(String[] args) {
        Card[] Deck = ru.nsu.zarcer.Deck.createDeck();
        Card[] player_hand = Hands.createhand();
        Card[] dealer_hand = Hands.createhand();
        int[] player_card = new int[] {0};
        int[] dealer_card = new int[] {0};
        Hands.withdraw(player_hand, Deck, player_card);
        Hands.withdraw(player_hand, Deck, player_card);
        Hands.withdraw(dealer_hand, Deck, dealer_card);
        System.out.println("Добро пожаловать в Блэкджек!\nРаунд 1\nДилер раздал карты\n\tВаши карты: ["+player_hand[0].Name+" ("+player_hand[0].points+"), "+player_hand[1].Name+" ("+player_hand[1].points+")] -> "+(player_hand[0].points+player_hand[1].points+"\n\tКарты дилера: ["+dealer_hand[0].Name+" ("+dealer_hand[0].points)+"), <закрытая карта>]");
        Round.choice(player_hand, dealer_hand, player_card, dealer_card, Deck);
    }
    public static void start_game() {
        Card[] Deck = ru.nsu.zarcer.Deck.createDeck();
        Card[] player_hand = Hands.createhand();
        Card[] dealer_hand = Hands.createhand();
        int[] player_card = new int[] {0};
        int[] dealer_card = new int[] {0};
        Hands.withdraw(player_hand, Deck, player_card);
        Hands.withdraw(player_hand, Deck, player_card);
        Hands.withdraw(dealer_hand, Deck, dealer_card);
        Gameplay.round_count[0]++;
        System.out.print("Раунд "+Gameplay.round_count[0]+"\nДилер раздал карты\n\tВаши карты: ["+player_hand[0].Name+" ("+player_hand[0].points+"), "+player_hand[1].Name+" ("+player_hand[1].points+")] -> "+(player_hand[0].points+player_hand[1].points+"\n\tКарты дилера: ["+dealer_hand[0].Name+" ("+dealer_hand[0].points)+"), <закрытая карта>]\n");
        Round.choice(player_hand, dealer_hand, player_card, dealer_card, Deck);
    }
}
