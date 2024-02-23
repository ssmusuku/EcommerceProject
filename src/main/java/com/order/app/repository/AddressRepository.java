package com.order.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.order.app.entity.Address;



public interface AddressRepository extends JpaRepository<Address, Long>{

	@Query(value = "SELECT * FROM customer_template WHERE full_address=:fullAddress", nativeQuery = true)
	public List<Address> getByFullAddress(String fullAddress);
}

