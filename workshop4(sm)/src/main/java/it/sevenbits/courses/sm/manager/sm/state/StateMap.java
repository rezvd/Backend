package it.sevenbits.courses.sm.manager.sm.state;

import it.sevenbits.courses.sm.manager.sm.Pair;

import java.util.HashMap;
import java.util.Map;

public class StateMap {
    private final State defaultState = new State("ignore");

    private final Map<Pair<State, String>, State> states;

    public StateMap() {
        this.states = new HashMap<>();

        State listenState = new State("listen");
        State stubSuspicion = new State("trash-suspicion");

        states.put(new Pair<>(defaultState, "MESSAGE"), defaultState);
        states.put(new Pair<>(defaultState, "TRASH"), defaultState);
        states.put(new Pair<>(defaultState, "MESSAGE_START"), listenState);
        states.put(new Pair<>(defaultState, "MESSAGE_FINISH"), defaultState);
        states.put(new Pair<>(listenState, "MESSAGE"), listenState);
        states.put(new Pair<>(listenState, "TRASH"), stubSuspicion);
        states.put(new Pair<>(listenState, "MESSAGE_START"), listenState);
        states.put(new Pair<>(listenState, "MESSAGE_FINISH"), defaultState);
        states.put(new Pair<>(stubSuspicion, "MESSAGE"), stubSuspicion);
        states.put(new Pair<>(stubSuspicion, "TRASH"), defaultState);
        states.put(new Pair<>(stubSuspicion, "MESSAGE_START"), listenState);
        states.put(new Pair<>(stubSuspicion, "MESSAGE_FINISH"), defaultState);
    }

    public State getStartState() {
        return defaultState;
    }

    public State getNextState(final State state, final String signal) {
        return states.getOrDefault(new Pair<>(state, signal), defaultState);
    }

}
