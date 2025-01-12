package be.avidoo.jpa.dossier;

import be.avidoo.jpa.AggregateRootJpaEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "dossier")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class DossierJpaEntity extends AggregateRootJpaEntity {

    @Column(name = "status")
    private String status;

    @Column(name = "dossiernummer")
    private String dossiernummer;


    @Builder
    public DossierJpaEntity(UUID id, LocalDateTime datumCreatie, LocalDateTime datumLaatsteWijziging, String status, String dossiernummer) {
        super(id, datumCreatie, datumLaatsteWijziging);
        this.status = status;
        this.dossiernummer = dossiernummer;
    }

}
