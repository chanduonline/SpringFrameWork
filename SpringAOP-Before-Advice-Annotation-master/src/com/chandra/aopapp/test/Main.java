/**
 * 
 */
package com.chandra.aopapp.test;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.chandra.aopapp.config.AppConfig;
import com.chandra.aopapp.service.TransferService;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
		TransferService transferService = applicationContext.getBean(TransferService.class);
		transferService.transfer("accountA", "accountB", 50000l);
		System.out.println("Available balance: " +transferService.checkBalance("accountA"));
		transferService.diposite("accountA",  50000l);
		System.out.println("Withdrawal amount: " +transferService.withdrawal("accountB", 40000l));
		applicationContext.close();
	}

}
