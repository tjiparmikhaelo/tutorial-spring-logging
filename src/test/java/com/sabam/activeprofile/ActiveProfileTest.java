package com.sabam.activeprofile;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest(classes = TutorialActiveProfiles.class)
@ActiveProfiles({"local", " production"})
public class ActiveProfileTest {

  @Autowired
  private TutorialActiveProfiles.SampleProfile sampleProfile;

  @Test
  void testActiveProfile() {

    Assertions.assertArrayEquals(new String[]{"local", "production"}, sampleProfile.getProfiles());
  }
}
