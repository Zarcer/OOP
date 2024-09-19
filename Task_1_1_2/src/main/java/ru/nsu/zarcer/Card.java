package ru.nsu.zarcer;

/**
 * Card class.
 */
public class Card {
    private String namee;
    private int points;
    private boolean taken;

    /**Creator of card.
     *
     * @param namee card namee
     *
     * @param price card cost
     */
    Card(String namee, int price) {
        this.namee = namee;
        this.points = price;
        taken = false;
    }

    /**Just setter.
     *
     * @param namee setter
     */
    public void setNamee(String namee) {
        this.namee = namee;
    }

    /**Just setter.
     *
     * @param point setter
     */
    public void setPoints(int point) {
        this.points = point;
    }

    /**Just setter.
     *
     * @param check setter
     */
    public void setTaken(boolean check) {
        this.taken = check;
    }

    /**Just getter.
     *
     * @return getter
     */
    public String getNamee() {
        return this.namee;
    }

    /**Just getter
     *
     * @return getter
     */
    public int getPoints() {
        return this.points;
    }

    /**Just getter
     *
     * @return getter
     */
    public boolean getTaken() {
        return this.taken;
    }
}
