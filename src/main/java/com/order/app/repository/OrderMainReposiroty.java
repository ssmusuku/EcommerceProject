package com.order.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.order.app.entity.OrderMainDetail;

public interface OrderMainReposiroty extends JpaRepository<OrderMainDetail, Long>{

}
