package be.avidoo.jpa.dossier;

import be.avidoo.domain.aggregate.dossier.DossierStatus;
import be.avidoo.jpa.AggregateRootJpaEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

import static jakarta.persistence.EnumType.STRING;

@Entity
@Table(name = "dossier")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class DossierJpaEntity extends AggregateRootJpaEntity {

    @Column(name = "status")
    @Enumerated(STRING)
    private DossierStatus status;

    @Column(name = "dossiernummer")
    private String dossiernummer;

    @Builder
    public DossierJpaEntity(UUID id, LocalDateTime datumCreatie, LocalDateTime datumLaatsteWijziging, DossierStatus status, String dossiernummer) {
        super(id, datumCreatie, datumLaatsteWijziging);
        this.status = status;
        this.dossiernummer = dossiernummer;
    }
}
