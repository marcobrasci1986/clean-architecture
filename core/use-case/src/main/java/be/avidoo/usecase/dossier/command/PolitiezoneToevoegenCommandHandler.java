package be.avidoo.usecase.dossier.command;

import be.avidoo.core.command.PolitiezoneToevoegenCommand;
import be.avidoo.core.common.command.BaseCommandHandler;
import be.avidoo.core.common.command.CommandMessage;
import be.avidoo.core.common.domainevents.DomainEventBus;
import be.avidoo.domain.aggregate.dossier.Dossier;
import be.avidoo.domain.aggregate.dossier.Politiezone;
import be.avidoo.outputport.DossierRepository;
import be.avidoo.outputport.PolitiezoneRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
class PolitiezoneToevoegenCommandHandler extends BaseCommandHandler<Dossier, PolitiezoneToevoegenCommand, Void> {

    private final DossierRepository dossierRepository;
    private final PolitiezoneRepository politiezoneRepository;

    public PolitiezoneToevoegenCommandHandler(DomainEventBus domainEventBus, DossierRepository dossierRepository, PolitiezoneRepository politiezoneRepository) {
        super(domainEventBus);
        this.dossierRepository = dossierRepository;
        this.politiezoneRepository = politiezoneRepository;
    }

    @Override
    public Void handle(CommandMessage<PolitiezoneToevoegenCommand> commandMessage) {
        PolitiezoneToevoegenCommand command = commandMessage.getCommand();

        Dossier dossier = dossierRepository.findByDossierId(command.dossierId()).orElseThrow();
        Politiezone politiezone = politiezoneRepository.findByPolitiezoneId(command.politieZoneId()).orElseThrow();

        dossierRepository.updatePolitiezone(dossier, politiezone.getPolitiezoneId());

        this.handleEvents(dossier);
        return null;
    }

    @Override
    public Class<PolitiezoneToevoegenCommand> getCommandClass() {
        return PolitiezoneToevoegenCommand.class;
    }
}
