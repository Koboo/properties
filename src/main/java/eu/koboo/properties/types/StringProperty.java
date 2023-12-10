package eu.koboo.properties.types;

import eu.koboo.properties.VarProperty;

public class StringProperty extends VarProperty<String> {

    public StringProperty(String propertyKey, String defaultValue) {
        super(propertyKey, defaultValue, String.class, string -> string);
    }
}