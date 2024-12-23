package com.sabam.profile;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;

//@ActiveProfiles({"local", "production"})
@SpringBootTest(classes = TutorialProfile.class)
public class ProfileTest {

  @Autowired
  private TutorialProfile.SayHello sayHello;

  @Autowired
  Environment environment;

//  @Test
//  void testProfileLocal() {
//
//    Assertions.assertEquals("Hello theo from Local", sayHello.say("theo"));
//    String[] activeProfiles = environment.getActiveProfiles();
//  }

  @Test
  void testProfileProduction() {

    Assertions.assertEquals("Hello theo from Production", sayHello.say("theo"));
  }
}
