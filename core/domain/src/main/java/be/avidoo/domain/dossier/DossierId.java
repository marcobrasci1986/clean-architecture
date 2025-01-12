package be.avidoo.domain.dossier;

import be.avidoo.core.common.entity.EntityId;

import java.util.UUID;

class DossierId extends EntityId {

    static DossierId dossierId(UUID value) {
        return new DossierId(value);
    }

    DossierId(UUID value) {
        super(value);
    }
}
