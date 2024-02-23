package com.order.app.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.order.app.model.OrderProduct;
import com.order.app.model.PaymentModal;


@Service
public class OrderService {

	@Value("${application.getproducts.url}")
	private String getUrl;
	public OrderProduct[] getProductName(String productName) {
		
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<OrderProduct[]> responseEntity = restTemplate.getForEntity(getUrl+"/"+productName, OrderProduct[].class);
		System.err.println(responseEntity.getBody().length);
		return responseEntity.getBody();
	}
	

}
