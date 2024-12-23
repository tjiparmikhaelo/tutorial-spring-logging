package com.sabam.messagesource;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;

@SpringBootApplication
public class TutorialMessageSource {

  @Bean
  public MessageSource messageSource() {

    ResourceBundleMessageSource source = new ResourceBundleMessageSource();

    source.setBasenames("my");

    return source;
  }
}
