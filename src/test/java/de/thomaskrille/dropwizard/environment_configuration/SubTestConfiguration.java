package de.thomaskrille.dropwizard.environment_configuration;

import java.util.List;
import java.util.Map;

import com.google.common.base.Objects;

public class SubTestConfiguration {
    public List<String> array;
    public Map<String, String> object;

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("array", array)
                .add("object", object)
                .toString();
    }
}
