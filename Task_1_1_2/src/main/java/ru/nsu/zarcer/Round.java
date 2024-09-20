package ru.nsu.zarcer;

import java.util.Scanner;

/**
 * Class of one game round.
 */
public class Round {

    private boolean roundstart;
    private boolean dealerRoundStart;
    private boolean playerturnstartcheck;
    private Scanner in;
    private int roundcount;
    private int dealerscore;
    private int playerscore;

    {
        playerscore = 0;
        dealerscore = 0;
        roundstart = true;
        dealerRoundStart = false;
        playerturnstartcheck = true;
        roundcount = 1;
        in = new Scanner(System.in);
    }

    /**Invokes when player decides to draw another card.
     *
     * @param playerhand hand with player cards
     *
     * @param dealerhand hand with dealer cards
     *
     * @param deck shuffled deck
     */
    public void playerturn(Hand playerhand, Hand dealerhand, Deck deck) {
        this.dealerRoundStart = false;
        playerhand.withdraw(deck);
        System.out.print("Вы открыли карту "
                + playerhand.lastCard().getNamee()
                + " ("
                + playerhand.lastCard().getPoints()
                + ")\n\t Ваши карты: [");
        int sumPlayer = playerShowCards(playerhand);
        int sumDealer = dealerShowCards(dealerhand);
        roundResult(sumPlayer, sumDealer, false);
        choice(playerhand, dealerhand, deck);
    }

    /**Just getter.
     *
     * @return return round count
     */
    public int roundcountGet() {
        return this.roundcount;
    }

    /**
     * Adds 1 round to round counter.
     */
    public void roundcountAdd() {
        this.roundcount++;
    }

    /**Just getter.
     *
     * @return returns player score
     */
    public int getPlayerscore() {
        return this.playerscore;
    }

    /**Just getter.
     *
     * @return returns dealer score
     */
    public int getDealerscore() {
        return this.dealerscore;
    }

    /**invokes when player pass the turn to dealer.
     *
     * @param playerhand hand with player cards
     *
     * @param dealerhand hand with dealer cards
     *
     * @param deck shuffled deck
     */
    public void dealerturn(Hand playerhand, Hand dealerhand, Deck deck) {
        this.dealerRoundStart = true;
        System.out.print("Ход Дилера\n-------\n");
        int sumDealer = 0;
        int sumPlayer = 0;
        while (sumDealer < Gameplay.DEALERSTOP17) {
            dealerhand.withdraw(deck);
            if (!this.roundstart) {
                System.out.print("Дилер открывает закрытую карту "
                        + dealerhand.lastCard().getNamee()
                        + " ("
                        + dealerhand.lastCard().getPoints()
                        + ")\n\t Ваши карты: [");
                this.roundstart = true;
            } else {
                System.out.print("Дилер открывает карту "
                        + dealerhand.lastCard().getNamee()
                        + " ("
                        + dealerhand.lastCard().getPoints()
                        + ")\n\t Ваши карты: [");
            }
            sumPlayer = playerShowCards(playerhand);
            sumDealer = dealerShowCards(dealerhand);
        }
        roundResult(sumPlayer, sumDealer, true);
    }

    /**Player choose his next move.
     *
     * @param playerhand hand with player cards
     *
     * @param dealerhand hand with dealer cards
     *
     * @param deck shuffled deck
     */
    public void choice(Hand playerhand, Hand dealerhand, Deck deck) {
        if (this.playerturnstartcheck) {
            System.out.println("Ваш ход\n-------\nВведите "
                    + 1
                    + ", чтобы взять карту, и "
                    + 0
                    + ", чтобы остановиться...");
            this.playerturnstartcheck = false;
        } else {
            System.out.println("Введите "
                    + 1
                    + ", чтобы взять карту, и "
                    + 0
                    + ", чтобы остановиться...");
        }
        int choice = this.in.nextInt();
        if (choice == -1) {
            return;
        }
        if (choice == 1) {
            playerturn(playerhand, dealerhand, deck);
        } else {
            this.roundstart = false;
            dealerturn(playerhand, dealerhand, deck);
        }
    }

    /**
     * Method if player wins.
     */
    public void playerWin() {
        this.playerscore++;
        System.out.print("Вы выиграли раунд! Счёт "
                + this.playerscore
                + ":"
                + this.dealerscore
                + "\n\n");
        this.playerturnstartcheck = true;
    }

    /**
     * Method if dealer wins.
     */
    public void dealerWin() {
        this.dealerscore++;
        System.out.print("Дилер выиграл раунд! Счёт "
                + this.playerscore
                + ":"
                + this.dealerscore
                + "\n\n");
        this.playerturnstartcheck = true;
    }

    /**Method where cards in player hand outputs and their sum being calculated.
     *
     * @param playerhand hand with player cards
     *
     * @return int value(sum of player cards)
     */
    public int playerShowCards(Hand playerhand) {
        int playerindex = 0;
        int sumPlayer = 0;
        while (playerhand.getCard(playerindex).getPoints() != 0) {
            sumPlayer = playerhand.handSum();
            if (playerindex == playerhand.getNumberCards() - 1) {
                System.out.print(playerhand.showCards(true, sumPlayer, playerindex, false));
                break;
            }
            System.out.print(playerhand.showCards(false, sumPlayer, playerindex, false));
            playerindex++;
        }
        return sumPlayer;
    }

    /**Method where cards in dealer hand outputs and their sum being calculated.
     *
     * @param dealerhand hand with dealer cards
     *
     * @return int value(sum of dealer cards)
     */
    public int dealerShowCards(Hand dealerhand) {
        System.out.print("Карты Дилера: [");
        int dealerindex = 0;
        int sumDealer = 0;
        if (!this.dealerRoundStart) {
            System.out.print(dealerhand.showCards(false, sumDealer, dealerindex, true));
            System.out.print("<закрытая карта>]\n");
            this.dealerRoundStart = true;
            return sumDealer;
        }
        while (dealerhand.getCard(dealerindex).getPoints() != 0) {
            sumDealer = dealerhand.handSum();
            if (dealerindex == dealerhand.getNumberCards() - 1) {
                System.out.print(dealerhand.showCards(true, sumDealer, dealerindex, true));
                break;
            }
            System.out.print(dealerhand.showCards(false, sumDealer, dealerindex, true));
            dealerindex++;
        }
        return sumDealer;
    }

    /**Method for checking winner.
     *
     * @param sumPlayer sum of player cards
     *
     * @param sumDealer sum of dealer cards
     *
     * @param roundEnd flag if round will end in standart way
     */
    public void roundResult(int sumPlayer, int sumDealer, boolean roundEnd) {
        if (sumPlayer == Gameplay.CRITICAL_NUMBER21 || sumDealer > Gameplay.CRITICAL_NUMBER21) {
            playerWin();
            Gameplay.startGame(this);
        }
        if (sumPlayer > Gameplay.CRITICAL_NUMBER21 || sumDealer == Gameplay.CRITICAL_NUMBER21) {
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
