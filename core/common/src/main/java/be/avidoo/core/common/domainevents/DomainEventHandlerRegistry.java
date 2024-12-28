package be.avidoo.core.common.domainevents;

import be.avidoo.core.common.domainevents.model.DomainEvent;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.Collections.emptyList;

@Component
public class DomainEventHandlerRegistry {

    @SafeVarargs
    public static DomainEventHandlerRegistry of(DomainEventHandler<? extends DomainEvent>... domainEventHandlers) {
        return new DomainEventHandlerRegistry(List.of(domainEventHandlers));
    }

    private final Map<Class<? extends DomainEvent>, List<DomainEventHandler<? extends DomainEvent>>> domainEventHandlersByDomainEventClass;

    private DomainEventHandlerRegistry(List<DomainEventHandler<? extends DomainEvent>> domainEventHandlers) {
        domainEventHandlersByDomainEventClass = domainEventHandlers.stream()
                .collect(Collectors.groupingBy(DomainEventHandler::getDomainEventClass));
    }

    @SuppressWarnings("unchecked")
    public List<DomainEventHandler<? extends DomainEvent>> findByEvent(DomainEvent domainEvent) {
        return domainEventHandlersByDomainEventClass.entrySet().stream()
                .filter(entry -> entry.getKey().isAssignableFrom(domainEvent.getClass()))
                .map(Map.Entry::getValue)
                .findFirst()
                .orElse(emptyList());
    }
}
