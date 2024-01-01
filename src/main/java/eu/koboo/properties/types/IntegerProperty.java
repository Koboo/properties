package eu.koboo.properties.types;

import eu.koboo.properties.VarProperty;

public class IntegerProperty extends VarProperty<Integer> {

    public IntegerProperty(String propertyKey, Integer defaultValue) {
        super(propertyKey, defaultValue, Integer.class, Integer::parseInt);
    }
}