package be.avidoo.domain;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class AggregateRootJpaEntity extends BaseJpaEntity {

    protected AggregateRootJpaEntity(UUID id, LocalDateTime datumCreatie, LocalDateTime datumLaatsteWijziging) {
        super(id, datumCreatie, datumLaatsteWijziging);
    }
}