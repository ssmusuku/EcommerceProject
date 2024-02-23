package com.order.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.order.app.entity.Payment;


public interface PaymentRepository extends JpaRepository<Payment, Long> {

	@Query(value = "SELECT * FROM payment p WHERE p.payment_type=:paymentType", nativeQuery = true)
	public List<Payment> getAllPaymentDetails(String paymentType);
}
