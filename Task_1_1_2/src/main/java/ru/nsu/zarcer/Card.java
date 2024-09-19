package ru.nsu.zarcer;

/**
 * Card class.
 */
public class Card {
    private String Name;
    private int points;
    private boolean taken;

    /**
     *
     * @param name card name
     *
     * @param price card cost
     */
    Card(String name, int price) {
        this.Name = name;
        this.points = price;
        taken = false;
    }

    /**
     *
     * @param name setter
     */
    public void setName(String name) {
        this.Name = name;
    }

    /**
     *
     * @param point setter
     */
    public void setPoints(int point) {
        this.points = point;
    }

    /**
     *
     * @param check setter
     */
    public void setTaken(boolean check) {
        this.taken = check;
    }

    /**
     *
     * @return getter
     */
    public String getName() {
        return this.Name;
    }

    /**
     *
     * @return getter
     */
    public int getPoints() {
        return this.points;
    }

    /**
     *
     * @return getter
     */
    public boolean getTaken() {
        return this.taken;
    }
}
