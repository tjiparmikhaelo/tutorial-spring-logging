package com.sabam.messagesourceaware;

import lombok.Setter;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;
import org.springframework.stereotype.Component;

import java.util.Locale;

@SpringBootApplication
public class TutorialMessageSourceAware {

  @Component
  public static class SampleSource implements MessageSourceAware {

    @Setter
    MessageSource messageSource;

    public String hello(Locale locale) {
      return messageSource.getMessage("hello", new Object[]{"theo"}, locale);
    }
  }
}
