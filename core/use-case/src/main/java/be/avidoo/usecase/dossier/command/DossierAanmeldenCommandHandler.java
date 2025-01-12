package be.avidoo.usecase.dossier.command;

import be.avidoo.core.command.AanmeldenDossierCommand;
import be.avidoo.core.common.command.BaseCommandHandler;
import be.avidoo.core.common.command.CommandMessage;
import be.avidoo.core.common.domainevents.DomainEventBus;
import be.avidoo.domain.dossier.DossierAggregate;
import be.avidoo.domain.dossier.DossierRepository;
import be.avidoo.usecase.util.RandomNumberGenerator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.UUID;

@Component
@Slf4j
class DossierAanmeldenCommandHandler extends BaseCommandHandler<DossierAggregate, AanmeldenDossierCommand, UUID> {

    private final DossierRepository dossierRepository;

    public DossierAanmeldenCommandHandler(DomainEventBus domainEventBus, DossierRepository dossierRepository) {
        super(domainEventBus);
        this.dossierRepository = dossierRepository;
    }

    @Override
    public UUID handle(CommandMessage<AanmeldenDossierCommand> commandMessage) {
        AanmeldenDossierCommand command = commandMessage.getCommand();


        DossierAggregate dossier = DossierAggregate.create(
                UUID.randomUUID(),
                RandomNumberGenerator.generateRandom10DigitNumber(),
                LocalDateTime.now()
        );

        UUID dossierId = dossierRepository.save(dossier);

        this.handleEvents(dossier);
        return dossierId;
    }

    @Override
    public Class<AanmeldenDossierCommand> getCommandClass() {
        return AanmeldenDossierCommand.class;
    }
}
