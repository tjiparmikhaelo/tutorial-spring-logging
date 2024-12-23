package com.sabam.value;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class TutorialValue {

  @Component
  @Getter
  public static class ApplicationProperties {

    @Value("${application.name}")
    private String name;

    @Value("${application.version}")
    private Integer version;

    @Value("${application.production-mode}")
    private boolean productionMode;
  }

  @Component
  @Getter
  public static class SystemProperties {

    @Value("${JAVA_HOME}")
    private String javaHome;
  }
}
