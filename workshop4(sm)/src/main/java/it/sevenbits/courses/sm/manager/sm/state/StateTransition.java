package it.sevenbits.courses.sm.manager.sm.state;

import it.sevenbits.courses.sm.network.NetworkPackage;

public class StateTransition {
    private final StateMap stateMap;

    public StateTransition() {
        this.stateMap = new StateMap();
    }

    public State getStartState() {
        return stateMap.getStartState();
    }

    public State getNextState(final State state, NetworkPackage p) {
        return stateMap.getNextState(state, p.getType());

    }
}
