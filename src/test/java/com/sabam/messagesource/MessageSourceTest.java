package com.sabam.messagesource;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Locale;

public class MessageSourceTest {

  private ApplicationContext context;
  private MessageSource source;

  @BeforeEach
  void setUp() {
    context = new AnnotationConfigApplicationContext(TutorialMessageSource.class);
    source = context.getBean(MessageSource.class);
  }

  @Test
  void testMessageSourceDefault() {
    String hello = source.getMessage("hello", new Object[]{"theo"}, Locale.ENGLISH);
    Assertions.assertEquals("Hello theo", hello);
  }

  @Test
  void testMessageSourceIndonesianLocale() {
    String hello = source.getMessage("hello", new Object[]{"theo"}, new Locale("in_ID"));
    Assertions.assertEquals("Halo theo", hello);
  }
}
