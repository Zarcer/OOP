package ru.nsu.zarcer;

public class Round {

    private int player_score;
    private int dealer_score;
    private boolean round_start;
    private boolean dealer_round_start;
    private boolean player_turn_start_check;
    int round_count;
    {
        player_score = 0;
        dealer_score = 0;
        round_start = true;
        dealer_round_start = false;
        player_turn_start_check = true;
        round_count = 1;
    }

    public static void player_turn(Hand player_hand, Hand dealer_hand, Deck deck, Round state) {
        state.dealer_round_start = false;
        player_hand.withdraw(deck);
        System.out.print("Вы открыли карту " + player_hand.lastCard().getName() + " (" + player_hand.lastCard().getPoints() + ")\n\t Ваши карты: [");
        int sum_player = player_show_cards(player_hand);
        int sum_dealer = dealer_show_cards(dealer_hand, state);
        round_result(sum_player, sum_dealer, false, state);
        choice(player_hand, dealer_hand, deck, state);
    }

    public static void dealer_turn(Hand player_hand, Hand dealer_hand, Deck deck, Round state) {
        state.dealer_round_start = true;
        System.out.print("Ход Дилера\n-------\n");
        int sum_dealer = 0;
        int sum_player = 0;
        while(sum_dealer<Gameplay.DEALER_STOP_17) {
            dealer_hand.withdraw(deck);
            if(!state.round_start) {
                System.out.print("Дилер открывает закрытую карту " + dealer_hand.lastCard().getName() + " (" + dealer_hand.lastCard().getPoints() + ")\n\t Ваши карты: [");
                state.round_start = true;
            }
            else {
                System.out.print("Дилер открывает карту " + dealer_hand.lastCard().getName() + " (" + dealer_hand.lastCard().getPoints() + ")\n\t Ваши карты: [");
            }
            sum_player = player_show_cards(player_hand);
            sum_dealer = dealer_show_cards(dealer_hand, state);
        }
        round_result(sum_player, sum_dealer, true, state);
    }

    public static void choice(Hand player_hand, Hand dealer_hand, Deck deck, Round state) {
        if(state.player_turn_start_check) {
            System.out.println("Ваш ход\n-------\nВведите "+1+", чтобы взять карту, и "+0+", чтобы остановиться...");
            state.player_turn_start_check = false;
        }
        else {
            System.out.println("Введите "+1+", чтобы взять карту, и "+0+", чтобы остановиться...");
        }
        int choice = Gameplay.IN.nextInt();
        if(choice == -1) {
            System.exit(0);
        }
        if(choice == 1) {
            player_turn(player_hand, dealer_hand, deck, state);
        }
        else {
            state.round_start = false;
            dealer_turn(player_hand, dealer_hand, deck, state);
        }
    }

    public static void player_win(Round state) {
        state.player_score++;
        System.out.print("Вы выиграли раунд! Счёт "+state.player_score+":"+state.dealer_score+"\n\n");
        state.player_turn_start_check = true;
        Gameplay.start_game(state);
        }

    public static void dealer_win(Round state) {
        state.dealer_score++;
        System.out.print("Дилер выиграл раунд! Счёт "+state.player_score+":"+state.dealer_score+"\n\n");
        state.player_turn_start_check = true;
        Gameplay.start_game(state);
    }

    public static int player_show_cards(Hand player_hand) {
        int player_index = 0;
        int sum_player = 0;
        while (player_hand.getCard(player_index).getPoints() != 0) {
            sum_player = player_hand.handSum();
            if (player_index == player_hand.getNumber_cards()-1) {
                System.out.print(player_hand.showCards(true, sum_player, player_index, false));
                break;
            }
            System.out.print(player_hand.showCards(false, sum_player, player_index, false));
            player_index++;
        }
        return sum_player;
    }

    public static int dealer_show_cards(Hand dealer_hand, Round state) {
        System.out.print("Карты Дилера: [");
        int dealer_index = 0;
        int sum_dealer = 0;
        if (!state.dealer_round_start) {
            System.out.print(dealer_hand.showCards(false, sum_dealer, dealer_index, true));
            System.out.print("<закрытая карта>]\n");
            state.dealer_round_start = true;
            return sum_dealer;
        }
        while (dealer_hand.getCard(dealer_index).getPoints() != 0) {
            sum_dealer = dealer_hand.handSum();
            if (dealer_index == dealer_hand.getNumber_cards()-1) {
                System.out.print(dealer_hand.showCards(true, sum_dealer, dealer_index, true));
                break;
            }
            System.out.print(dealer_hand.showCards(false, sum_dealer, dealer_index, true));
            dealer_index++;
        }
        return sum_dealer;
    }

    public static void round_result(int sum_player, int sum_dealer, boolean round_end, Round state) {
        if(sum_player == Gameplay.CRITICAL_NUMBER_21 || sum_dealer > Gameplay.CRITICAL_NUMBER_21) {
            player_win(state);
        }
        if(sum_player > Gameplay.CRITICAL_NUMBER_21 || sum_dealer == Gameplay.CRITICAL_NUMBER_21) {
            dealer_win(state);
        }
        if(round_end) {
            if(sum_player >= sum_dealer) {
                player_win(state);
            }
            if(sum_dealer > sum_player) {
                dealer_win(state);
            }
        }
    }
}
