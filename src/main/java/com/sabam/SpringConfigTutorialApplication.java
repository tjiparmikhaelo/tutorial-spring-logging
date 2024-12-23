package com.sabam;

import com.sabam.configurationproperties.TutorialConfigurationProperties;
import com.sabam.converter.StringToDateConverter;
import com.sabam.value.TutorialValue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.convert.ApplicationConversionService;
import org.springframework.context.annotation.Bean;
import org.springframework.core.convert.ConversionService;

@SpringBootApplication
@EnableConfigurationProperties({
		TutorialConfigurationProperties.class
})
public class SpringConfigTutorialApplication {

	@Bean
	public ConversionService conversionService(StringToDateConverter stringToDateConverter) {
		ApplicationConversionService conversionService = new ApplicationConversionService();

		conversionService.addConverter(stringToDateConverter);

		return conversionService;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringConfigTutorialApplication.class, args);
	}

}
