package eu.koboo.properties.property.types;

import eu.koboo.javalin.jsonsampler.property.VarProperty;

public class StringProperty extends VarProperty<String> {

    public StringProperty(String propertyKey, String defaultValue) {
        super(propertyKey, defaultValue, String.class, string -> string);
    }
}