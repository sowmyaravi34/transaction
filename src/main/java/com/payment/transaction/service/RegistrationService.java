package com.payment.transaction.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.payment.transaction.model.User;
import com.payment.transaction.repository.RegistrationRepository;

@Service
public class RegistrationService {

	@Autowired
	private RegistrationRepository repo;
	
	public  User saveUser(User user) {
		return repo.save(user);
	}
	
	public User fetchUserByEmailId(String email) {
		return repo.findByEmailId(email);		
	}
	
	public User fetchByEmailIdAndPassword(String email,String password) {
		return repo.findByEmailIdAndPassword(email, password);		
	}
}
