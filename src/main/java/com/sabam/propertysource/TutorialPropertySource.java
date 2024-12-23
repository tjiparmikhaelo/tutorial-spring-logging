package com.sabam.propertysource;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@SpringBootApplication
@PropertySource("classpath:/sample.properties")
public class TutorialPropertySource {

  @Component
  @Getter
  public static class SampleSource {

    @Value("${sample.name}")
    private String name;

    @Value("${sample.version}")
    private Integer version;
  }
}
