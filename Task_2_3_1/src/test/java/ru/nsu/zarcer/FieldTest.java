package ru.nsu.zarcer;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class FieldTest {
    @Test
    void testFoodIsWithinBounds() {
        Field field = new Field();
        Position food = field.getFood();
        assertTrue(food.x >= 0 && food.x < field.getWidth());
        assertTrue(food.y >= 0 && food.y < field.getHeight());
    }

    @Test
    void testFoodDoesNotSpawnOnSnake() {
        Field field = new Field();
        Snake snake = new Snake(10, 10);
        field.generateFood(snake.getBody());
        assertFalse(snake.getBody().contains(field.getFood()));
    }

    @Test
    void testOutOfBoundsDetection() {
        Field field = new Field();
        assertTrue(field.isOutOfBounds(new Position(-1, 5)));
        assertTrue(field.isOutOfBounds(new Position(21, 5)));
        assertTrue(field.isOutOfBounds(new Position(5, -1)));
        assertTrue(field.isOutOfBounds(new Position(5, 16)));
        assertFalse(field.isOutOfBounds(new Position(10, 10)));
    }

}