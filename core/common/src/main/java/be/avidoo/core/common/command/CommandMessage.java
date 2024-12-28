package be.avidoo.core.common.command;

import java.time.LocalDateTime;
import java.util.Optional;

public class CommandMessage<C extends Command<?>> {

    private final C command;
    private final LocalDateTime tijdstip;
    private final Object response;

    public CommandMessage(C command, LocalDateTime tijdstip, Object response) {
        this.command = command;
        this.tijdstip = Optional.ofNullable(tijdstip).orElse(LocalDateTime.now());
        this.response = response;
    }

    public static <C extends Command<T>, T> CommandMessage<C> commandMessage(C command) {
        return new CommandMessageBuilder<C>().withCommand(command).build();
    }

    public static <C extends Command<?>> CommandMessageBuilder<C> builder() {
        return new CommandMessageBuilder<>();
    }

    public C getCommand() {
        return command;
    }

    public LocalDateTime getTijdstip() {
        return tijdstip;
    }

    public Object getResponse() {
        return response;
    }

    public static final class CommandMessageBuilder<C extends Command<?>> {
        private C command;
        private LocalDateTime tijdstip;
        private Object response;

        private CommandMessageBuilder() {
        }

        public CommandMessageBuilder<C> withCommand(C command) {
            this.command = command;
            return this;
        }

        public CommandMessageBuilder<C> withTijdstip(LocalDateTime tijdstip) {
            this.tijdstip = tijdstip;
            return this;
        }

        public CommandMessageBuilder<C> withResponse(Object response) {
            this.response = response;
            return this;
        }

        public CommandMessage<C> build() {
            return new CommandMessage<>(command, tijdstip, response);
        }
    }
}
