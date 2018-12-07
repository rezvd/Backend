package it.sevenbits.courses.sm.manager.sm.command.command_repository;

import it.sevenbits.courses.sm.manager.sm.BufferSM;
import it.sevenbits.courses.sm.manager.sm.command.ICommand;

public class CommandWrite implements ICommand {
    private BufferSM buffer;

    public CommandWrite(final BufferSM buffer) {
        this.buffer = buffer;
    }

    public void execute(final String message) {
        System.out.println("\t" + buffer);
        buffer.clear();
    }
}