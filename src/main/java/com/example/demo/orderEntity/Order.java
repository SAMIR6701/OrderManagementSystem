package com.example.demo.orderEntity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "orders")
public class Order {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "order_number", nullable = false, unique = true)
	private String ordernumber;
	
	@Column(name = "customer_name", nullable = false)
	private String customername;
	
	@Column(name = "product_name", nullable = false)
	private String productName;
	
	@Column(nullable = false)
	private Integer quantity;
	
	@Column(nullable = false)
	private Double price;
	
	@Column(name = "total_amount", nullable = false)
	private Double total_amount;
	
	@Enumerated(EnumType.STRING)
	private OrderStatus status;
	
	@Column(name = "created_at")
	private LocalDateTime createAt;

	// Default Constructor
	public Order() {

	}

	public Order(String ordernumber, String customername, String productName, Integer quantity,
			Double price, Double total_amount, OrderStatus status, LocalDateTime createAt) {
		super();
		
		this.ordernumber=ordernumber;
		this.customername = customername;
		this.productName = productName;
		this.quantity = quantity;
		this.price = price;
		this.total_amount = total_amount;
		this.status = status;
		this.createAt = createAt;
	}

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

	public LocalDateTime getCreateAt() {
		return createAt;
	}

	public void setCreateAt(LocalDateTime createAt) {
		this.createAt = createAt;
	}

	@Override
	public String toString() {
		return "OrderProcessingSystem [id=" + id + ", ordernumber=" + ordernumber + ", customername=" + customername
				+ ", productName=" + productName + ", quantity=" + quantity + ", price=" + price + ", total_amount="
				+ total_amount + ", status=" + status + ", createAt=" + createAt + "]";
	}

	

	

}
