package be.avidoo.core.dossier;

import be.avidoo.core.aggregate.AggregateRoot;
import be.avidoo.core.dossier.events.DossierCreatedDomainEvent;
import be.avidoo.core.entity.DomainEventIdentifier;

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
}

