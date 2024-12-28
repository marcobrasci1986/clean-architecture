package be.avidoo.core.common.command;


import static be.avidoo.core.common.command.CommandMessage.commandMessage;

public interface CommandBus {


    default <T> T execute(Command<T> command) {
        return execute(commandMessage(command));
    }

    <C extends Command<T>, T> T execute(CommandMessage<C> commandMessage);

}
