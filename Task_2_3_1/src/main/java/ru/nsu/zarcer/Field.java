package ru.nsu.zarcer;

import java.util.LinkedList;
import java.util.Random;

/**
 *Field class, mainly for generating food and checking collision with walls.
 */
public class Field {

    private static final int WIDTH = 20;
    private static final int HEIGHT = 15;
    private Position food;
    private Random random;

    /**
     * Initializer with random.
     */
    public Field() {
        random = new Random();
        generateFood(new LinkedList<>());
    }

    /**
     * Method for generating food.
     *
     * @param snakeBody needed for food not spawning in snake body
     *
     */
    public void generateFood(LinkedList<Position> snakeBody) {
        do {
            food = new Position(random.nextInt(WIDTH), random.nextInt(HEIGHT));
        } while (snakeBody.contains(food));
    }

    public boolean isOutOfBounds(Position pos) {
        return pos.getX() < 0 || pos.getX() >= WIDTH || pos.getY() < 0 || pos.getY() >= HEIGHT;
    }

    public Position getFood() {
        return food;
    }

    public int getWidth() {
        return WIDTH;
    }

    public int getHeight() {
        return HEIGHT;
    }
}
