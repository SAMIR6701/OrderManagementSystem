package com.example.demo.orderservice;

import java.util.List;

import com.example.demo.dto.OrderRequestDTO;
import com.example.demo.dto.OrderResponseDTO;

public interface OrderServiceImpl {



	// now we are implmented OrderResponseDTO
	OrderResponseDTO createOrder(OrderRequestDTO dto);

	// GetAllOrders
	List<OrderResponseDTO> getAllOrders();

	// Get order byid
	OrderResponseDTO getOrderbyId(Long id);

	// update Order

	OrderResponseDTO updateOrder(Long id, OrderRequestDTO dto);

	// Delete order
	void deleteOrder(Long id);

}
