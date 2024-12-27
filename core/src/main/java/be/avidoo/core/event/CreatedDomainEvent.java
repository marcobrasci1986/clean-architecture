package be.avidoo.core.event;

import java.time.LocalDateTime;
import java.util.UUID;

public class CreatedDomainEvent extends DomainEvent {
    private final UUID id;

    protected CreatedDomainEvent(UUID id, LocalDateTime tijdstip) {
        super(tijdstip);
        this.id = id;
    }

    public UUID getId() {
        return id;
    }
}
