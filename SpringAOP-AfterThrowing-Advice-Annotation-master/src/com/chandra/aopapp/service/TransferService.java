/**
 * 
 */
package com.chandra.aopapp.service;


public interface TransferService {
	
	void transfer(String accountA, String accountB, Long amount);
	
	Double checkBalance(String account);
	
	Long withdrawal(String account, Long amount);
	
	void diposite(String account, Long amount);
}
