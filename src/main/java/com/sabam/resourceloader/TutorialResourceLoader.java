package com.sabam.resourceloader;

import lombok.Setter;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.IOException;

@SpringBootApplication
public class TutorialResourceLoader {

  @Component
  public static class SampleResource implements ResourceLoaderAware {

    @Setter
    org.springframework.core.io.ResourceLoader resourceLoader;

    public String getText() throws IOException {
      Resource resource = resourceLoader.getResource("classpath:/text/resource.txt");

      try(var inputStream = resource.getInputStream()) {
        return new String(inputStream.readAllBytes());
      }
    }
  }
}
