package ru.nsu.zarcer;

import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class SnakeGameView {
    private GridPane grid;
    private SnakeGameModel model;

    public SnakeGameView(SnakeGameModel model) {
        this.model = model;
        this.grid = new GridPane();
        updateGrid();
    }

    public void updateGrid() {
        grid.getChildren().clear();
        for (int x = 0; x < model.getWidth(); x++) {
            for (int y = 0; y < model.getHeight(); y++) {
                renderCell(new Position(x, y), Color.LIGHTGRAY);
            }
        }
        renderCell(model.getFood(), Color.RED);
        for (Position pos : model.getSnake()) {
            renderCell(pos, Color.GREEN);
        }
    }

    private void renderCell(Position pos, Color color) {
        Rectangle rect = new Rectangle(model.getTileSize(), model.getTileSize());
        rect.setFill(color);
        rect.setStroke(Color.BLACK);
        grid.add(rect, pos.x, pos.y);
    }

    public GridPane getGrid() {
        return grid;
    }
}

