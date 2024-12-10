package org.example.memento_sm;

public class State {
    private final String text;

    public State(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}