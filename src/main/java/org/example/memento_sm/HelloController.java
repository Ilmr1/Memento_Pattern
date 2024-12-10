package org.example.memento_sm;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class HelloController {
    @FXML
    private Label welcomeText;

    private final Memento memento = new Memento();

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
        memento.saveState(new State(welcomeText.getText()));
    }

    @FXML
    private void handleKeyPress(KeyEvent event) {
        if (event.isControlDown() && event.getCode() == KeyCode.Z) {
            State state = memento.undo();
            if (state != null) {
                welcomeText.setText(state.getText());
            }
        } else if (event.isControlDown() && event.getCode() == KeyCode.Y) {
            State state = memento.redo();
            if (state != null) {
                welcomeText.setText(state.getText());
            }
        }
    }

    public void restoreState(State state) {
        welcomeText.setText(state.getText());
    }

    public Memento getMemento() {
        return memento;
    }
}