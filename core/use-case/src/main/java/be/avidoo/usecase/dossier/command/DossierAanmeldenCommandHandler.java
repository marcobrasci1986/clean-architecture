package be.avidoo.usecase.dossier.command;

import be.avidoo.core.command.AanmeldenDossierCommand;
import be.avidoo.core.common.command.BaseCommandHandler;
import be.avidoo.core.common.command.CommandMessage;
import be.avidoo.core.common.domainevents.DomainEventBus;
import be.avidoo.domain.aggregate.dossier.Dossier;
import be.avidoo.domain.aggregate.dossier.DossierId;
import be.avidoo.domain.aggregate.dossier.Dossiernummer;
import be.avidoo.outputport.DossierRepository;
import be.avidoo.usecase.util.RandomNumberGenerator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.UUID;

@Component
@Slf4j
class DossierAanmeldenCommandHandler extends BaseCommandHandler<Dossier, AanmeldenDossierCommand, UUID> {

    private final DossierRepository dossierRepository;

    public DossierAanmeldenCommandHandler(DomainEventBus domainEventBus, DossierRepository dossierRepository) {
        super(domainEventBus);
        this.dossierRepository = dossierRepository;
    }

    @Override
    public UUID handle(CommandMessage<AanmeldenDossierCommand> commandMessage) {
        AanmeldenDossierCommand command = commandMessage.getCommand();


        Dossier dossier = Dossier.create(
                DossierId.dossierId(UUID.randomUUID()),
                Dossiernummer.dossiernummer(RandomNumberGenerator.generateRandom10DigitNumber()),
                LocalDateTime.now()
        );

        DossierId dossierId = dossierRepository.save(dossier);

        this.handleEvents(dossier);
        return dossierId.getValue();
    }

    @Override
    public Class<AanmeldenDossierCommand> getCommandClass() {
        return AanmeldenDossierCommand.class;
    }
}
