package com.payment.transaction.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.payment.transaction.model.LocalPaymentInput;
import com.payment.transaction.model.User;
import com.payment.transaction.service.RegistrationService;

@RestController
public class RegistrationController {

	@Autowired
	private RegistrationService service;
	
	@PostMapping("/registeruser")
	@CrossOrigin(origins = "http://localhost:4200")
	public User registerUser(@RequestBody User user) throws Exception {
		String tempEmailId = user.getEmailId();
		if(tempEmailId != null && !"".equals(tempEmailId)){
			User userobj = service.fetchUserByEmailId(tempEmailId);
			if(userobj != null) {
				throw new Exception("user with "+tempEmailId+" already exists...");
			}
		}
		User userobj = null;
		userobj = service.saveUser(user);
		return userobj;
	}
	
	@PostMapping("/login")
	@CrossOrigin(origins = "http://localhost:4200")
	public User loginUser(@RequestBody User user) throws Exception {
		String tempEmailId = user.getEmailId();
		String tempPassword = user.getPassword();
		User userobj = null;
		if(tempEmailId != null && tempPassword != null) {
		   userobj = service.fetchByEmailIdAndPassword(tempEmailId, tempPassword);
		}
		if(userobj == null) {
			throw new Exception("Invalid Credentials...");
		}
		return userobj;
	}
	
	@PostMapping("/localPayment")
	public LocalPaymentInput doLocalPayment(@RequestBody LocalPaymentInput input) {
		LocalPaymentInput inputObj = null;
		inputObj = service.doLocalPayment(input);
		return inputObj;
	}
	
}
