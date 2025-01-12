package be.avidoo.domain.dossier;

import be.avidoo.core.common.domainevents.model.CreatedDomainEvent;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

class DossierAggregateTest {

    @Test
    void createdDomainEvent() {
        DossierAggregate dossier = DossierAggregate.create(
                UUID.randomUUID(),
                "ABC-100",
                LocalDateTime.now()
        );

        assertThat(dossier.getStatus()).isEqualTo(DossierStatus.DOSSIEROPBOUW.toString());

        // verify domain event
        assertThat(dossier.getEvents()).hasSize(1);
        CreatedDomainEvent createdEvent = (CreatedDomainEvent) dossier.getEvents().get(0);
        assertThat(createdEvent.getId()).isEqualTo(dossier.getDomainEventId());
    }
}