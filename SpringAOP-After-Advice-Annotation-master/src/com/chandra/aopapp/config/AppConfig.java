/**
 * 
 */
package com.chandra.aopapp.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan(basePackages={"com.chandra.aopapp.aspect", "com.chandra.aopapp.service"})
public class AppConfig {
	
}
