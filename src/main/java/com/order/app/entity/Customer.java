package com.order.app.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer {
	@Id
	@Column(name="customer_id")
	private Long customerId;
	
	@Column(name="customer_name")
	private String customerName;
	
	@Column(name="customer_email")
	private String customerEmail;
	
	@Column(name="created_date")
	private Date createDate;
	
	@Column(name="updated_date")
	private Date updatedDate;
	
	@Column(name="is_prime_user")
	private Boolean isPrimeUser;
	
	@Column(name="prime_start_date")
	private Date primeStartDate;
	
	@Column(name="prime_end_date")
	private Date primeEndDate;

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public Boolean getIsPrimeUser() {
		return isPrimeUser;
	}

	public void setIsPrimeUser(Boolean isPrimeUser) {
		this.isPrimeUser = isPrimeUser;
	}

	public Date getPrimeStartDate() {
		return primeStartDate;
	}

	public void setPrimeStartDate(Date primeStartDate) {
		this.primeStartDate = primeStartDate;
	}

	public Date getPrimeEndDate() {
		return primeEndDate;
	}

	public void setPrimeEndDate(Date primeEndDate) {
		this.primeEndDate = primeEndDate;
	}
	
	
}
