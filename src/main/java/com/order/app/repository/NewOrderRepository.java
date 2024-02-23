package com.order.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.order.app.entity.NewOrder;

public interface NewOrderRepository extends JpaRepository<NewOrder, Long>{

}
