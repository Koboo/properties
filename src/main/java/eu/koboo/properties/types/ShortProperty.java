package eu.koboo.properties.types;

import eu.koboo.properties.VarProperty;

public class ShortProperty extends VarProperty<Short> {

    public ShortProperty(String propertyKey, Short defaultValue) {
        super(propertyKey, defaultValue, Short.class, Short::parseShort);
    }
}