package eu.koboo.properties.property.types;

import eu.koboo.javalin.jsonsampler.property.VarProperty;

public class FloatProperty extends VarProperty<Float> {
    public FloatProperty(String propertyKey, Float defaultValue) {
        super(propertyKey, defaultValue, Float.class, Float::parseFloat);
    }
}