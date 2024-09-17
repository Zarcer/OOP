package ru.nsu.zarcer;

public class Card {

    private String Name;
    private int points;
    private boolean taken;

    Card(String name, int price)
    {
        this.Name = name;
        this.points = price;
        taken = false;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public void setPoints(int point) {
        this.points = point;
    }

    public void setTaken(boolean check) {
        this.taken = check;
    }

    public String getName() {
        return this.Name;
    }

    public int getPoints() {
        return this.points;
    }

    public boolean getTaken() {
        return this.taken;
    }
}
