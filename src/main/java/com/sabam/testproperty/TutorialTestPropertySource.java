package com.sabam.testproperty;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class TutorialTestPropertySource {

  @Component
  @Getter
  public static class SampleSource {

    @Value("${sample.name}")
    private String name;

    @Value("${sample.version}")
    private Integer version;
  }
}
