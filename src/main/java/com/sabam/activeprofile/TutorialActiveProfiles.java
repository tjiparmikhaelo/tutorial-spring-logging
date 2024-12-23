package com.sabam.activeprofile;

import lombok.Setter;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class TutorialActiveProfiles {

  @Component
  public static class SampleProfile implements EnvironmentAware {

    @Setter
    Environment environment;

    public String[] getProfiles() {
      return environment.getActiveProfiles();
    }
  }
}
