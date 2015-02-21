Dropwizard Environment Config
=============================

Dropwizard ConfigurationFactory that allows specifying environment variables as
values in YAML.

Setup
-----

First add the dependency to your pom:

```xml
<dependency>
    <groupId>de.thomaskrille.dropwizard</groupId>
    <artifactId>dropwizard-environment-configuration</artifactId>
    <version>1.1</version>
</dependency>
```

To setup, simply set the `EnvironmentConfigurationFactoryFactory` as factory
for configuration factories on the `Bootstrap` object:

```java
@Override
public void initialize(final Bootstrap<Config> bootstrap) {
    ...
    bootstrap.setConfigurationFactoryFactory(new EnvironmentConfigurationFactoryFactory());
    ...
}
```

Using `EnvironmentConfigurationFactory` also honors configuration overrides
via system properties as usual. Configuration overrides take precedence over
values set via environment variables.

Usage
-----

Environment variables can be specified in config.yaml by using the following
"magic value":

```
$env:ENVIRONMENT_VARIABLE[:DEFAULT_VALUE]
```

Example:

```yaml
array:
  - 1
  - $env:ARRAY_1
  - $env:ARRAY_2:default
object:
  a: 1
  b: $env:OBJECT_B
  c: $env:OBJECT_C:default
```

Replacements are not supported when using the short notation, i.e. the
following will not work:

```yaml
 array: [ 1, $env:ARRAY_1, $env:ARRAY_2:default]
 object: {a: 1, b: $env:OBJECT_B, c: $env:OBJECT_C:default}
```

Copyright Notice
----------------

This project is licensed under the Apache License, Version 2.0, January 2004,
and uses software from the following 3rd parties:

- Coda Hale
- Yammer, Inc.

See LICENSE-3RD-PARTY and NOTICE-3RD-PARTY for the individual 3rd parties.
