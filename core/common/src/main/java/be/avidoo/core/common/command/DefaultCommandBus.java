package be.avidoo.core.common.command;

public class DefaultCommandBus implements CommandBus {

    private final CommandHandlerRegistry commandHandlerRegistry;

    public DefaultCommandBus(CommandHandlerRegistry commandHandlerRegistry) {
        this.commandHandlerRegistry = commandHandlerRegistry;
    }

    @Override
    public <C extends Command<T>, T> T execute(CommandMessage<C> commandMessage) {
        Command<T> command = commandMessage.getCommand();
        return commandHandlerRegistry.findByCommand(command).handle((CommandMessage<Command<T>>) commandMessage);
    }
}
