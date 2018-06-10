package com.github.fish.spring4.config;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;

@SpringBootConfiguration
public class EncodingConvertConfiguration {
	
	@Bean
	@Conditional(UTF8Condition.class)
	public EncodingConvert createUTF8EncodingConvert() {
		return new UTF8EncodingConvert();
	}
	
	@Bean
	@Conditional(GBKCondition.class)
	public EncodingConvert createGBKEncodingConvert() {
		return new GBKEncodingConvert();
	}

}
