package eu.koboo.properties.types;

import eu.koboo.properties.VarProperty;

public class DoubleProperty extends VarProperty<Double> {
    public DoubleProperty(String propertyKey, Double defaultValue) {
        super(propertyKey, defaultValue, Double.class, Double::parseDouble);
    }
}