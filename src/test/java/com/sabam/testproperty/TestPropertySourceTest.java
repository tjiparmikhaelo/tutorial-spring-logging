package com.sabam.testproperty;

import com.sabam.propertysource.TutorialPropertySource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@TestPropertySource("classpath:/test.properties")
@SpringBootTest(classes = TutorialPropertySource.class)
public class TestPropertySourceTest {

  @Autowired
  TutorialPropertySource.SampleSource source;

  @Test
  void testPropertySource() {
    Assertions.assertEquals("Programmer Zaman Baheula", source.getName());
    Assertions.assertEquals(2, source.getVersion());
  }
}
