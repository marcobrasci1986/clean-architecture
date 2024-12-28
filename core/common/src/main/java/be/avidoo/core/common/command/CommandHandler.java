package be.avidoo.core.common.command;

/**
 * @param <C> Command Object
 */
public interface CommandHandler<C extends Command<T>, T> {
    T handle(CommandMessage<C> commandMessage);

    Class<C> getCommandClass();

}
