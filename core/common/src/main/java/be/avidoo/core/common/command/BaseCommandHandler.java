package be.avidoo.core.common.command;

import be.avidoo.core.common.aggregate.AggregateRoot;
import be.avidoo.core.common.domainevents.DomainEventBus;
import be.avidoo.core.common.entity.EntityId;

/**
 * Every command handler should use this as the base class. It provides a method to publish the events registered in the Aggregate Root.
 *
 * @param <A> Aggregate Root
 * @param <C> Command Object
 * @param <T> Return Value
 */
public abstract class BaseCommandHandler<A extends AggregateRoot<? extends EntityId>, C extends Command<T>, T> implements CommandHandler<C, T> {

    protected final DomainEventBus domainEventBus;

    protected BaseCommandHandler(DomainEventBus domainEventBus) {
        this.domainEventBus = domainEventBus;
    }

    protected void handleEvents(A aggregateRoot) {
        aggregateRoot.getEvents().forEach(domainEventBus::send);
        aggregateRoot.clearEvents();
    }
}
