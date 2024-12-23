package com.sabam.profileproperties;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class TutorialProfileProperties {

  @Component
  @Getter
  public static class SampleProperties {

    @Value("${profile.default}")
    private String defaultProfile;

    @Value("${profile.production}")
    private String productionProfile;

//    @Value("${profile.test}")
//    private String testingProfile;
  }
}
