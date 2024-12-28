package be.avidoo.core.common.domainevents;

import be.avidoo.core.common.domainevents.model.DomainEvent;

public class DefaultDomainEventBus implements DomainEventBus {

    private final DomainEventHandlerRegistry domainEventHandlerRegistry;

    public DefaultDomainEventBus(DomainEventHandlerRegistry domainEventHandlerRegistry) {
        this.domainEventHandlerRegistry = domainEventHandlerRegistry;
    }

    @Override
    public void send(DomainEventMessage domainEventMessage) {
        DomainEvent domainEvent = domainEventMessage.getDomainEvent();

        domainEventHandlerRegistry.findByEvent(domainEvent)
                .stream()
                .map(handler -> (DomainEventHandler<DomainEvent>) handler)
                .forEach(handler -> handler.handle(domainEvent));
    }
}
