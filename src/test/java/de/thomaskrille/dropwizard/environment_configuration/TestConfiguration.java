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

import java.util.List;
import java.util.Map;

import com.google.common.base.Objects;
import io.dropwizard.Configuration;

public class TestConfiguration extends Configuration {
    public List<String> array;
    public Map<String, String> object;
    public SubTestConfiguration subTestConfiguration;

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("array", array)
                .add("object", object)
                .toString();
    }
}
