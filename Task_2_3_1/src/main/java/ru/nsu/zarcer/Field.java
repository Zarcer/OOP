package ru.nsu.zarcer;

import java.util.LinkedList;
import java.util.Random;

public class Field {
    private static final int WIDTH = 20;
    private static final int HEIGHT = 15;
    private Position food;
    private Random random;

    public Field() {
        random = new Random();
        generateFood(new LinkedList<>());
    }

    public void generateFood(LinkedList<Position> snakeBody) {
        do {
            food = new Position(random.nextInt(WIDTH), random.nextInt(HEIGHT));
        } while (snakeBody.contains(food));
    }

    public boolean isOutOfBounds(Position pos) {
        return pos.x < 0 || pos.x >= WIDTH || pos.y < 0 || pos.y >= HEIGHT;
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
