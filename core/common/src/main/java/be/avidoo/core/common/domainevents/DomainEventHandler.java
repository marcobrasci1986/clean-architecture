package be.avidoo.core.common.domainevents;

import be.avidoo.core.common.domainevents.model.DomainEvent;

public interface DomainEventHandler<E extends DomainEvent> {
    void handle(E domainEvent);

    Class<E> getDomainEventClass();

}
