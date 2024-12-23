package com.sabam.profile;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class TutorialProfile {

  public interface SayHello {
    String say(String name);
  }

  @Component
  @Profile("local")
  @Primary
  public static class SayHelloLocal implements SayHello{
    @Override
    public String say(String name) {
      return "Hello " + name + " from Local";
    }
  }

  @Component
  @Profile("production")
  public static class SayHelloProduction implements SayHello{
    @Override
    public String say(String name) {
      return "Hello " + name + " from Production";
    }
  }
}
