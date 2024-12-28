package be.avidoo.domain.aggregate.dossier;

import be.avidoo.core.common.aggregate.AggregateRoot;
import be.avidoo.core.common.entity.DomainEventIdentifier;
import be.avidoo.domain.aggregate.dossier.events.DossierCreatedDomainEvent;

import java.time.LocalDateTime;
import java.util.UUID;

public class Dossier extends AggregateRoot<DossierId> implements DomainEventIdentifier {

    private final Dossiernummer dossiernummer;
    private final DossierStatus status;

    public Dossier(DossierId id, LocalDateTime datumCreatie, LocalDateTime datumLaatsteWijziging, Dossiernummer dossiernummer, DossierStatus status) {
        super(id, datumCreatie, datumLaatsteWijziging);
        this.dossiernummer = dossiernummer;
        this.status = status;
    }

    public static Dossier create(
            DossierId dossierId,
            Dossiernummer dossiernummer,
            LocalDateTime datumCreatie
    ) {
        Dossier dossier = new Dossier(
                dossierId, datumCreatie, datumCreatie, dossiernummer, DossierStatus.DOSSIEROPBOUW
        );

        dossier.registerEvent(new DossierCreatedDomainEvent(dossierId.getValue(), datumCreatie));
        return dossier;
    }

    @Override
    public UUID getDomainEventId() {
        return this.getId().getValue();
    }

    public Dossiernummer getDossiernummer() {
        return dossiernummer;
    }

    public DossierStatus getStatus() {
        return status;
    }


    public static Dossier.DossierBuilder builder() {
        return new Dossier.DossierBuilder();
    }

    public static final class DossierBuilder {
        private Dossiernummer dossiernummer;
        private DossierStatus status;
        private UUID id;
        private LocalDateTime datumCreatie;
        private LocalDateTime datumLaatsteWijziging;

        private DossierBuilder() {
        }


        public DossierBuilder withDossiernummer(Dossiernummer dossiernummer) {
            this.dossiernummer = dossiernummer;
            return this;
        }

        public DossierBuilder withStatus(DossierStatus status) {
            this.status = status;
            return this;
        }

        public DossierBuilder withId(UUID id) {
            this.id = id;
            return this;
        }

        public DossierBuilder withDatumCreatie(LocalDateTime datumCreatie) {
            this.datumCreatie = datumCreatie;
            return this;
        }

        public DossierBuilder withDatumLaatsteWijziging(LocalDateTime datumLaatsteWijziging) {
            this.datumLaatsteWijziging = datumLaatsteWijziging;
            return this;
        }

        public Dossier build() {
            return new Dossier(DossierId.dossierId(this.id), datumCreatie, datumLaatsteWijziging, dossiernummer, status);
        }
    }
}

