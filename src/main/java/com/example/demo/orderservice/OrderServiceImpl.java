package com.example.demo.orderservice;

import java.util.List;

import org.springframework.data.domain.Page;

import com.example.demo.dto.OrderRequestDTO;
import com.example.demo.dto.OrderResponseDTO;
import com.example.demo.orderEntity.OrderStatus;

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

	OrderResponseDTO updateOrderStatus(Long id, OrderStatus status);

	OrderResponseDTO moveToProcessing(long id, OrderStatus status);

	OrderResponseDTO moveToShipping(Long id, OrderStatus status);

	OrderResponseDTO moveToDeliverd(Long id, OrderStatus status);

	Page<OrderResponseDTO> getAllOrders(int page, int size, String Sort);

	List<OrderResponseDTO> getOrderByStatus(OrderStatus status);

	List<OrderResponseDTO> getOrdersByCustomer(String customername);

	List<OrderResponseDTO> getOrdersByProduct(String productName);

}
