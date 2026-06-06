package com.example.demo.orderrepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.dto.OrderResponseDTO;
import com.example.demo.orderEntity.Order;

public interface Repository extends JpaRepository<Order,Long> {

	

}
