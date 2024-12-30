package be.avidoo.domain.aggregate.dossier;

import be.avidoo.core.common.entity.EntityId;

import java.util.UUID;

public class PolitiezoneId extends EntityId {

    public static PolitiezoneId politiezoneId(UUID value) {
        return new PolitiezoneId(value);
    }

    public PolitiezoneId(UUID value) {
        super(value);
    }
}
