package be.avidoo.usecase.dossier.eventhandlers;

import be.avidoo.core.common.domainevents.DomainEventHandler;
import be.avidoo.domain.aggregate.dossier.events.DossierCreatedDomainEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class DossierCreatedEventHandler implements DomainEventHandler<DossierCreatedDomainEvent> {

    @Override
    public void handle(DossierCreatedDomainEvent domainEvent) {
        log.info(domainEvent.toString());
    }

    @Override
    public Class<DossierCreatedDomainEvent> getDomainEventClass() {
        return DossierCreatedDomainEvent.class;
    }
}
