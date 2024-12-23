package com.sabam.runner;

import com.sabam.configurationproperties.TutorialConfigurationProperties;
import com.sabam.value.TutorialValue;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@Slf4j
public class ApplicationPropertiesRunner implements ApplicationRunner {


  @Autowired
  private TutorialConfigurationProperties properties;

  @Override
  public void run(ApplicationArguments args) throws Exception {
    log.info(properties.getName());
    log.info(String.valueOf(properties.getVersion()));
    log.info(String.valueOf(properties.isProductionMode()));
  }
}