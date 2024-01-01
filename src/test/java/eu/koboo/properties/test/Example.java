package eu.koboo.properties.test;

import eu.koboo.properties.PropertyLoader;

public class Example {

    public static void main(String[] args) {
        PropertyLoader.load(MyProperties.class);

        PropertyLoader.appendResource();
        PropertyLoader.appendFile();
        PropertyLoader.appendSystemProperties();
        PropertyLoader.appendEnvironmentVariables();
        PropertyLoader.appendArguments(args);

        boolean b = PropertyLoader.get(MyProperties.BOOLEAN);
        System.out.println(b);
        double d = PropertyLoader.get(MyProperties.DOUBLE);
        float f = PropertyLoader.get(MyProperties.FLOAT);
        int i = PropertyLoader.get(MyProperties.INT);
        long l = PropertyLoader.get(MyProperties.LONG);
        short s = PropertyLoader.get(MyProperties.SHORT);
        String string = PropertyLoader.get(MyProperties.STRING);
    }
}
