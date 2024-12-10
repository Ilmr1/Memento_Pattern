package org.example.memento_sm;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;

public class HistoryController {
    @FXML
    private ListView<String> historyListView;

    private Memento memento;
    private HelloController helloController;

    public void setMemento(Memento memento) {
        this.memento = memento;
        updateHistoryList();
    }

    public void setHelloController(HelloController helloController) {
        this.helloController = helloController;
    }

    @FXML
    public void initialize() {
        historyListView.setOnMouseClicked(this::handleHistorySelection);
    }

    private void updateHistoryList() {
        historyListView.getItems().clear();
        for (State state : memento.getStates()) {
            historyListView.getItems().add(state.getText());
        }
    }

    private void handleHistorySelection(MouseEvent event) {
        int selectedIndex = historyListView.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            State selectedState = memento.getStates().get(selectedIndex);
            helloController.restoreState(selectedState);
        }
    }
}