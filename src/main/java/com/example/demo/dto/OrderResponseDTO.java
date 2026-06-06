package com.example.demo.dto;

import java.time.LocalDateTime;

import com.example.demo.orderEntity.OrderStatus;

public class OrderResponseDTO {

	private Long id;
	private String ordernumber;
	private String customername;
	private String productName;
	private Integer quantity;
	private Double price;
	private Double total_amount;
	private OrderStatus status;
	private LocalDateTime creatAt;

	// Empty constructor
	public OrderResponseDTO() {

	}

	// provided getter and setter

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOrdernumber() {
		return ordernumber;
	}

	public void setOrdernumber(String ordernumber) {
		this.ordernumber = ordernumber;
	}

	public String getCustomername() {
		return customername;
	}

	public void setCustomername(String customername) {
		this.customername = customername;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getTotal_amount() {
		return total_amount;
	}

	public void setTotal_amount(Double total_amount) {
		this.total_amount = total_amount;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public LocalDateTime getCreatAt() {
		return creatAt;
	}

	public void setCreatAt(LocalDateTime creatAt) {
		this.creatAt = creatAt;
	}

}
