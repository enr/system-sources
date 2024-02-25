package com.github.enr.system;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;

public interface DateTimeSource {

  default LocalDateTime nowAsLocalDateTime() {
    return LocalDateTime.now();
  }

  default LocalDate nowAsLocalDate() {
    return LocalDate.now();
  }

  default Instant nowAsInstant() {
    return Instant.now();
  }

  default java.util.Date nowAsUtilDate() {
    return new java.util.Date();
  }

  default java.sql.Date nowAsSqlDate() {
    return new java.sql.Date(System.currentTimeMillis());
  }

  default long currentTimeMillis() {
    return System.currentTimeMillis();
  }

  public static DateTimeSource actual() {
    return ActualSource.DATE_TIME;
  }
}
