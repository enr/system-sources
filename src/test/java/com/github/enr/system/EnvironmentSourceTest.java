package com.github.enr.system;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junitpioneer.jupiter.SetEnvironmentVariable;

@SetEnvironmentVariable(key = "FOO", value = "bar")
class EnvironmentSourceTest {

  @Test
  void test01() {
    EnvironmentSource sut = EnvironmentSource.actual();
    assertThat(sut.getEnv()).as("full environment").containsAllEntriesOf(System.getenv());
    assertThat(sut.getEnvironmentVar("FOO")).as("env var FOO").isEqualTo("bar").isEqualTo(System.getenv("FOO"));
  }
}
