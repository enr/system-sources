# system-sources

![CI](https://github.com/enr/system-sources/workflows/CI/badge.svg)

[![](https://jitpack.io/v/enr/system-sources.svg)](https://jitpack.io/#enr/system-sources)

Java library providing components to access environment-based resources such as system properties, environment variables, and date/time sources.

Using this library improves the testability of components that depend on these resources.

Instead of accessing system resources directly (e.g., using `System.getenv(key)`), developers use the provided components. This allows for easy mocking of environment data in tests, ensuring predictable and reproducible behavior.

## Usage

The following examples demonstrate how to use the `DateTimeSource` component in your application and tests.

We have a component using `LocalDateTime`:

```java
class ComponentUsingDateTime {
  public LocalDateTime getCurrentDateTime() {
    return LocalDateTime.now();
  }
}
```

The component is changed to use `DateTimeSource` to get the current date and time.

```java
class ComponentUsingDateTime {
  private final DateTimeSource dts;
  public ComponentUsingDateTime(DateTimeSource dts) {
    this.dts = dts;
  }
  public LocalDateTime getCurrentDateTime() {
    return dts.nowAsLocalDateTime();
  }
}
```

In an application context the component uses default instance of `DateTimeSource`:

```java
DateTimeSource dts = new DateTimeSource() {};
ComponentUsingDateTime componentInApp = new ComponentUsingDateTime(dts);
```

A mock implementation of `DateTimeSource` is provided to `ComponentUsingDateTime` for testing purposes.

This mock returns a fixed date and time, ensuring predictable test results:

```java
DateTimeSource dts = new DateTimeSource() {
  @Override
  public LocalDateTime nowAsLocalDateTime() {
    return LocalDateTime.of(2020, 1, 1, 0, 0);
  }
}
ComponentUsingDateTime componentInTest = new ComponentUsingDateTime(dts);
```

## Dependency

To get this project into your build:

Add the JitPack repository to your build file

```xml
<repositories>
  <repository>
      <id>jitpack.io</id>
      <url>https://jitpack.io</url>
  </repository>
</repositories>
```

Add the dependency

```xml
<dependency>
    <groupId>com.github.enr</groupId>
    <artifactId>system-sources</artifactId>
    <version>${idealwinner.version}</version>
</dependency>
```

## Development

Build:

```
mvn install
```

Full check (test and formatting):

```
mvn -Pci
```

Repair formatting:

```
mvn -Pfmt
```

Fast build (skip any check and file generation):

```
mvn -Pfast
```
