package ru.nsu.zarcer;

public class Card {
    String Name;
    int points;
    boolean taken;
    Card(String name, int price)
    {
        this.Name = name;
        this.points = price;
        taken = false;
    }
}
