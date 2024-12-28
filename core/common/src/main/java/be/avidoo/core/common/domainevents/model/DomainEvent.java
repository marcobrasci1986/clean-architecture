package be.avidoo.core.common.domainevents.model;

import java.time.LocalDateTime;

public abstract class DomainEvent {

    private final LocalDateTime tijdstip;

    protected DomainEvent(LocalDateTime tijdstip) {
        this.tijdstip = tijdstip;
    }

    public LocalDateTime getTijdstip() {
        return tijdstip;
    }
}