package com.example.demo.orderservice;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.OrderRequestDTO;
import com.example.demo.dto.OrderResponseDTO;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.orderEntity.Order;
import com.example.demo.orderEntity.OrderStatus;
import com.example.demo.orderrepository.Repository;

@Service
public class Orderservice implements OrderServiceImpl {

	@Autowired
	private Repository repo;

	// create order number

	@Override
	public OrderResponseDTO createOrder(OrderRequestDTO dto) {

		Order order = new Order();

		order.setCustomername(dto.getCustomername());
		order.setProductName(dto.getProductName());
		order.setQuantity(dto.getQuantity());
		order.setPrice(dto.getPrice());

		// generate unique number
		order.setOrdernumber(UUID.randomUUID().toString());

		// calculate totalamount
		Double total_amount = dto.getPrice() * dto.getQuantity();
		order.setTotal_amount(total_amount);

		order.setStatus(OrderStatus.CREATED);

		order.setCreateAt(LocalDateTime.now());

		Order savedOrder = repo.save(order);

		return mapTOResponseDTO(savedOrder);

	}


	// <----------------------------------------------------------------------------------------->
	@Override
	public List<OrderResponseDTO> getAllOrders() {
		return repo.findAll().stream().map(this::mapTOResponseDTO).collect(Collectors.toList());
	}

	@Override
	public OrderResponseDTO getOrderbyId(Long id) {
		Order order = repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("order not found with id" + id));
		return mapTOResponseDTO(order);

	}

	@Override
	public OrderResponseDTO updateOrder(Long id, OrderRequestDTO dto) {
		Order existingOrder = repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("orderNotfound with id" + id));

		existingOrder.setCustomername(dto.getCustomername());
		existingOrder.setProductName(dto.getProductName());
		existingOrder.setQuantity(dto.getQuantity());
		existingOrder.setPrice(dto.getPrice());

		// Recalculate the total amount
		Double total_amount = dto.getPrice() * dto.getQuantity();

		existingOrder.setTotal_amount(total_amount);

		Order updateOrder = repo.save(existingOrder);

		return mapTOResponseDTO(updateOrder);
	}

	@Override
	public void deleteOrder(Long id) {
		Order existingOrder = repo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("order NOt found with id: " + id));
		repo.delete(existingOrder);

	}
	// convert entity to DTO

	private OrderResponseDTO mapTOResponseDTO(Order order) {
		// TODO Auto-generated method stub

		OrderResponseDTO dto = new OrderResponseDTO();
		dto.setId(order.getId());
		dto.setCustomername(order.getCustomername());
		dto.setProductName(order.getProductName());
		dto.setOrdernumber(order.getOrdernumber());
		dto.setQuantity(order.getQuantity());
		dto.setTotal_amount(order.getTotal_amount());
		dto.setStatus(order.getStatus());
		dto.setCreatAt(order.getCreateAt());
		return dto;

	}
}
