# Changelog

## 1.1 - 2015-02-21

### Fixes

- add dependency to commons-lang 2.6 and shade it (4f9f705)

### Changes

- set Dropwizard dependency to scope provided (d08103f)

    this should improve compatibility with multiple Dropwizard versions. see
    also https://github.com/tkrille/dropwizard-environment-config/pull/1. this
    also breaks compatibility for users who depend on the transitive dependency
    of Dropwizard - which nobody has done, hopefully.

- move TestEnvironmentProvider to test sources (7df6783)

    this should not be a big deal, since nobody has ever used this class in
    their projects, hopefully.

## 1.0 - 2014-07-21

**Initial Version**

### Features

- environment variables can be specified in config.yaml by using the following
  "magic value": `$env:ENVIRONMENT_VARIABLE[:DEFAULT_VALUE]`.
