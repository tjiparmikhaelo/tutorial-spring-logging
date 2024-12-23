package com.sabam.resourceloader;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@SpringBootTest(classes = TutorialResourceLoader.SampleResource.class)
public class ResourceLoaderTest {

  @Autowired
  private TutorialResourceLoader.SampleResource sampleResource;

  @Test
  void testResourceLoader() throws IOException {
    Assertions.assertNotNull(sampleResource.getText().trim());
    Assertions.assertEquals("THIS IS RESOURCE!!!", sampleResource.getText().trim());
  }
}
