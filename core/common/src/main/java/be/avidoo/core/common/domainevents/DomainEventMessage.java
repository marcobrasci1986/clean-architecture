package be.avidoo.core.common.domainevents;

import be.avidoo.core.common.domainevents.model.DomainEvent;

import java.time.LocalDateTime;

public class DomainEventMessage {

    private final DomainEvent domainEvent;
    private final LocalDateTime tijdstip;

    public DomainEventMessage(DomainEvent domainEvent, LocalDateTime tijdstip
    ) {
        this.domainEvent = domainEvent;
        this.tijdstip = tijdstip == null ? LocalDateTime.now() : tijdstip;
    }

    public static DomainEventMessage domainEventMessage(DomainEvent domainEvent) {
        return DomainEventMessage.builder()
                .withDomainEvent(domainEvent)
                .withTijdstip(domainEvent.getTijdstip())
                .build();
    }

    public static DomainEventMessageBuilder builder() {
        return new DomainEventMessage.DomainEventMessageBuilder();
    }

    public DomainEvent getDomainEvent() {
        return domainEvent;
    }

    public LocalDateTime getTijdstip() {
        return tijdstip;
    }

    public static final class DomainEventMessageBuilder {
        private DomainEvent domainEvent;
        private LocalDateTime tijdstip;

        private DomainEventMessageBuilder() {
        }

        public DomainEventMessageBuilder withDomainEvent(DomainEvent domainEvent) {
            this.domainEvent = domainEvent;
            return this;
        }

        public DomainEventMessageBuilder withTijdstip(LocalDateTime tijdstip) {
            this.tijdstip = tijdstip;
            return this;
        }

        public DomainEventMessage build() {
            return new DomainEventMessage(domainEvent, tijdstip);
        }
    }
}
