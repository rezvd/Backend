package it.sevenbits.courses.sm.manager.sm.command;

import it.sevenbits.courses.sm.manager.sm.state.State;
import it.sevenbits.courses.sm.network.NetworkPackage;

public interface INetworkManagerCommand {

    void buildMessage(State state, NetworkPackage p);
}
