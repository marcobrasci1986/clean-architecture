package be.avidoo.core.event;

import java.time.LocalDateTime;

public abstract class DomainEvent {

    private final LocalDateTime tijdstip;

    protected DomainEvent(LocalDateTime tijdstip) {
        this.tijdstip = tijdstip;
    }

    protected LocalDateTime getTijdstip() {
        return tijdstip;
    }
}
