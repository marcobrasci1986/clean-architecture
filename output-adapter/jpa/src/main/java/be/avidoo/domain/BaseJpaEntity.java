package be.avidoo.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@MappedSuperclass
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class BaseJpaEntity {

    @Id
    @Column(name = "id")
    private UUID id;

    @Column(name = "datum_creatie", updatable = false)
    private LocalDateTime datumCreatie;

    @Column(name = "datum_laatste_wijziging")
    private LocalDateTime datumLaatsteWijziging;

    protected BaseJpaEntity(UUID id, LocalDateTime datumCreatie, LocalDateTime datumLaatsteWijziging) {
        this.id = id;
        this.datumCreatie = datumCreatie;
        this.datumLaatsteWijziging = datumLaatsteWijziging;
    }
}
