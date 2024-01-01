package eu.koboo.properties.types.atomic;

import eu.koboo.properties.VarProperty;

import java.util.concurrent.atomic.AtomicLong;

public class AtomicLongProperty extends VarProperty<AtomicLong> {

    public AtomicLongProperty(String propertyKey, AtomicLong defaultValue) {
        super(propertyKey, defaultValue, AtomicLong.class, string -> new AtomicLong(Long.parseLong(string)));
    }
}