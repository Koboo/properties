package eu.koboo.properties.types;

import eu.koboo.properties.VarProperty;

public class LongProperty extends VarProperty<Long> {

    public LongProperty(String propertyKey, Long defaultValue) {
        super(propertyKey, defaultValue, Long.class, Long::parseLong);
    }
}