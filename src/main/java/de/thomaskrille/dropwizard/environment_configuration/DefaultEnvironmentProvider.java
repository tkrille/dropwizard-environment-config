package de.thomaskrille.dropwizard.environment_configuration;

public class DefaultEnvironmentProvider implements EnvironmentProvider {
    @Override
    public String getenv(final String name) {
        return System.getenv(name);
    }
}
