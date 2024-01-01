package eu.koboo.properties.types.atomic;

import eu.koboo.properties.VarProperty;

import java.util.concurrent.atomic.AtomicBoolean;

public class AtomicBooleanProperty extends VarProperty<AtomicBoolean> {

    public AtomicBooleanProperty(String propertyKey, AtomicBoolean defaultValue) {
        super(propertyKey, defaultValue, AtomicBoolean.class, string -> new AtomicBoolean(Boolean.parseBoolean(string)));
    }
}