package be.avidoo.core.dossier;

import be.avidoo.core.entity.EntityId;

import java.util.UUID;

public class DossierId extends EntityId {

    public static DossierId dossierId(UUID value) {
        return new DossierId(value);
    }

    public DossierId(UUID value) {
        super(value);
    }
}
