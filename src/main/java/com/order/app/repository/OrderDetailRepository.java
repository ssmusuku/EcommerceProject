package com.order.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.order.app.entity.OrderDetail;

@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetail, Long> {
	
	@Query(value = "select transcation_id from ecomm_order.order_details" ,  nativeQuery = true)
	public List<Long> getAllTransactionDetails();
}
