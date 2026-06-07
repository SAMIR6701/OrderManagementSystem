package com.example.demo.orderrepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.dto.OrderResponseDTO;
import com.example.demo.orderEntity.Order;
import com.example.demo.orderEntity.OrderStatus;

public interface Repository extends JpaRepository<Order,Long> {
List<Order> findByStatus(OrderStatus status);

List<Order> findByCustomername(String customername);

List<Order> findByProductName(String productName);

	

}
