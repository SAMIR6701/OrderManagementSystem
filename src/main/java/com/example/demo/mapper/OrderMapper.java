package com.example.demo.mapper;

import java.time.LocalDateTime;

import com.example.demo.dto.OrderRequestDTO;
import com.example.demo.dto.OrderResponseDTO;
import com.example.demo.orderEntity.Order;

public class OrderMapper {
	public static Order toEntity(OrderRequestDTO dto) {
		Order order = new Order();
		//order.setOrdernumber(dto.getOrdernumber());
		order.setCustomername(dto.getCustomername());
		order.setProductName(dto.getProductName());
		order.setQuantity(dto.getQuantity());
		order.setTotal_amount(dto.getQuantity() * dto.getPrice());
	//	order.setStatus(dto.getStatus());
		order.setCreateAt(LocalDateTime.now());
		return order;
	}

	public static OrderResponseDTO toResponseDTO(Order order) {
		OrderResponseDTO dto = new OrderResponseDTO();

		dto.setId(order.getId());
		dto.setOrdernumber(order.getOrdernumber());
		dto.setCustomername(order.getCustomername());
		dto.setProductName(order.getProductName());
		dto.setQuantity(order.getQuantity());
		dto.setTotal_amount(order.getTotal_amount());
		dto.setCreatAt(order.getCreateAt());

		return dto;
	}

}
