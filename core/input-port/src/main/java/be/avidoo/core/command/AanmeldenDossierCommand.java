package be.avidoo.core.command;

import be.avidoo.core.common.command.Command;

import java.util.UUID;

public record AanmeldenDossierCommand(String fjcPrefix) implements Command<UUID> {
}
