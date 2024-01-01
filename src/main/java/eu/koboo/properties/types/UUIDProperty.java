package eu.koboo.properties.types;

import eu.koboo.properties.VarProperty;

import java.util.UUID;

public class UUIDProperty extends VarProperty<UUID> {

    public UUIDProperty(String propertyKey, UUID defaultValue) {
        super(propertyKey, defaultValue, UUID.class, UUID::fromString);
    }
}