package be.avidoo.core.common.entity;

import java.time.LocalDateTime;
import java.util.Objects;

public class BaseDomainEntity<T extends EntityId> {

    private final T id;
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

    public T getId() {
        return id;
    }

    protected LocalDateTime getDatumCreatie() {
        return datumCreatie;
    }

    protected LocalDateTime getDatumLaatsteWijziging() {
        return datumLaatsteWijziging;
    }
}
