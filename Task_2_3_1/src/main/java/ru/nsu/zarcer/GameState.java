package ru.nsu.zarcer;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

/**
 * Class for controlling game logic using Snake and field classes.
 */
public class GameState {
    private static final int SPEED = 500;
    private IntegerProperty score = new SimpleIntegerProperty(0);
    private Snake snake;
    private Field field;
    private boolean gameOver;

    /**
     * Initializer, creation of field and snake, also check of gameOver.
     */
    public GameState() {
        field = new Field();
        snake = new Snake(field.getWidth() / 2, field.getHeight() / 2);
        gameOver = false;
    }

    public IntegerProperty scoreProperty() {
        return score;
    }

    public void increaseScore() {
        score.set(score.get() + 10);
    }

    /**
     * Cycle movement, generating food, checking collisions.
     */
    public void update() {
        if (gameOver) {
            return;
        }
        Position newHead = snake.getHead().move(snake.getDirection());
        if (field.isOutOfBounds(newHead) || snake.checkCollision(newHead)) {
            gameOver = true;
            return;
        }
        boolean ateFood = newHead.equals(field.getFood());
        snake.move(ateFood);
        if (ateFood) {
            increaseScore();
            field.generateFood(snake.getBody());
        }
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public Snake getSnake() {
        return snake;
    }

    public Field getField() {
        return field;
    }

    public int getSpeed() {
        return SPEED;
    }
}

