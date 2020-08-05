package com.payment.transaction.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.payment.transaction.model.LocalPaymentInput;
import com.payment.transaction.model.User;
import com.payment.transaction.repository.LocalPaymentInputRepository;
import com.payment.transaction.repository.RegistrationRepository;

@Service
public class RegistrationService {

	@Autowired
	private RegistrationRepository repo;
	
	@Autowired
	private LocalPaymentInputRepository localRepo;
	
	public  User saveUser(User user) {
		return repo.save(user);
	}
	
	public User fetchUserByEmailId(String email) {
		return repo.findByEmailId(email);		
	}
	
	public User fetchByEmailIdAndPassword(String email,String password) {
		return repo.findByEmailIdAndPassword(email, password);		
	}
	
	public LocalPaymentInput doLocalPayment(LocalPaymentInput input) {
		int custId = input.getCustomerId();
		User userobj = repo.findByCustomerId(custId);		
		String trgAccNo = input.getTargetAccountNo();
		User trgCus = repo.findByAccountNumber(trgAccNo);	
		int balance = userobj.getBalance(); 
		int transferAmount = input.getTransferAmount();
		int trgbalance = trgCus.getBalance();
		if(balance > transferAmount) { 
			int deductedAmount = balance - transferAmount;
			int depositedAmount = trgbalance + transferAmount;
			System.out.println(deductedAmount);
			System.out.println(depositedAmount);
		}else {
			System.out.println("error");
		}		
		
		return localRepo.save(input);
		
	}
}
