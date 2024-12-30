package be.avidoo.core.command;

import be.avidoo.core.common.command.Command;
import be.avidoo.domain.aggregate.dossier.DossierId;
import be.avidoo.domain.aggregate.dossier.PolitiezoneId;
import jakarta.validation.constraints.NotNull;

import static be.avidoo.core.common.validation.Validation.validate;

public record PolitiezoneToevoegenCommand(
        @NotNull DossierId dossierId,
        @NotNull PolitiezoneId politieZoneId
) implements Command<Void> {

    public PolitiezoneToevoegenCommand {
        validate(this);
    }
}
