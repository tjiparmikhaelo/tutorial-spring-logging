package com.sabam.messagesourceaware;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Locale;

@SpringBootTest(classes = TutorialMessageSourceAware.class)
public class MessageSourceAwareTest {

  @Autowired
  TutorialMessageSourceAware.SampleSource sampleSource;

  @Test
  void testMessageResourceDefault() {
    Assertions.assertEquals("Hello theo", sampleSource.hello(Locale.getDefault()));
  }

  @Test
  void testMessageResourceIndonesia() {
    Assertions.assertEquals("Halo theo", sampleSource.hello(new Locale("in_ID")));
  }
}
