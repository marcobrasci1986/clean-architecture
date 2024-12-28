package be.avidoo.core.common.command;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.toMap;

@Component
public class CommandHandlerRegistry {

    private final Map<Class<? extends Command<?>>, CommandHandler<?, ?>> commandHandlerByCommandClass;

    public CommandHandlerRegistry(List<CommandHandler<? extends Command<?>, ?>> commandHandlers) {
        this.commandHandlerByCommandClass = commandHandlers.stream()
                .collect(toMap(CommandHandler::getCommandClass, identity()));
    }

    @SuppressWarnings("unchecked")
    public <T> CommandHandler<Command<T>, T> findByCommand(Command<T> command) {
        return commandHandlerByCommandClass.entrySet().stream()
                .filter(entry -> entry.getKey().isAssignableFrom(command.getClass()))
                .map(entry -> (CommandHandler<Command<T>, T>) entry.getValue())
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("No command handler configured for command " + command));
    }
}
