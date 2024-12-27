package be.avidoo.domain.aggregate.dossier.events;


import be.avidoo.core.common.domainevents.model.CreatedDomainEvent;

import java.time.LocalDateTime;
import java.util.UUID;

public class DossierCreatedDomainEvent extends CreatedDomainEvent {

    public DossierCreatedDomainEvent(UUID id, LocalDateTime tijdstip) {
        super(id, tijdstip);
    }
}