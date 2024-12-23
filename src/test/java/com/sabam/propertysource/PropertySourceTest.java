package com.sabam.propertysource;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = TutorialPropertySource.class)
public class PropertySourceTest {

  @Autowired
  TutorialPropertySource.SampleSource source;

  @Test
  void testPropertySource() {
    Assertions.assertEquals("Programmer Zaman Now", source.getName());
    Assertions.assertEquals(1, source.getVersion());
  }
}
