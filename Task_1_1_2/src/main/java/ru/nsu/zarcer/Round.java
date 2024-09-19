package ru.nsu.zarcer;

import java.util.Scanner;

public class Round {

    private boolean round_start;
    private boolean dealer_round_start;
    private boolean player_turn_start_check;
    Scanner IN;
    int round_count;
    int dealer_score;
    int player_score;

    {
        player_score = 0;
        dealer_score = 0;
        round_start = true;
        dealer_round_start = false;
        player_turn_start_check = true;
        round_count = 1;
        IN = new Scanner(System.in);
    }

    public void playerturn(Hand playerhand, Hand dealerhand, Deck deck) {
        this.dealer_round_start = false;
        playerhand.withdraw(deck);
        System.out.print("Вы открыли карту " + playerhand.lastCard().getName() + " (" + playerhand.lastCard().getPoints() + ")\n\t Ваши карты: [");
        int sumPlayer = playerShowCards(playerhand);
        int sumDealer = dealerShowCards(dealerhand);
        roundResult(sumPlayer, sumDealer, false);
        choice(playerhand, dealerhand, deck);
    }

    public void dealerturn(Hand playerhand, Hand dealerhand, Deck deck) {
        this.dealer_round_start = true;
        System.out.print("Ход Дилера\n-------\n");
        int sumDealer = 0;
        int sumPlayer = 0;
        while (sumDealer < Gameplay.DEALER_STOP_17) {
            dealerhand.withdraw(deck);
            if (!this.round_start) {
                System.out.print("Дилер открывает закрытую карту " + dealerhand.lastCard().getName() + " (" + dealerhand.lastCard().getPoints() + ")\n\t Ваши карты: [");
                this.round_start = true;
            } else {
                System.out.print("Дилер открывает карту " + dealerhand.lastCard().getName() + " (" + dealerhand.lastCard().getPoints() + ")\n\t Ваши карты: [");
            }
            sumPlayer = playerShowCards(playerhand);
            sumDealer = dealerShowCards(dealerhand);
        }
        roundResult(sumPlayer, sumDealer, true);
    }

    public void choice(Hand playerhand, Hand dealerhand, Deck deck) {
        if (this.player_turn_start_check) {
            System.out.println("Ваш ход\n-------\nВведите " + 1 + ", чтобы взять карту, и " + 0 + ", чтобы остановиться...");
            this.player_turn_start_check = false;
        } else {
            System.out.println("Введите " + 1 + ", чтобы взять карту, и " + 0 + ", чтобы остановиться...");
        }
        int choice = this.IN.nextInt();
        if (choice == -1) {
            return;
        }
        if (choice == 1) {
            playerturn(playerhand, dealerhand, deck);
        } else {
            this.round_start = false;
            dealerturn(playerhand, dealerhand, deck);
        }
    }

    public void playerWin() {
        this.player_score++;
        System.out.print("Вы выиграли раунд! Счёт " + this.player_score + ":" + this.dealer_score + "\n\n");
        this.player_turn_start_check = true;
    }

    public void dealerWin() {
        this.dealer_score++;
        System.out.print("Дилер выиграл раунд! Счёт " + this.player_score + ":" + this.dealer_score + "\n\n");
        this.player_turn_start_check = true;
    }

    public int playerShowCards(Hand playerhand) {
        int player_index = 0;
        int sumPlayer = 0;
        while (playerhand.getCard(player_index).getPoints() != 0) {
            sumPlayer = playerhand.handSum();
            if (player_index == playerhand.getNumberCards() - 1) {
                System.out.print(playerhand.showCards(true, sumPlayer, player_index, false));
                break;
            }
            System.out.print(playerhand.showCards(false, sumPlayer, player_index, false));
            player_index++;
        }
        return sumPlayer;
    }

    public int dealerShowCards(Hand dealerhand) {
        System.out.print("Карты Дилера: [");
        int dealer_index = 0;
        int sumDealer = 0;
        if (!this.dealer_round_start) {
            System.out.print(dealerhand.showCards(false, sumDealer, dealer_index, true));
            System.out.print("<закрытая карта>]\n");
            this.dealer_round_start = true;
            return sumDealer;
        }
        while (dealerhand.getCard(dealer_index).getPoints() != 0) {
            sumDealer = dealerhand.handSum();
            if (dealer_index == dealerhand.getNumberCards() - 1) {
                System.out.print(dealerhand.showCards(true, sumDealer, dealer_index, true));
                break;
            }
            System.out.print(dealerhand.showCards(false, sumDealer, dealer_index, true));
            dealer_index++;
        }
        return sumDealer;
    }

    public void roundResult(int sumPlayer, int sumDealer, boolean roundEnd) {
        if (sumPlayer == Gameplay.CRITICAL_NUMBER_21 || sumDealer > Gameplay.CRITICAL_NUMBER_21) {
            playerWin();
            Gameplay.startGame(this);
        }
        if (sumPlayer > Gameplay.CRITICAL_NUMBER_21 || sumDealer == Gameplay.CRITICAL_NUMBER_21) {
            dealerWin();
            Gameplay.startGame(this);
        }
        if (roundEnd) {
            if (sumPlayer >= sumDealer) {
                playerWin();
                Gameplay.startGame(this);
            }
            if (sumDealer > sumPlayer) {
                dealerWin();
                Gameplay.startGame(this);
            }
        }
    }
}
