package it.sevenbits.courses.sm.manager;

import it.sevenbits.courses.sm.manager.sm.state.State;
import it.sevenbits.courses.sm.manager.sm.state.StateTransition;
import it.sevenbits.courses.sm.manager.sm.command.NetworkManagerCommand;
import it.sevenbits.courses.sm.network.INetwork;
import it.sevenbits.courses.sm.network.NetworkPackage;

public class StateMachineNetworkManager implements INetworkManager {
    private boolean isInterrupted = false;
    private long TIMEOUT = 1000;
    private StateTransition stateTransition;

    public StateMachineNetworkManager() {
        this.stateTransition = new StateTransition();
    }

    @Override
    public void listen(INetwork network) throws NetworkManagerException {
        State currentState = stateTransition.getStartState();
        NetworkManagerCommand networkManagerCommand = new NetworkManagerCommand();

        try {
            while(!isInterrupted) {
                while(network.hasPackage()) {
                    NetworkPackage p = network.getPackage();
                    networkManagerCommand.buildMessage(currentState, p);
                    currentState = stateTransition.getNextState(currentState, p);
                    System.out.println(String.format("%1$s: %2$s", p.getType(), currentState));
                }
                Thread.sleep(TIMEOUT);
            }
        } catch (InterruptedException e) {
            throw new NetworkManagerException("Network manager was interrupted unexpectedly", e);
        }
    }

    @Override
    public void stop() {
        this.isInterrupted = true;
    }
}

