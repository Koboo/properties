package eu.koboo.properties.test;

import eu.koboo.properties.types.*;

public class MyProperties {

    public static final BooleanProperty BOOLEAN = new BooleanProperty("key.boolean", true);
    public static final DoubleProperty DOUBLE = new DoubleProperty("key.double", 1.0D);
    public static final FloatProperty FLOAT = new FloatProperty("key.float", 0.1f);
    public static final IntProperty INT = new IntProperty("key.int", 1);
    public static final LongProperty LONG = new LongProperty("key.long", 1L);
    public static final ShortProperty SHORT = new ShortProperty("key.short", (short) 1);
    public static final StringProperty STRING = new StringProperty("key.string", "default");
}
