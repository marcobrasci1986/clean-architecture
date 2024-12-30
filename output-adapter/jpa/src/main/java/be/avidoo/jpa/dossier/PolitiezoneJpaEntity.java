package be.avidoo.jpa.dossier;

import be.avidoo.jpa.BaseJpaEntity;
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
@Table(name = "politiezone")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PolitiezoneJpaEntity extends BaseJpaEntity {

    @Column(name = "zone")
    private String zone;

    @Builder
    public PolitiezoneJpaEntity(UUID id, LocalDateTime datumCreatie, LocalDateTime datumLaatsteWijziging, String zone) {
        super(id, datumCreatie, datumLaatsteWijziging);
        this.zone = zone;
    }
}
