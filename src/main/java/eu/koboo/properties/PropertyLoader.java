package eu.koboo.properties;

import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.*;

public class PropertyLoader {

    private static final Set<VarProperty<?>> PROPERTY_REGISTRY_SET = new LinkedHashSet<>();
    private static final Properties ROOT = new Properties();
    private static final String DEFAULT_FILE_NAME = "root.properties";

    public static void load(Class<?> propertyHolderClass) {
        for (Field declaredField : propertyHolderClass.getDeclaredFields()) {
            if (!Modifier.isStatic(declaredField.getModifiers())) {
                continue;
            }
            if (!Modifier.isPublic(declaredField.getModifiers())) {
                continue;
            }
            if (!Modifier.isFinal(declaredField.getModifiers())) {
                continue;
            }
            Class<?> fieldType = declaredField.getType();
            if (!VarProperty.class.isAssignableFrom(fieldType)) {
                continue;
            }
            try {
                VarProperty<?> propertyInstance = (VarProperty<?>) declaredField.get(null);
                PROPERTY_REGISTRY_SET.add(propertyInstance);
            } catch (Exception e) {
                throw new RuntimeException("Couldn't read field=" + declaredField.getName() + " of class=" + propertyHolderClass.getName());
            }
        }

        for (VarProperty<?> property : PROPERTY_REGISTRY_SET) {
            ROOT.setProperty(property.getPropertyKey(), String.valueOf(property.getDefaultValue()));
        }
    }

    public static <T> T get(VarProperty<T> property) {
        String value = ROOT.getProperty(property.getPropertyKey());
        return property.getMapper().apply(value);
    }

    public static void appendResource() {
        appendResource(DEFAULT_FILE_NAME);
    }

    public static void appendResource(String resourceFile) {
        InputStream stream = PropertyLoader.class.getClassLoader().getResourceAsStream(resourceFile);
        if (stream == null) {
            return;
        }
        appendStream(stream);
    }

    public static void appendFile() {
        appendFile(DEFAULT_FILE_NAME);
    }

    public static void appendFile(String filePath) {
        try {
            File propertyFile = new File(filePath);
            if (!propertyFile.exists()) {
                return;
            }
            FileInputStream stream = new FileInputStream(propertyFile);
            appendStream(stream);
        } catch (IOException e) {
            throw new RuntimeException("Couldn't read file storage properties: ", e);
        }
    }

    private static void appendStream(InputStream stream) {
        Properties streamProperties = new Properties();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(stream))) {
            streamProperties.load(reader);
        } catch (IOException e) {
            throw new RuntimeException("Couldn't load properties from stream \"" + stream.getClass().getName() + "\":", e);
        }
        append(streamProperties::getProperty);
    }

    public static void appendArguments(String[] arguments) {
        Map<String, String> parsedArgumentMap = new LinkedHashMap<>();
        for (String argument : arguments) {
            if (argument.startsWith("-")) {
                argument = argument.replace("-", "");
            }

            String[] split = argument.split("=");
            String key = split[0];

            String value = null;
            if (split.length == 1) {
                value = "true";
            }
            if (split.length == 2) {
                value = split[1];
            }

            if (value == null) {
                continue;
            }
            parsedArgumentMap.put(key, value);
        }
        append(parsedArgumentMap::get);
    }

    public static void appendEnvironmentVariables() {
        append(System::getenv);
    }

    public static void appendSystemProperties() {
        append(System::getProperty);
    }

    public static void append(ValueResolver resolver) {
        for (VarProperty<?> property : PROPERTY_REGISTRY_SET) {
            String key = property.getPropertyKey();

            // Resolve the value and check if it is null.
            String value = resolver.resolveValue(key);
            if(value == null || value.isEmpty()) {
                continue;
            }

            // Append the key + value into the boot properties.
            ROOT.put(key, value);
        }
    }

    @FunctionalInterface
    public interface ValueResolver {
        String resolveValue(String key);
    }
}
