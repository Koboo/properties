package eu.koboo.properties.types;

import eu.koboo.properties.VarProperty;

public class BooleanProperty extends VarProperty<Boolean> {

    public BooleanProperty(String propertyKey, Boolean defaultValue) {
        super(propertyKey, defaultValue, Boolean.class, Boolean::parseBoolean);
    }
}