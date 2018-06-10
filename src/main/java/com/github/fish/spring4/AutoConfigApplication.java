package com.github.fish.spring4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * 自动配置,基于条件的自动配置
 * 
 * @author fish
 *
 */
@SpringBootConfiguration
@SpringBootApplication
public class AutoConfigApplication {
	
	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = SpringApplication.run(AutoConfigApplication.class, args);
		//System.out.println(applicationContext.getBeansOfType(EncodingConvert.class));
		//System.out.println(System.getProperty("file.encoding"));//默认是UTF-8
		//applicationContext.close();
		//在启动参数中配置编码 -Dfile.encoding=GBK
		
		System.err.println(applicationContext.getBeansOfType(Runnable.class));
		applicationContext.close();

	}

	
	/**
	 * 条件匹配
	 * @return
	 */
	@Bean
	@ConditionalOnProperty(name="file.enabled",havingValue="true",matchIfMissing=true)
	public Runnable createRunnable() {
		return () -> {
			System.err.println("spring boot is running ..");
		};
	}

}
