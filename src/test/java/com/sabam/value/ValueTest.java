package com.sabam.value;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = TutorialValue.class)
public class ValueTest {

  @Autowired
  TutorialValue.ApplicationProperties properties;

  @Autowired
  TutorialValue.SystemProperties systemProperties;

  @Test
  void testValue() {
    String name = properties.getName();
    Integer version = properties.getVersion();
    boolean productionMode = properties.isProductionMode();

    Assertions.assertEquals("spring-config-tutorial", name);
    Assertions.assertEquals(1, version);
    Assertions.assertFalse(productionMode);
  }

  @Test
  void testSystemProperties() {

    String javaHome = systemProperties.getJavaHome();

    Assertions.assertEquals("C:\\Program Files\\Java\\jdk1.8.0_202", javaHome);
  }
}
