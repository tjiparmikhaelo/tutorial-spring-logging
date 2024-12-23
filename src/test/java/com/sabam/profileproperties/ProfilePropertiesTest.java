package com.sabam.profileproperties;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles({"production", "test"})
@SpringBootTest(classes = TutorialProfileProperties.class)
public class ProfilePropertiesTest {

  @Autowired
  TutorialProfileProperties.SampleProperties properties;

  @Test
  void testProfile() {
    Assertions.assertEquals("Default", properties.getDefaultProfile());
    Assertions.assertEquals("Production", properties.getProductionProfile());
//    Assertions.assertEquals("Testing", properties.getTestingProfile());
  }
}
