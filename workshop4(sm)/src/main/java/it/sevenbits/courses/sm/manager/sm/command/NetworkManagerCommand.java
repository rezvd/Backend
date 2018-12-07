package it.sevenbits.courses.sm.manager.sm.command;

import it.sevenbits.courses.sm.manager.sm.BufferSM;
import it.sevenbits.courses.sm.manager.sm.state.State;
import it.sevenbits.courses.sm.network.NetworkPackage;

public class NetworkManagerCommand implements INetworkManagerCommand{
    private CommandRepository commands;
    private BufferSM buffer;

    public NetworkManagerCommand() {
        buffer = new BufferSM();
        commands = new CommandRepository(buffer);
    }

    public void buildMessage(State state, NetworkPackage p) {
        commands.getCommand(state, p.getType()).execute(p.getMessage());
    }
}