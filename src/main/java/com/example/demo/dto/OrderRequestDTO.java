package com.example.demo.dto;

import com.example.demo.orderEntity.OrderStatus;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class OrderRequestDTO {
//	@NotBlank(message = "Order number is required")
//	private String ordernumber;

	@NotBlank(message = "Customer name is required")
	private String customername;

	@NotBlank(message = " product name is required")
	private String productName;

	@NotNull(message = "Quantity is require")
	@Positive(message = " Quantity must be greater than 0")
	private Integer quantity;

	@NotNull(message = " Price is required")
	@Positive(message = "price must be greater than 0")
	private Double price;

//	@NotNull(message = "Status is required ")
//	private OrderStatus status;

	// created constructor
	public OrderRequestDTO() {

	}

//	public String getOrdernumber() {
//		return ordernumber;
//	}
//
//	public void setOrdernumber(String ordernumber) {
//		this.ordernumber = ordernumber;
//	}

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

//	public OrderStatus getStatus() {
//		return status;
//	}
//
//	public void setStatus(OrderStatus status) {
//		this.status = status;
//	}

	
	


}
