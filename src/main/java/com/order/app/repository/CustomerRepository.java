package com.order.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.order.app.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

	@Query(value = "SELECT * FROM customer c WHERE c.customer_name=:customerName", nativeQuery = true)
	public List<Customer> getAllCustomerDetailsByName(String customerName);


}
