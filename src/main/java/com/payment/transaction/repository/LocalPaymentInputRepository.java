package com.payment.transaction.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.payment.transaction.model.LocalPaymentInput;

public interface LocalPaymentInputRepository extends JpaRepository<LocalPaymentInput, Integer>{
	
	public LocalPaymentInput save(LocalPaymentInput input);

}
