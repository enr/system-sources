package com.github.enr.system;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junitpioneer.jupiter.SetSystemProperty;

class SystemPropertiesSourceTest {

  @Test
  @SetSystemProperty(key = "test.property", value = "test")
  void test01() {
    SystemPropertiesSource sut = SystemPropertiesSource.actual();
    assertThat(sut.getProperties()).as("properties").containsEntry("test.property", "test")
        .containsAllEntriesOf(System.getProperties());
    assertThat(sut.getProperty("test.property")).as("test.property").isEqualTo("test")
        .isEqualTo(System.getProperty("test.property"));
    assertThat(System.getProperty("no such property")).as("no such property").isNull();
    assertThat(sut.getProperty("no such property", "fallback")).as("no such property").isEqualTo("fallback");
  }
}
