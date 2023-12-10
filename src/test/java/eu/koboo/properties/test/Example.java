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
    }
}
