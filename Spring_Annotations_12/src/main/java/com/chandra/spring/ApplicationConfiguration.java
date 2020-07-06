package com.chandra.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.chandra.spring")
public class ApplicationConfiguration {
	@Bean
	public Hello getHello()
	{
		return new Hello();
	}
	
	@Bean
	public Hello getHello1()
	{
		return new Hello();
	}

}
