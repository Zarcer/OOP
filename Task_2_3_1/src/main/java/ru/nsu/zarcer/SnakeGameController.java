package ru.nsu.zarcer;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class SnakeGameController {
    private GameState model;
    private Timeline gameLoop;

    @FXML
    private Label scoreLabel;

    @FXML
    private Pane gameBoard;

    public SnakeGameController() {
        model = new GameState();
    }

    @FXML
    public void initialize() {
        scoreLabel.textProperty().bind(model.scoreProperty().asString("Score: %d"));
        startGameLoop();
    }

    public void startGameLoop() {
        gameLoop = new Timeline(new KeyFrame(Duration.millis(model.getSpeed()), this::updateGame));
        gameLoop.setCycleCount(Timeline.INDEFINITE);
        gameLoop.play();
    }

    private void updateGame(ActionEvent event) {
        model.update();
        if (model.isGameOver()) {
            gameLoop.stop();
        }
        updateGameBoard();
    }

    private void updateGameBoard() {
        gameBoard.getChildren().clear();
        Position foodPos = model.getField().getFood();
        Rectangle food = new Rectangle(20, 20, Color.RED);
        food.setX(foodPos.getX() * 20);
        food.setY(foodPos.getY() * 20);
        gameBoard.getChildren().add(food);
        for (Position pos : model.getSnake().getBody()) {
            Rectangle rect = new Rectangle(20, 20, Color.GREEN);
            rect.setX(pos.getX() * 20);
            rect.setY(pos.getY() * 20);
            gameBoard.getChildren().add(rect);
        }
    }

    public void handleKeyPress(javafx.scene.input.KeyEvent event) {
        KeyCode key = event.getCode();
        switch (key) {
            case W:
                model.getSnake().setDirection(Direction.UP);
                break;
            case S:
                model.getSnake().setDirection(Direction.DOWN);
                break;
            case A:
                model.getSnake().setDirection(Direction.LEFT);
                break;
            case D:
                model.getSnake().setDirection(Direction.RIGHT);
                break;
            default:
                break;
        }
    }
}
