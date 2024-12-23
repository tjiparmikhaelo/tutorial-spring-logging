package com.sabam.configurationproperties;

import com.sabam.converter.StringToDateConverter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.convert.ApplicationConversionService;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.core.convert.ConversionService;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Arrays;
import java.util.Date;


@SpringBootTest(classes = ConfigurationPropertyTest.TestApplication.class)
public class ConfigurationPropertyTest {

  @Autowired
  private TutorialConfigurationProperties properties;

  @Autowired
  private ConversionService conversionService;

  @Test
  void testApplicationProperties() {

    Assertions.assertEquals("spring-config-tutorial", properties.getName());
    Assertions.assertEquals(1, properties.getVersion());
    Assertions.assertFalse(properties.isProductionMode());
  }

  @Test
  void testDatabaseProperties() {

    Assertions.assertEquals("learn", properties.getDatabase().getDatabase());
    Assertions.assertEquals("rhs", properties.getDatabase().getPassword());
    Assertions.assertEquals("postgres", properties.getDatabase().getUsername());
    Assertions.assertEquals("jdbc:contoh:database:url", properties.getDatabase().getUrl());
  }

  @Test
  void testCollectionProperties() {

    Assertions.assertEquals(Arrays.asList("products" ,"customers" , "categories"), properties.getDatabase().getWhitelistTables());
    Assertions.assertEquals(100, properties.getDatabase().getMaxTablesSize().get("products"));
    Assertions.assertEquals(100, properties.getDatabase().getMaxTablesSize().get("customers"));
    Assertions.assertEquals(100, properties.getDatabase().getMaxTablesSize().get("categories"));
  }

  @Test
  void testEmbeddedCollectionProperties() {

    Assertions.assertEquals("default", properties.getDefaultRoles().get(0).getId());
    Assertions.assertEquals("Default Role", properties.getDefaultRoles().get(0).getName());
    Assertions.assertEquals("guest", properties.getDefaultRoles().get(1).getId());
    Assertions.assertEquals("Guest Role", properties.getDefaultRoles().get(1).getName());

    Assertions.assertEquals("admin", properties.getRoles().get("admin").getId());
    Assertions.assertEquals("Admin Role", properties.getRoles().get("admin").getName());
    Assertions.assertEquals("finance", properties.getRoles().get("finance").getId());
    Assertions.assertEquals("Finance Role", properties.getRoles().get("finance").getName());
  }

  @Test
  void testDurationProperties() {

    Assertions.assertEquals(Duration.ofSeconds(10), properties.getDefaultTimeout());
  }

  @Test
  void testCustomConverter() {
    Date expireDate = properties.getExpireDate();

    var dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    Assertions.assertEquals("2001-08-25", dateFormat.format(expireDate));
  }

  @Test
  void  testConversionService() {

    Assertions.assertTrue(conversionService.canConvert(String.class, Duration.class));
    Assertions.assertTrue(conversionService.canConvert(String.class, Date.class));

    Duration convert = conversionService.convert("10s", Duration.class);
    Assertions.assertEquals(Duration.ofSeconds(10), convert);
  }

  @SpringBootApplication
  @EnableConfigurationProperties({
      TutorialConfigurationProperties.class
  })
  @Import({
      StringToDateConverter.class
  })
  public static class TestApplication {

    @Bean
    public ConversionService conversionService(StringToDateConverter stringToDateConverter) {
      ApplicationConversionService conversionService = new ApplicationConversionService();

      conversionService.addConverter(stringToDateConverter);

      return conversionService;
    }
  }
}
