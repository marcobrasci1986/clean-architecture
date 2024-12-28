package be.avidoo.core.common.domainevents;


import be.avidoo.core.common.domainevents.model.DomainEvent;

import static be.avidoo.core.common.domainevents.DomainEventMessage.domainEventMessage;

public interface DomainEventBus {

    default void send(DomainEvent domainEvent) {
        send(domainEventMessage(domainEvent));
    }

    void send(DomainEventMessage domainEventMessage);

}
