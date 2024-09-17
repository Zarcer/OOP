package ru.nsu.zarcer;

public class Round {

    public static void player_turn(Card[] player_hand, Card[] dealer_hand, int[] player_cards, int[] dealer_cards, Card[] deck) {
        Gameplay.dealer_round_start[0] = false;
        Hands.withdraw(player_hand, deck, player_cards);
        System.out.print("Вы открыли карту " + player_hand[player_cards[0] - 1].getName() + " (" + player_hand[player_cards[0] - 1].getPoints() + ")\n\t Ваши карты: [");
        int sum_player = player_show_cards(player_hand, player_cards);
        int sum_dealer = dealer_show_cards(dealer_hand, dealer_cards);
        round_result(sum_player, sum_dealer, false);
        choice(player_hand, dealer_hand, player_cards, dealer_cards, deck);
    }

    public static void dealer_turn(Card[] player_hand, Card[] dealer_hand, int[] player_cards, int[] dealer_cards, Card[] deck) {
        System.out.print("Ход Дилера\n-------\n");
        int sum_dealer = 0;
        int sum_player = 0;
        while(sum_dealer<17) {
            Hands.withdraw(dealer_hand, deck, dealer_cards);
            if(!Gameplay.round_start[0]) {
                System.out.print("Дилер открывает закрытую карту " + dealer_hand[dealer_cards[0] - 1].getName() + " (" + dealer_hand[dealer_cards[0] - 1].getPoints() + ")\n\t Ваши карты: [");
                Gameplay.round_start[0] = true;
            }
            else {
                System.out.print("Дилер открывает карту " + dealer_hand[dealer_cards[0] - 1].getName() + " (" + dealer_hand[dealer_cards[0] - 1].getPoints() + ")\n\t Ваши карты: [");
            }
            sum_player = player_show_cards(player_hand, player_cards);
            sum_dealer = dealer_show_cards(dealer_hand, dealer_cards);
        }
        round_result(sum_player, sum_dealer, true);
    }

    public static void choice(Card[] player_hand, Card[] dealer_hand, int[] player_cards, int[] dealer_cards, Card[] deck) {
        if(Gameplay.player_turn_start_check[0]) {
            System.out.println("Ваш ход\n-------\nВведите "+1+", чтобы взять карту, и "+0+", чтобы остановиться...");
            Gameplay.player_turn_start_check[0] = false;
        }
        else {
            System.out.println("Введите "+1+", чтобы взять карту, и "+0+", чтобы остановиться...");
        }
        int choice = Gameplay.in.nextInt();
        if(choice == -1) {
            System.exit(0);
        }
        if(choice == 1) {
            player_turn(player_hand, dealer_hand, player_cards, dealer_cards, deck);
        }
        else {
            Gameplay.round_start[0] = false;
            dealer_turn(player_hand, dealer_hand, player_cards, dealer_cards, deck);
        }
    }

    public static void player_win() {
        Gameplay.player_score[0]++;
        System.out.print("Вы выиграли раунд! Счёт "+Gameplay.player_score[0]+":"+Gameplay.dealer_score[0]+"\n\n");
        Gameplay.start_game();
        }

    public static void dealer_win() {
        Gameplay.dealer_score[0]++;
        System.out.print("Дилер выиграл раунд! Счёт "+Gameplay.player_score[0]+":"+Gameplay.dealer_score[0]+"\n\n");
        Gameplay.start_game();
    }

    public static int player_show_cards(Card[] player_hand, int[] player_cards) {
        int player_index = 0;
        int sum_player = 0;
        while (player_hand[player_index].getPoints() != 0) {
            sum_player = sum_player + player_hand[player_index].getPoints();
            if (player_index == player_cards[0] - 1) {
                System.out.print(player_hand[player_index].getName() + "(" + player_hand[player_index].getPoints() + ")] -> " + sum_player + "\n\t");
                break;
            }
            System.out.print(player_hand[player_index].getName() + "(" + player_hand[player_index].getPoints() + "), ");
            player_index++;
        }
        return sum_player;
    }

    public static int dealer_show_cards(Card[] dealer_hand, int[] dealer_cards) {
        System.out.print("Карты Дилера: [");
        int dealer_index = 0;
        int sum_dealer = 0;
        if (!Gameplay.dealer_round_start[0]) {
            System.out.print(dealer_hand[dealer_index].getName() + "(" + dealer_hand[dealer_index].getPoints() + "), ");
            System.out.print("<закрытая карта>]\n");
            Gameplay.dealer_round_start[0] = true;
            return sum_dealer;
        }
        while (dealer_hand[dealer_index].getPoints() != 0) {
            sum_dealer = sum_dealer + dealer_hand[dealer_index].getPoints();
            if (dealer_index == dealer_cards[0] - 1) {
                System.out.print(dealer_hand[dealer_index].getName() + "(" + dealer_hand[dealer_index].getPoints() + ")] -> "+ sum_dealer+"\n\n");
                break;
            }
            System.out.print(dealer_hand[dealer_index].getName() + "(" + dealer_hand[dealer_index].getPoints() + "), ");
            dealer_index++;
        }
        return sum_dealer;
    }

    public static void round_result(int sum_player, int sum_dealer, boolean round_end) {
        if(sum_player == Gameplay.critical_number_21 || sum_dealer > Gameplay.critical_number_21 ) {
            player_win();
        }
        if(sum_player > Gameplay.critical_number_21 || sum_dealer == Gameplay.critical_number_21) {
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
