package de.thomaskrille.dropwizard.environment_configuration;

import javax.validation.Validator;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.dropwizard.configuration.ConfigurationFactory;
import io.dropwizard.configuration.ConfigurationFactoryFactory;

public class EnvironmentConfigurationFactoryFactory<T> implements ConfigurationFactoryFactory<T> {

    @Override
    public ConfigurationFactory create(final Class klass, final Validator validator, final ObjectMapper objectMapper,
            final String propertyPrefix) {
        return new EnvironmentConfigurationFactory<T>(klass, validator, objectMapper, propertyPrefix,
                new DefaultEnvironmentProvider());
    }
}
