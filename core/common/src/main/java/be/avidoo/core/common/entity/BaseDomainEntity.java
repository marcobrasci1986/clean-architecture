package be.avidoo.core.common.entity;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

public class BaseDomainEntity<T extends EntityId> {

    protected final T id;
    private final LocalDateTime datumCreatie;
    private LocalDateTime datumLaatsteWijziging;

    public BaseDomainEntity(T id, LocalDateTime datumCreatie, LocalDateTime datumLaatsteWijziging) {
        this.id = id;
        this.datumCreatie = datumCreatie;
        this.datumLaatsteWijziging = datumLaatsteWijziging;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseDomainEntity<?> that = (BaseDomainEntity<?>) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    protected void updateDatumLaatsteWijziging(LocalDateTime datumWijziging) {
        this.datumLaatsteWijziging = datumWijziging;
    }

    public UUID getId() {
        return id.getValue();
    }

    public LocalDateTime getDatumCreatie() {
        return datumCreatie;
    }

    public LocalDateTime getDatumLaatsteWijziging() {
        return datumLaatsteWijziging;
    }
}
