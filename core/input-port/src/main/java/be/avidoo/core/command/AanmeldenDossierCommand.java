package be.avidoo.core.command;

import be.avidoo.core.common.command.Command;

import java.util.UUID;

import static be.avidoo.core.common.validation.Validation.validate;

public record AanmeldenDossierCommand() implements Command<UUID> {

    public AanmeldenDossierCommand {
        validate(this);
    }
}
