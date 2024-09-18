package ru.nsu.zarcer;

public class Round {

    private static int player_score = 0;
    private static int dealer_score = 0;
    private static boolean round_start = true;
    private static boolean dealer_round_start = false;
    private static boolean player_turn_start_check = true;

    public static void player_turn(Hand player_hand, Hand dealer_hand, Deck deck) {
        player_hand.withdraw(deck);
        System.out.print("Вы открыли карту " + player_hand.getCard(player_hand.getNumber_cards()-1).getName() + " (" + player_hand.getCard(player_hand.getNumber_cards()-1).getPoints() + ")\n\t Ваши карты: [");
        int sum_player = player_show_cards(player_hand);
        int sum_dealer = dealer_show_cards(dealer_hand);
        round_result(sum_player, sum_dealer, false);
        choice(player_hand, dealer_hand, deck);
    }

    public static void dealer_turn(Hand player_hand, Hand dealer_hand, Deck deck) {
        System.out.print("Ход Дилера\n-------\n");
        int sum_dealer = 0;
        int sum_player = 0;
        while(sum_dealer<Gameplay.DEALER_STOP_17) {
            dealer_hand.withdraw(deck);
            if(!round_start) {
                System.out.print("Дилер открывает закрытую карту " + dealer_hand.getCard(dealer_hand.getNumber_cards()-1).getName() + " (" + dealer_hand.getCard(dealer_hand.getNumber_cards()-1).getPoints() + ")\n\t Ваши карты: [");
                round_start = true;
            }
            else {
                System.out.print("Дилер открывает карту " + dealer_hand.getCard(dealer_hand.getNumber_cards()-1).getName() + " (" + dealer_hand.getCard(dealer_hand.getNumber_cards()-1).getPoints() + ")\n\t Ваши карты: [");
            }
            sum_player = player_show_cards(player_hand);
            sum_dealer = dealer_show_cards(dealer_hand);
        }
        round_result(sum_player, sum_dealer, true);
    }

    public static void choice(Hand player_hand, Hand dealer_hand, Deck deck) {
        if(player_turn_start_check) {
            System.out.println("Ваш ход\n-------\nВведите "+1+", чтобы взять карту, и "+0+", чтобы остановиться...");
            player_turn_start_check = false;
        }
        else {
            System.out.println("Введите "+1+", чтобы взять карту, и "+0+", чтобы остановиться...");
        }
        int choice = Gameplay.IN.nextInt();
        if(choice == -1) {
            System.exit(0);
        }
        if(choice == 1) {
            player_turn(player_hand, dealer_hand, deck);
        }
        else {
            round_start = false;
            dealer_turn(player_hand, dealer_hand, deck);
        }
    }

    public static void player_win() {
        player_score++;
        System.out.print("Вы выиграли раунд! Счёт "+player_score+":"+dealer_score+"\n\n");
        player_turn_start_check = true;
        Gameplay.start_game();
        }

    public static void dealer_win() {
        dealer_score++;
        System.out.print("Дилер выиграл раунд! Счёт "+player_score+":"+dealer_score+"\n\n");
        player_turn_start_check = true;
        Gameplay.start_game();
    }

    public static int player_show_cards(Hand player_hand) {
        int player_index = 0;
        int sum_player = 0;
        while (player_hand.getCard(player_index).getPoints() != 0) {
            sum_player = sum_player + player_hand.getCard(player_index).getPoints();
            if (player_index == player_hand.getNumber_cards()-1) {
                System.out.print(player_hand.getCard(player_index).getName() + "(" + player_hand.getCard(player_index).getPoints() + ")] -> " + sum_player + "\n\t");
                break;
            }
            System.out.print(player_hand.getCard(player_index).getName() + "(" + player_hand.getCard(player_index).getPoints() + "), ");
            player_index++;
        }
        return sum_player;
    }

    public static int dealer_show_cards(Hand dealer_hand) {
        System.out.print("Карты Дилера: [");
        int dealer_index = 0;
        int sum_dealer = 0;
        if (!dealer_round_start) {
            System.out.print(dealer_hand.getCard(dealer_index).getName() + "(" + dealer_hand.getCard(dealer_index).getPoints() + "), ");
            System.out.print("<закрытая карта>]\n");
            dealer_round_start = true;
            return sum_dealer;
        }
        while (dealer_hand.getCard(dealer_index).getPoints() != 0) {
            sum_dealer = sum_dealer + dealer_hand.getCard(dealer_index).getPoints();
            if (dealer_index == dealer_hand.getNumber_cards()-1) {
                System.out.print(dealer_hand.getCard(dealer_index).getName() + "(" + dealer_hand.getCard(dealer_index).getPoints() + ")] -> "+ sum_dealer+"\n\n");
                break;
            }
            System.out.print(dealer_hand.getCard(dealer_index).getName() + "(" + dealer_hand.getCard(dealer_index).getPoints() + "), ");
            dealer_index++;
        }
        return sum_dealer;
    }

    public static void round_result(int sum_player, int sum_dealer, boolean round_end) {
        if(sum_player == Gameplay.CRITICAL_NUMBER_21 || sum_dealer > Gameplay.CRITICAL_NUMBER_21) {
            player_win();
        }
        if(sum_player > Gameplay.CRITICAL_NUMBER_21 || sum_dealer == Gameplay.CRITICAL_NUMBER_21) {
            dealer_win();
        }
        if(round_end) {
            if(sum_player >= sum_dealer) {
                player_win();
            }
            if(sum_dealer > sum_player) {
                dealer_win();
            }
        }
    }
}
