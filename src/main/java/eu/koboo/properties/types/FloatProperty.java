package eu.koboo.properties.types;

import eu.koboo.properties.VarProperty;

public class FloatProperty extends VarProperty<Float> {

    public FloatProperty(String propertyKey, Float defaultValue) {
        super(propertyKey, defaultValue, Float.class, Float::parseFloat);
    }
}