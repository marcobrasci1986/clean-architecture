package be.avidoo.usecase.dossier;

import be.avidoo.core.command.AanmeldenDossierCommand;
import be.avidoo.core.common.command.BaseCommandHandler;
import be.avidoo.core.common.command.CommandMessage;
import be.avidoo.core.common.domainevents.DomainEventBus;
import be.avidoo.domain.aggregate.dossier.Dossier;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Slf4j
@Component
public class DossierAanmeldenCommandHandler extends BaseCommandHandler<Dossier, AanmeldenDossierCommand, UUID> {

    public DossierAanmeldenCommandHandler(DomainEventBus domainEventBus) {
        super(domainEventBus);
    }

    @Override
    public UUID handle(CommandMessage<AanmeldenDossierCommand> commandMessage) {
        AanmeldenDossierCommand command = commandMessage.getCommand();
        System.out.println("Handling Command: " + command + "");
        return UUID.randomUUID();
    }

    @Override
    public Class<AanmeldenDossierCommand> getCommandClass() {
        return AanmeldenDossierCommand.class;
    }
}
