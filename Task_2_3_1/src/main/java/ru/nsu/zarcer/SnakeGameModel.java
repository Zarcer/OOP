package ru.nsu.zarcer;

import java.util.LinkedList;
import java.util.Random;

public class SnakeGameModel {
    private static final int TILE_SIZE = 20;
    private static final int WIDTH = 20, HEIGHT = 15;
    private static final int SPEED = 500;
    private LinkedList<Position> snake;
    private Position food;
    private Direction direction;
    private boolean gameOver;
    private Random random;

    public SnakeGameModel() {
        snake = new LinkedList<>();
        snake.add(new Position(WIDTH / 2, HEIGHT / 2));
        direction = Direction.RIGHT;
        random = new Random();
        generateFood();
    }

    public void moveSnake() {
        if (gameOver) return;
        Position newHead = snake.getFirst().move(direction);
        if (outOfBounds(newHead) || snake.contains(newHead)) {
            gameOver = true;
            return;
        }
        snake.addFirst(newHead);
        if(newHead.equals(food)) {
            generateFood();
        } else {
            snake.removeLast();
        }
    }

    private void generateFood() {
        do {
            food = new Position(random.nextInt(WIDTH), random.nextInt(HEIGHT));
        } while (snake.contains(food));
    }

    private boolean outOfBounds(Position pos) {
        return pos.x < 0 || pos.x >= WIDTH || pos.y < 0 || pos.y >= HEIGHT;
    }

    public LinkedList<Position> getSnake() {
        return snake;
    }
    public Position getFood() {
        return food;
    }
    public boolean isGameOver() {
        return gameOver;
    }
    public int getTileSize() {
        return TILE_SIZE;
    }
    public int getWidth() {
        return WIDTH;
    }
    public int getHeight() {
        return HEIGHT;
    }
    public int getSpeed() {
        return SPEED;
    }

    public void setDirection(Direction newDirection) {
        if ((direction == Direction.UP && newDirection == Direction.DOWN) ||
            (direction == Direction.DOWN && newDirection == Direction.UP) ||
            (direction == Direction.LEFT && newDirection == Direction.RIGHT) ||
            (direction == Direction.RIGHT && newDirection == Direction.LEFT)) {
            return;
        }
        direction = newDirection;
    }

}