Dropwizard Environment Config
=============================

Dropwizard ConfigurationFactory that allows specifying environment variables as values in YAML.

Setup
-----

First add the dependency to your pom:

```xml
<dependency>
    <groupId>de.thomaskrille.dropwizard</groupId>
    <artifactId>dropwizard-environment-configuration</artifactId>
    <version>1.0-SNAPSHOT</version>
</dependency>
```

**NOTE:** Dropwizard Environment Config is not yet available on the Maven Central, but will be soon!

To setup, simply set the <code>EnvironmentConfigurationFactoryFactory</code> as factory for configuration factories on
the <code>Bootstrap</code> object:

```java
@Override
public void initialize(final Bootstrap<Config> bootstrap) {
    ...
    bootstrap.setConfigurationFactoryFactory(new EnvironmentConfigurationFactoryFactory());
    ...
}
```

Using <code>EnvironmentConfigurationFactory</code> also honors configuration overrides via system properties as usual.
Configuration overrides take precedence over values set via environment variables.

Usage
-----

Environment variables can be specified in config.yaml by using the following "magic value":

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

Replacements are not supported when using the short notation, i.e. the following will not work:

```yaml
 array: [ 1, $env:ARRAY_1, $env:ARRAY_2:default]
 object: {a: 1, b: $env:OBJECT_B, c: $env:OBJECT_C:default}
```
