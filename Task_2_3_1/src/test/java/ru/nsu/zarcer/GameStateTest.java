package ru.nsu.zarcer;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class GameStateTest {

    @Test
    void testInitialScoreIsZero() {
        GameState gameState = new GameState();
        assertEquals(0, gameState.scoreProperty().get());
    }

    @Test
    void testGameOverOnWallBound() {
        GameState gameState = new GameState();
        gameState.getSnake().setDirection(Direction.LEFT);
        for (int i = 0; i < 10; i++) {
            gameState.update();
        }
        assertTrue(gameState.isGameOver());
    }
}