package com.github.fish.spring4.config;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;

@SpringBootConfiguration
public class UserConfiguration {
	
	@Bean
	@ConditionalOnProperty(name="file.enabled",havingValue="true")
	public EncodingConvert createUTF8EncodingConvert() {
		return new UTF8EncodingConvert();
	}
	
	

}
