package com.github.enr.system;

import java.util.Map;

public interface EnvironmentSource {

  default Map<String, String> getEnv() {
    return System.getenv();
  }

  default String getEnvironmentVar(String key) {
    return System.getenv(key);
  }

  public static EnvironmentSource actual() {
    return ActualSource.ENVIRONMENT;
  }
}
