package be.avidoo.domain.aggregate.dossier;

import be.avidoo.core.common.domainevents.model.CreatedDomainEvent;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

class DossierTest {

    @Test
    void createdDomainEvent() {
        Dossier dossier = Dossier.create(
                DossierId.dossierId(UUID.randomUUID()),
                Dossiernummer.dossiernummer("ABC-100"),
                LocalDateTime.now()
        );

        assertThat(dossier.getStatus()).isEqualTo(DossierStatus.DOSSIEROPBOUW);

        // verify domain event
        assertThat(dossier.getEvents()).hasSize(1);
        CreatedDomainEvent createdEvent = (CreatedDomainEvent) dossier.getEvents().get(0);
        assertThat(createdEvent.getId()).isEqualTo(dossier.getDomainEventId());
    }
}