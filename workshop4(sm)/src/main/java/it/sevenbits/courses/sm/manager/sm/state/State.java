package it.sevenbits.courses.sm.manager.sm.state;

import java.util.Objects;

public class State {
    private String currentState;

    public State(String currentState) {
        this.currentState = currentState;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        State state = (State) o;
        return Objects.equals(currentState, state.currentState);
    }

    @Override
    public int hashCode() {
        return Objects.hash(currentState);
    }

    @Override
    public String toString() {
        return currentState;
    }
}
