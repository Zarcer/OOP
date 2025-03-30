package ru.nsu.zarcer;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class SnakeTest {

    @Test
    void testInitialSnakeSize() {
        Snake snake = new Snake(5, 5);
        assertEquals(1, snake.getBody().size());
    }

    @Test
    void testMoveSnake() {
        Snake snake = new Snake(5, 5);
        snake.setDirection(Direction.RIGHT);
        snake.move(false);
        assertEquals(new Position(6, 5), snake.getHead());
        assertEquals(1, snake.getBody().size());
    }

    @Test
    void testGrowSnake() {
        Snake snake = new Snake(5, 5);
        snake.setDirection(Direction.DOWN);
        snake.move(true);
        assertEquals(new Position(5, 6), snake.getHead());
        assertEquals(2, snake.getBody().size());
    }

    @Test
    void testSelfCollision() {
        Snake snake = new Snake(5, 5);
        snake.setDirection(Direction.RIGHT);
        snake.move(true);
        snake.move(true);
        snake.setDirection(Direction.LEFT);
        snake.move(false);
        assertTrue(snake.checkCollision(snake.getHead()));
    }

    @Test
    void testInvalidDirectionChange() {
        Snake snake = new Snake(5, 5);
        snake.setDirection(Direction.LEFT);
        snake.move(false);
        assertEquals(new Position(6, 5), snake.getHead());
    }

}