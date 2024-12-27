package be.avidoo.core.common.entity;

import java.util.UUID;

public class EntityId {

    private final UUID value;

    public EntityId(UUID value) {
        this.value = value;
    }

    public UUID getValue() {
        return value;
    }
}

