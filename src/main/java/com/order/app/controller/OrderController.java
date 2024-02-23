package com.order.app.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.order.app.entity.Address;
import com.order.app.entity.Customer;
import com.order.app.entity.NewOrder;
import com.order.app.entity.OrderDetail;
import com.order.app.entity.OrderMainDetail;
import com.order.app.entity.Payment;
import com.order.app.model.OrderPlaced;
import com.order.app.model.OrderProduct;
import com.order.app.repository.AddressRepository;
import com.order.app.repository.CustomerRepository;
import com.order.app.repository.NewOrderRepository;
import com.order.app.repository.OrderDetailRepository;
import com.order.app.repository.OrderMainReposiroty;
import com.order.app.repository.PaymentRepository;
import com.order.app.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	OrderDetailRepository orderDetailsRepository;
	
	@Autowired
	OrderMainReposiroty orderMainRepository; 
	
	@Autowired
	OrderService orderservice;
	
	@Autowired
	PaymentRepository paymentRepository;
	
	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	AddressRepository addressRepository;
	
	@Autowired
	NewOrderRepository newOrderRepository;

	
	@GetMapping("/getAllOrders")
	public List<OrderDetail> getAllOrders() {
		List<OrderDetail> orderDetailList= orderDetailsRepository.findAll();
		return orderDetailList;
	}
	
	@PostMapping("/setAllOrders")
	public OrderPlaced setAllOrders(@RequestBody OrderMainDetail orderMainDetail) {
		OrderPlaced newOrder = validateOrder(orderMainDetail);
		
		NewOrder nOrder = new NewOrder();
		nOrder.setAddressId(newOrder.getAddressId());
		nOrder.setCustomerID(newOrder.getCustomerId());
		nOrder.setPaymentId(newOrder.getPaymentId());
		nOrder.setProductId(newOrder.getProductId());
		nOrder.setStatusId(1L);
		List<Long> orderDetailList = orderDetailsRepository.getAllTransactionDetails();
		Long maxTransaction = Collections.max(orderDetailList);
		nOrder.setTransactionId(maxTransaction+1);
		
		System.out.println("Add"+nOrder.getAddressId());
		System.out.println("payment"+nOrder.getPaymentId());
		System.out.println("productId"+nOrder.getProductId());
		System.out.println("customerId"+nOrder.getCustomerID());
		System.out.println("productid"+nOrder.getProductId());
		
		newOrderRepository.save(nOrder);

		OrderProduct[] x =orderservice.getProductName(orderMainDetail.getProductName());
		List<Payment> y = paymentRepository.getAllPaymentDetails(orderMainDetail.getPaymentType());
		List<Customer> z = customerRepository.getAllCustomerDetailsByName(orderMainDetail.getCustomerName());
		List<Address> a = addressRepository.getByFullAddress(orderMainDetail.getFullAddress());
		for(Address ad: a) {
			Long gg = ad.getAddressId();

		}

		return newOrder;
	}

	private OrderPlaced validateOrder(OrderMainDetail orderMainDetail) {
		OrderPlaced newOrder = new OrderPlaced();
		newOrder.setProductId(orderservice.getProductName(orderMainDetail.getProductName())[0].getProductId());
		newOrder.setPaymentId(paymentRepository.getAllPaymentDetails(orderMainDetail.getPaymentType()).get(0).getPaymentID());
		newOrder.setCustomerId(customerRepository.getAllCustomerDetailsByName(orderMainDetail.getCustomerName()).get(0).getCustomerId());
		List<Address> a = addressRepository.getByFullAddress(orderMainDetail.getFullAddress());
		for(Address ad: a) {
			Long gg = ad.getAddressId();
			newOrder.setAddressId(gg);
		}
		
		
		System.out.println(newOrder.getAddressId());
		System.out.println(newOrder.getCustomerId());
		System.out.println(newOrder.getPaymentId());
		System.out.println(newOrder.getProductId());
		return newOrder;
	}
	
}
