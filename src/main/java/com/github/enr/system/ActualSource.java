package com.github.enr.system;

abstract class ActualSource {

  static final EnvironmentSource ENVIRONMENT = new EnvironmentSource() {};
  static final SystemPropertiesSource SYSTEM_PROPERTIES = new SystemPropertiesSource() {};
  static final DateTimeSource DATE_TIME = new DateTimeSource() {};

  private ActualSource() {
    // NOOP
  }

}
