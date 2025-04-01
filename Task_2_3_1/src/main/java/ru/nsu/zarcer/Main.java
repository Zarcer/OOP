package ru.nsu.zarcer;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(SnakeGameController.
            class.getClassLoader().getResource("snake.fxml"));
        Scene scene = new Scene(loader.load());
        SnakeGameController controller = loader.getController();
        scene.setOnKeyPressed(controller::handleKeyPress);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
