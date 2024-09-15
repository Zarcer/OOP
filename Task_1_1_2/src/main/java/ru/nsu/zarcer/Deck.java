package ru.nsu.zarcer;

public class Deck {
    public static Card[] createDeck() {
        Card[] deck_for_play = new Card[52];
        Card[] deck_for_shuffle = new Card[52];
        for(int i = 0;i<52;i++) {
            deck_for_play[i] = new Card("haha", 0);
        }
        int counter = 0;
        deck_for_shuffle[0] = new Card("Двойка Трефы", 2);
        deck_for_shuffle[1] = new Card("Тройка Трефы", 3);
        deck_for_shuffle[2] = new Card("Четвёрка Трефы", 4);
        deck_for_shuffle[3] = new Card("Пятёрка Трефы", 5);
        deck_for_shuffle[4] = new Card("Шестёрка Трефы", 6);
        deck_for_shuffle[5] = new Card("Семёрка Трефы", 7);
        deck_for_shuffle[6] = new Card("Восьмёрка Трефы", 8);
        deck_for_shuffle[7] = new Card("Девятка Трефы", 9);
        deck_for_shuffle[8] = new Card("Десятка Трефы", 10);
        deck_for_shuffle[9] = new Card("Валет Трефы", 10);
        deck_for_shuffle[10] = new Card("Дама Трефы", 10);
        deck_for_shuffle[11] = new Card("Король Трефы", 10);
        deck_for_shuffle[12] = new Card("Туз Трефы", 11); //или 1 если больше 21
        deck_for_shuffle[13] = new Card("Двойка Бубны", 2);
        deck_for_shuffle[14] = new Card("Тройка Бубны", 3);
        deck_for_shuffle[15] = new Card("Четвёрка Бубны", 4);
        deck_for_shuffle[16] = new Card("Пятёрка Бубны", 5);
        deck_for_shuffle[17] = new Card("Шестёрка Бубны", 6);
        deck_for_shuffle[18] = new Card("Семёрка Бубны", 7);
        deck_for_shuffle[19] = new Card("Восьмёрка Бубны", 8);
        deck_for_shuffle[20] = new Card("Девятка Бубны", 9);
        deck_for_shuffle[21] = new Card("Десятка Бубны", 10);
        deck_for_shuffle[22] = new Card("Валет Бубны", 10);
        deck_for_shuffle[23] = new Card("Дама Бубны", 10);
        deck_for_shuffle[24] = new Card("Король Бубны", 10);
        deck_for_shuffle[25] = new Card("Туз Бубны", 11);
        deck_for_shuffle[26] = new Card("Двойка Черви", 2);
        deck_for_shuffle[27] = new Card("Тройка Черви", 3);
        deck_for_shuffle[28] = new Card("Четвёрка Черви", 4);
        deck_for_shuffle[29] = new Card("Пятёрка Черви", 5);
        deck_for_shuffle[30] = new Card("Шестёрка Черви", 6);
        deck_for_shuffle[31] = new Card("Семёрка Черви", 7);
        deck_for_shuffle[32] = new Card("Восьмёрка Черви", 8);
        deck_for_shuffle[33] = new Card("Девятка Черви", 9);
        deck_for_shuffle[34] = new Card("Десятка Черви", 10);
        deck_for_shuffle[35] = new Card("Валет Черви", 10);
        deck_for_shuffle[36] = new Card("Дама Черви", 10);
        deck_for_shuffle[37] = new Card("Король Черви", 10);
        deck_for_shuffle[38] = new Card("Туз Черви", 11);
        deck_for_shuffle[39] = new Card("Двойка Пики", 2);
        deck_for_shuffle[40] = new Card("Тройка Пики", 3);
        deck_for_shuffle[41] = new Card("Четвёрка Пики", 4);
        deck_for_shuffle[42] = new Card("Пятёрка Пики", 5);
        deck_for_shuffle[43] = new Card("Шестёрка Пики", 6);
        deck_for_shuffle[44] = new Card("Семёрка Пики", 7);
        deck_for_shuffle[45] = new Card("Восьмёрка Пики", 8);
        deck_for_shuffle[46] = new Card("Девятка Пики", 9);
        deck_for_shuffle[47] = new Card("Десятка Пики", 10);
        deck_for_shuffle[48] = new Card("Валет Пики", 10);
        deck_for_shuffle[49] = new Card("Дама Пики", 10);
        deck_for_shuffle[50] = new Card("Король Пики", 10);
        deck_for_shuffle[51] = new Card("Туз Пики", 11);
        while(counter != 52)
        {
            int i = (int)(Math.random()*52);
            if (deck_for_shuffle[i].taken)
            {
                continue;
            }
            deck_for_play[counter].points = deck_for_shuffle[i].points;
            deck_for_play[counter].Name = deck_for_shuffle[i].Name;
            deck_for_shuffle[i].taken = true;
            counter++;
        }
        return deck_for_play;
    }
}

