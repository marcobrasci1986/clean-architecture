package be.avidoo.core.common.aggregate;


import be.avidoo.core.common.domainevents.model.DomainEvent;
import be.avidoo.core.common.entity.BaseDomainEntity;
import be.avidoo.core.common.entity.EntityId;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AggregateRoot<T extends EntityId> extends BaseDomainEntity<T> {

    private final List<DomainEvent> events;

    public AggregateRoot(T id, LocalDateTime datumCreatie, LocalDateTime datumLaatsteWijziging) {
        super(id, datumCreatie, datumLaatsteWijziging);
        this.events = new ArrayList<>();
    }

    public void clearEvents() {
        events.clear();
    }

    public List<DomainEvent> getEvents() {
        return Collections.unmodifiableList(events); // prevent mutating
    }

    protected void registerEvent(DomainEvent domainEvent) {
        events.add(domainEvent);
    }
}
