package eu.koboo.properties.types;

import eu.koboo.properties.VarProperty;

public class IntProperty extends VarProperty<Integer> {
    public IntProperty(String propertyKey, Integer defaultValue) {
        super(propertyKey, defaultValue, Integer.class, Integer::parseInt);
    }
}