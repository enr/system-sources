package com.github.enr.system;

import java.util.Properties;

public interface SystemPropertiesSource {

  default Properties getProperties() {
    return System.getProperties();
  }

  default String getProperty(String key) {
    return System.getProperty(key);
  }

  default String getProperty(String key, String defaultValue) {
    return System.getProperty(key, defaultValue);
  }

  public static SystemPropertiesSource actual() {
    return ActualSource.SYSTEM_PROPERTIES;
  }
}
