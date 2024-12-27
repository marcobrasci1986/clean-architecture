package be.avidoo.core.dossier.events;

import be.avidoo.core.event.CreatedDomainEvent;

import java.time.LocalDateTime;
import java.util.UUID;

public class DossierCreatedDomainEvent extends CreatedDomainEvent {

    public DossierCreatedDomainEvent(UUID id, LocalDateTime tijdstip) {
        super(id, tijdstip);
    }
}
