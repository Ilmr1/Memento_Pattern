package org.example.memento_sm;

import java.util.ArrayList;
import java.util.List;

public class Memento {
    private final List<State> states = new ArrayList<>();
    private final List<State> redoStates = new ArrayList<>();

    public void saveState(State state) {
        states.add(state);
        redoStates.clear(); // Clear redo list on new state change
    }

    public State undo() {
        if (states.size() > 1) {
            State currentState = states.remove(states.size() - 1);
            redoStates.add(currentState);
            return states.get(states.size() - 1);
        }
        return null;
    }

    public State redo() {
        if (!redoStates.isEmpty()) {
            State redoState = redoStates.remove(redoStates.size() - 1);
            states.add(redoState);
            return redoState;
        }
        return null;
    }

    public List<State> getStates() {
        return states;
    }
}