package it.sevenbits.courses.sm.manager.sm.command.command_repository;

import it.sevenbits.courses.sm.manager.sm.BufferSM;
import it.sevenbits.courses.sm.manager.sm.command.ICommand;

public class CommandAddToBuffer implements ICommand {
    private BufferSM buffer;

    public CommandAddToBuffer(final BufferSM buffer) {
        this.buffer = buffer;
    }

    @Override
    public void execute(final String message) {
        buffer.write(message);
    }
}
