package com.payment.transaction.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.payment.transaction.model.User;

public interface RegistrationRepository extends JpaRepository<User, Integer>{

	public User findByEmailId(String emailId);
	
	public User findByEmailIdAndPassword(String emailId, String Password);
}
