package ru.nsu.zarcer;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.scene.input.KeyCode;
import javafx.util.Duration;

public class SnakeGameController {
    private SnakeGameModel model;
    private SnakeGameView view;
    private Timeline gameLoop;

    public SnakeGameController(SnakeGameModel model, SnakeGameView view) {
        this.model = model;
        this.view = view;
    }

    public void startGameLoop() {
        gameLoop = new Timeline(new KeyFrame(Duration.millis(model.getSpeed()), this::updateGame));
        gameLoop.setCycleCount(Timeline.INDEFINITE);
        gameLoop.play();
    }

    private void updateGame(ActionEvent event) {
        model.moveSnake();
        view.updateGrid();
        if (model.isGameOver()) {
            gameLoop.stop();
            System.out.println("stop");
        }
    }

    public void handleKeyPress(javafx.scene.input.KeyEvent event) {
        KeyCode key = event.getCode();
        switch (key) {
            case UP:
                model.setDirection(Direction.UP);
                break;
            case DOWN:
                model.setDirection(Direction.DOWN);
                break;
            case LEFT:
                model.setDirection(Direction.LEFT);
                break;
            case RIGHT:
                model.setDirection(Direction.RIGHT);
                break;
            default:
                break;
        }
    }
}

