package com.sabam.applicationproperties;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;

@Slf4j
@SpringBootTest(classes = ApplicationPropertiesTest.TestApplication.class)
public class ApplicationPropertiesTest {

  @Autowired
  private Environment environment;

//  @SpringBootApplication
  public static class TestApplication {}

  @Test
  void testEnvironment() {
    String property = environment.getProperty("application.name");

    Assertions.assertNotNull(property);
    Assertions.assertEquals("spring-config-tutorial", property);
  }

  @Test
  void testEnvironmentOS() {
    String javaHome = environment.getProperty("JAVA_HOME");

    Assertions.assertNotNull(javaHome);
    Assertions.assertEquals("C:\\Program Files\\Java\\jdk1.8.0_202", javaHome);
  }
}
