package ru.nsu.zarcer;

import java.util.Scanner;

public class Round {
    public static void player_turn(Card[] player_hand, Card[] dealer_hand, int[] player_cards, int[] dealer_cards, Card[] deck, boolean[] round_start) {
        Scanner in = new Scanner(System.in);
        System.out.println("Ваш ход\n-------\nВведите "+1+", чтобы взять карту, и "+0+", чтобы остановиться...");
        int choice = in.nextInt();
        if(choice == 1) {
            Hands.withdraw(player_hand, deck, player_cards);
            System.out.print("Вы открыли карту "+ player_hand[player_cards[0]-1].Name+" ("+ player_hand[player_cards[0]-1].points+")\n\t Ваши карты: [");
            int player_index = 0;
            int dealer_index = 0;
            int sum = 0;
            while(player_hand[player_index].points != 0) {
                sum = sum + player_hand[player_index].points;
                if(player_index == player_cards[0]-1) {
                    System.out.print(player_hand[player_index].Name+"("+ player_hand[player_index].points+")] -> "+sum+"\n\t");
                    break;
                }
                System.out.print(player_hand[player_index].Name+"("+ player_hand[player_index].points+"), ");
                player_index++;
            }
            System.out.print("Карты Дилера: [");
            while(dealer_hand[dealer_index].points != 0) {
                if(round_start[0]) {
                    System.out.print(dealer_hand[dealer_index].Name+"("+ dealer_hand[dealer_index].points+"), ");
                    System.out.print("<закрытая карта>]\n");
                    round_start[0] = false;
                    break;
                }
                if (dealer_index == dealer_cards[0]-1) {
                    System.out.print(dealer_hand[dealer_index].Name+"("+ dealer_hand[dealer_index].points+")]\n\n");
                    break;
                }
                System.out.print(dealer_hand[dealer_index].Name+"("+ dealer_hand[dealer_index].points+"), ");
                dealer_index++;
            }
        }
    }
}
