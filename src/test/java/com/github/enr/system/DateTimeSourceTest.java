package com.github.enr.system;

import static org.assertj.core.api.Assertions.assertThat;
import static org.awaitility.Awaitility.with;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;

class DateTimeSourceTest {

  @Test
  void testSystemMillis() {
    DateTimeSource sut = DateTimeSource.actual();
    long pre = System.currentTimeMillis();
    with().pollDelay(10, TimeUnit.MILLISECONDS).await().until(() -> true);
    long res = sut.currentTimeMillis();
    with().pollDelay(10, TimeUnit.MILLISECONDS).await().until(() -> true);
    long post = System.currentTimeMillis();
    assertThat(res).as("result system millis").isGreaterThan(pre).isLessThan(post);
  }
}
