/*
 * Copyright 2014-2015 Thomas Krille
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package de.thomaskrille.dropwizard.environment_configuration;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import javax.validation.Validation;

import org.hibernate.validator.HibernateValidator;
import org.junit.Test;

import io.dropwizard.configuration.ConfigurationException;
import io.dropwizard.jackson.Jackson;
import io.dropwizard.validation.valuehandling.OptionalValidatedValueUnwrapper;

public class EnvironmentConfigurationFactorySubObjectTest {
    TestEnvironmentProvider environmentProvider = new TestEnvironmentProvider();
    EnvironmentConfigurationFactory<TestConfiguration> environmentConfigurationFactory = new EnvironmentConfigurationFactory<>(
            TestConfiguration.class,
            Validation.byProvider(HibernateValidator.class)
                    .configure()
                    .addValidatedValueHandler(new OptionalValidatedValueUnwrapper())
                    .buildValidatorFactory().getValidator(),
            Jackson.newObjectMapper(),
            "dw",
            environmentProvider);

    @Test
    public void can_set_variable_with_default_in_array() throws IOException, ConfigurationException {
        environmentProvider.put("SUB_ARRAY_2", "5");

        TestConfiguration testConfiguration = environmentConfigurationFactory.build(new File(
                "src/test/resources/config.yaml"));

        assertThat(testConfiguration.subTestConfiguration.array.get(2), is(equalTo("5")));
    }

    @Test
    public void can_set_variable_with_default_in_object() throws IOException, ConfigurationException {
        environmentProvider.put("SUB_OBJECT_C", "5");

        TestConfiguration testConfiguration = environmentConfigurationFactory.build(new File(
                "src/test/resources/config.yaml"));

        assertThat(testConfiguration.subTestConfiguration.object.get("c"), is(equalTo("5")));
    }

    @Test
    public void can_set_variable_without_default_in_array() throws IOException, ConfigurationException {
        environmentProvider.put("SUB_ARRAY_1", "5");

        TestConfiguration testConfiguration = environmentConfigurationFactory.build(new File(
                "src/test/resources/config.yaml"));

        assertThat(testConfiguration.subTestConfiguration.array.get(1), is(equalTo("5")));
    }

    @Test
    public void can_set_variable_without_default_in_object() throws IOException, ConfigurationException {
        environmentProvider.put("SUB_OBJECT_B", "5");

        TestConfiguration testConfiguration = environmentConfigurationFactory.build(new File(
                "src/test/resources/config.yaml"));

        assertThat(testConfiguration.subTestConfiguration.object.get("b"), is(equalTo("5")));
    }

    @Test
    public void uses_default_value_in_array() throws IOException, ConfigurationException {
        TestConfiguration testConfiguration = environmentConfigurationFactory.build(new File(
                "src/test/resources/config.yaml"));

        assertThat(testConfiguration.subTestConfiguration.array.get(2), is(equalTo("default")));
    }

    @Test
    public void uses_default_value_in_object() throws IOException, ConfigurationException {
        TestConfiguration testConfiguration = environmentConfigurationFactory.build(new File(
                "src/test/resources/config.yaml"));

        assertThat(testConfiguration.subTestConfiguration.object.get("c"), is(equalTo("default")));
    }
}
