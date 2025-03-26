package ru.nsu.zarcer;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) {
        SnakeGameModel model = new SnakeGameModel();
        SnakeGameView view = new SnakeGameView(model);
        SnakeGameController controller = new SnakeGameController(model, view);
        Scene scene = new Scene(view.getGrid(), model.getWidth() * model.getTileSize(), model.getHeight() * model.getTileSize());
        scene.setOnKeyPressed(controller::handleKeyPress);
        stage.setScene(scene);
        stage.show();
        controller.startGameLoop();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
