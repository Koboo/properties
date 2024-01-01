package eu.koboo.properties.types.atomic;

import eu.koboo.properties.VarProperty;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerProperty extends VarProperty<AtomicInteger> {

    public AtomicIntegerProperty(String propertyKey, AtomicInteger defaultValue) {
        super(propertyKey, defaultValue, AtomicInteger.class, string -> new AtomicInteger(Integer.parseInt(string)));
    }
}