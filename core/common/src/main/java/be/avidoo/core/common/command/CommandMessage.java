/*-
 * #%L
 * IFG Dossierbeheersysteem
 * %%
 * Copyright (C) 2023 Vlaamse Overheid
 * %%
 * Licensed under the EUPL, Version 1.2 or – as soon they will be
 * approved by the European Commission - subsequent versions of the
 * EUPL (the "Licence");
 *
 * You may not use this work except in compliance with the Licence.
 * You may obtain a copy of the Licence at:
 *
 * https://joinup.ec.europa.eu/collection/eupl/eupl-text-eupl-12
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the Licence is distributed on an "AS IS" basis,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the Licence for the specific language governing permissions and
 * limitations under the Licence.
 * #L%
 */

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
