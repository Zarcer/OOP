package ru.nsu.zarcer;

import java.util.Scanner;

public class Round {
    public static void player_turn(Card[] player_hand, Card[] dealer_hand, int[] player_cards, int[] dealer_cards, Card[] deck) {
        Hands.withdraw(player_hand, deck, player_cards);
        System.out.print("Вы открыли карту " + player_hand[player_cards[0] - 1].Name + " (" + player_hand[player_cards[0] - 1].points + ")\n\t Ваши карты: [");
        int player_index = 0;
        int dealer_index = 0;
        int sum = 0;
        while (player_hand[player_index].points != 0) {
            sum = sum + player_hand[player_index].points;
            if (player_index == player_cards[0] - 1) {
                System.out.print(player_hand[player_index].Name + "(" + player_hand[player_index].points + ")] -> " + sum + "\n\t");
                break;
            }
            System.out.print(player_hand[player_index].Name + "(" + player_hand[player_index].points + "), ");
            player_index++;
        }
        System.out.print("Карты Дилера: [");
        while (dealer_hand[dealer_index].points != 0) {
            if (Gameplay.round_start[0]) {
                System.out.print(dealer_hand[dealer_index].Name + "(" + dealer_hand[dealer_index].points + "), ");
                System.out.print("<закрытая карта>]\n");
                if(sum == 21) {
                    player_win();
                }
                if(sum > 21) {
                    dealer_win();
                }
                break;
            }
            if (dealer_index == dealer_cards[0] - 1) {
                System.out.print(dealer_hand[dealer_index].Name + "(" + dealer_hand[dealer_index].points + ")]\n\n");
                if(sum == 21) {
                    player_win();
                }
                if(sum > 21) {
                    dealer_win();
                }
                break;
            }
            System.out.print(dealer_hand[dealer_index].Name + "(" + dealer_hand[dealer_index].points + "), ");
            dealer_index++;
        }
        choice(player_hand, dealer_hand, player_cards, dealer_cards, deck);
    }
    public static void dealer_turn(Card[] player_hand, Card[] dealer_hand, int[] player_cards, int[] dealer_cards, Card[] deck) {
        System.out.print("Ход Дилера\n-------\n");
        int sum_dealer = 0;
        int sum_player = 0;
        while(sum_dealer<17) {
            sum_dealer = 0;
            sum_player = 0;
            int player_index = 0;
            int dealer_index = 0;
            Hands.withdraw(dealer_hand, deck, dealer_cards);
            if(!Gameplay.round_start[0]) {
                System.out.print("Дилер открывает закрытую карту " + dealer_hand[dealer_cards[0] - 1].Name + " (" + dealer_hand[dealer_cards[0] - 1].points + ")\n\t Ваши карты: [");
                Gameplay.round_start[0] = true;
            }
            else {
                System.out.print("Дилер открывает карту " + dealer_hand[dealer_cards[0] - 1].Name + " (" + dealer_hand[dealer_cards[0] - 1].points + ")\n\t Ваши карты: [");
            }
            while (player_hand[player_index].points != 0) {
                sum_player = sum_player + player_hand[player_index].points;
                if (player_index == player_cards[0] - 1) {
                    System.out.print(player_hand[player_index].Name + "(" + player_hand[player_index].points + ")] -> " + sum_player + "\n\t");
                    break;
                }
                System.out.print(player_hand[player_index].Name + "(" + player_hand[player_index].points + "), ");
                player_index++;
            }
            System.out.print("Карты Дилера: [");
            while (dealer_hand[dealer_index].points != 0) {
                sum_dealer = sum_dealer + dealer_hand[dealer_index].points;
                if (dealer_index == dealer_cards[0] - 1) {
                    System.out.print(dealer_hand[dealer_index].Name + "(" + dealer_hand[dealer_index].points + ")] -> "+ sum_dealer+"\n\n");
                    if(sum_dealer == 21) {
                        dealer_win();
                    }
                    if(sum_dealer > 21) {
                        player_win();
                    }
                    break;
                }
                System.out.print(dealer_hand[dealer_index].Name + "(" + dealer_hand[dealer_index].points + "), ");
                dealer_index++;
            }
        }
        if(sum_player >= sum_dealer) {
            player_win();
        }
    }

    public static void choice(Card[] player_hand, Card[] dealer_hand, int[] player_cards, int[] dealer_cards, Card[] deck) {
        Scanner in = new Scanner(System.in);
        if(Gameplay.player_turn_start_check[0]) {
            System.out.println("Ваш ход\n-------\nВведите "+1+", чтобы взять карту, и "+0+", чтобы остановиться...");
            Gameplay.player_turn_start_check[0] = false;
        }
        else {
            System.out.println("Введите "+1+", чтобы взять карту, и "+0+", чтобы остановиться...");
        }
        int choice = in.nextInt();
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
        Gameplay.round_count[0]++;
        System.out.print("Вы выиграли раунд! Счёт "+Gameplay.player_score[0]+":"+Gameplay.dealer_score[0]+"\n\n");
        Gameplay.start_game();
    }

    public static void dealer_win() {
        Gameplay.dealer_score[0]++;
        Gameplay.round_count[0]++;
        System.out.print("Дилер выиграл раунд! Счёт "+Gameplay.player_score[0]+":"+Gameplay.dealer_score[0]+"\n\n");
        Gameplay.start_game();

    }
}
