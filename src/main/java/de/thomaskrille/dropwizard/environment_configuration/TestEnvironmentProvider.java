package de.thomaskrille.dropwizard.environment_configuration;

import java.util.HashMap;
import java.util.Map;

public class TestEnvironmentProvider implements EnvironmentProvider {
    private Map<String, String> data = new HashMap<>();

    @Override
    public String getenv(final String name) {
        return data.get(name);
    }

    public void put(String name, String value) {
        data.put(name, value);
    }
}
