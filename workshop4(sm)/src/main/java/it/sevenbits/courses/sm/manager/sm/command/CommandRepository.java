package it.sevenbits.courses.sm.manager.sm.command;

import it.sevenbits.courses.sm.manager.sm.BufferSM;
import it.sevenbits.courses.sm.manager.sm.Pair;
import it.sevenbits.courses.sm.manager.sm.command.command_repository.CommandClear;
import it.sevenbits.courses.sm.manager.sm.state.State;
import it.sevenbits.courses.sm.manager.sm.command.command_repository.CommandAddToBuffer;
import it.sevenbits.courses.sm.manager.sm.command.command_repository.CommandIgnore;
import it.sevenbits.courses.sm.manager.sm.command.command_repository.CommandWrite;

import java.util.HashMap;
import java.util.Map;

public class CommandRepository {
    private Map<Pair<State, String>, ICommand> commands;
    private BufferSM buffer;

    public CommandRepository(final BufferSM buffer) {
        commands = new HashMap<>();
        this.buffer = buffer;

        State listenState = new State("listen");
        State stubSuspicion = new State("trash-suspicion");
        State defaultState = new State("ignore");

        commands.put(new Pair<>(defaultState, "TRASH"), new CommandIgnore(buffer));
        commands.put(new Pair<>(defaultState, "MESSAGE"), new CommandIgnore(buffer));
        commands.put(new Pair<>(defaultState, "MESSAGE_START"), new CommandAddToBuffer(buffer));
        commands.put(new Pair<>(defaultState, "MESSAGE_FINISH"), new CommandIgnore(buffer));
        commands.put(new Pair<>(listenState, "TRASH"), new CommandIgnore(buffer));
        commands.put(new Pair<>(listenState, "MESSAGE"), new CommandAddToBuffer(buffer));
        commands.put(new Pair<>(listenState, "MESSAGE_START"), new CommandAddToBuffer(buffer));
        commands.put(new Pair<>(listenState, "MESSAGE_FINISH"), new CommandWrite(buffer));
        commands.put(new Pair<>(stubSuspicion, "TRASH"), new CommandClear(buffer));
        commands.put(new Pair<>(stubSuspicion, "MESSAGE"), new CommandAddToBuffer(buffer));
        commands.put(new Pair<>(stubSuspicion, "MESSAGE_START"), new CommandAddToBuffer(buffer));
        commands.put(new Pair<>(stubSuspicion, "MESSAGE_FINISH"), new CommandWrite(buffer));
    }

    public ICommand getCommand(final State state, final String messageType) {
        return commands.getOrDefault(new Pair<>(state, messageType), new CommandIgnore(buffer));
    }
}