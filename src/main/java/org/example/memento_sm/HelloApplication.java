package org.example.memento_sm;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();

        HelloController helloController = fxmlLoader.getController();

        Stage historyStage = new Stage();
        FXMLLoader historyLoader = new FXMLLoader(HelloApplication.class.getResource("history-view.fxml"));
        Scene historyScene = new Scene(historyLoader.load(), 320, 240);
        historyStage.setTitle("History");
        historyStage.setScene(historyScene);
        historyStage.show();

        HistoryController historyController = historyLoader.getController();
        historyController.setMemento(helloController.getMemento());
        historyController.setHelloController(helloController);
    }

    public static void main(String[] args) {
        launch();
    }
}