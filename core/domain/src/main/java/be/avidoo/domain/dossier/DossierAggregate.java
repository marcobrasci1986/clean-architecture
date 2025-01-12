package be.avidoo.domain.dossier;

import be.avidoo.core.common.aggregate.AggregateRoot;
import be.avidoo.core.common.entity.DomainEventIdentifier;
import be.avidoo.domain.annotations.Aggregate;
import be.avidoo.domain.annotations.AggregateBuilder;
import be.avidoo.domain.be.avidoo.events.dossier.DossierCreatedDomainEvent;

import java.time.LocalDateTime;
import java.util.UUID;

@Aggregate
public class DossierAggregate extends AggregateRoot<DossierId> implements DomainEventIdentifier {

    private final Dossiernummer dossiernummer;
    private final DossierStatus status;

    public DossierAggregate(
            DossierId id,
            LocalDateTime datumCreatie,
            LocalDateTime datumLaatsteWijziging,
            Dossiernummer dossiernummer,
            DossierStatus status
    ) {
        super(id, datumCreatie, datumLaatsteWijziging);
        this.dossiernummer = dossiernummer;
        this.status = status;
    }

    public static DossierAggregate create(
            UUID dossierId,
            String dossiernummer,
            LocalDateTime datumCreatie
    ) {
        DossierAggregate dossier = new DossierAggregate(
                DossierId.dossierId(dossierId),
                datumCreatie,
                datumCreatie,
                Dossiernummer.dossiernummer(dossiernummer),
                DossierStatus.DOSSIEROPBOUW
        );

        dossier.registerEvent(new DossierCreatedDomainEvent(dossierId, datumCreatie));
        return dossier;
    }

    @Override
    public UUID getDomainEventId() {
        return this.getId();
    }

    public String getDossiernummer() {
        return dossiernummer.value();
    }

    public String getStatus() {
        return status.name();
    }

    public static DossierAggregateBuilder builder() {
        return new DossierAggregateBuilder();
    }

    @AggregateBuilder
    public static final class DossierAggregateBuilder {
        private Dossiernummer dossiernummer;
        private DossierStatus status;
        private DossierId id;
        private LocalDateTime datumCreatie;
        private LocalDateTime datumLaatsteWijziging;

        private DossierAggregateBuilder() {
        }


        public DossierAggregateBuilder withDossiernummer(String dossiernummer) {
            this.dossiernummer = Dossiernummer.dossiernummer(dossiernummer);
            return this;
        }

        public DossierAggregateBuilder withStatus(String status) {
            this.status = DossierStatus.valueOf(status);
            return this;
        }

        public DossierAggregateBuilder withId(UUID id) {
            this.id = DossierId.dossierId(id);
            return this;
        }

        public DossierAggregateBuilder withDatumCreatie(LocalDateTime datumCreatie) {
            this.datumCreatie = datumCreatie;
            return this;
        }

        public DossierAggregateBuilder withDatumLaatsteWijziging(LocalDateTime datumLaatsteWijziging) {
            this.datumLaatsteWijziging = datumLaatsteWijziging;
            return this;
        }

        public DossierAggregate build() {
            return new DossierAggregate(this.id, datumCreatie, datumLaatsteWijziging, dossiernummer, status);
        }
    }
}

