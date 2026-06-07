package com.example.demo.orderservice;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.dto.OrderRequestDTO;
import com.example.demo.dto.OrderResponseDTO;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.orderEntity.Order;
import com.example.demo.orderEntity.OrderStatus;
import com.example.demo.orderrepository.Repository;

import jakarta.transaction.Transactional;

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
		Order order = repo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("order not found with id" + id));
		return mapTOResponseDTO(order);

	}

	@Override
	public OrderResponseDTO updateOrder(Long id, OrderRequestDTO dto) {
		Order existingOrder = repo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("orderNotfound with id" + id));

		existingOrder.setCustomername(dto.getCustomername());
		existingOrder.setProductName(dto.getProductName());
		existingOrder.setQuantity(dto.getQuantity());
		existingOrder.setPrice(dto.getPrice());

		existingOrder.setStatus(dto.getStatus());
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

	public OrderResponseDTO updateOrderStatus(Long id, OrderStatus status) {
		Order order = repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("orderNotfound with id" + id));
		try {
			if (!isValidTransaction(order.getStatus(), status)) {
				throw new IllegalStateException(
						"Invalid Status transaction from " + order.getStatus() + " to " + status);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());

		}
		order.setStatus(status.CONFIRMED);

		// System.out.println("old status =" + order.getStatus());
		// order.setStatus(OrderStatus.CONFIRMED);
		// System.out.println("new status =" + order.getStatus());
		Order updatedOrde = repo.save(order);
		return mapTOResponseDTO(updatedOrde);
	}

	@Override
	@Transactional
	public OrderResponseDTO moveToProcessing(long id, OrderStatus status) {
		Order order = repo.findById(id).orElseThrow(() -> new RuntimeException("order not found"));
		try {
			if (!isValidTransaction(order.getStatus(), status)) {
				throw new IllegalStateException(
						"Invalid Status transaction from " + order.getStatus() + " to " + status);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());

		}

		order.setStatus(OrderStatus.PROCESSING);

		Order moveprocess = repo.save(order);

		return mapTOResponseDTO(moveprocess);
	}

	@Override
	@Transactional
	public OrderResponseDTO moveToShipping(Long id, OrderStatus status) {
		Order order = repo.findById(id).orElseThrow(() -> new RuntimeException("order not found"));
		try {
			if (!isValidTransaction(order.getStatus(), status)) {
				throw new IllegalStateException(
						"Invalid Status transaction from " + order.getStatus() + " to " + status);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());

		}

		order.setStatus(OrderStatus.SHIPPED);

		Order moveshipped = repo.save(order);

		return mapTOResponseDTO(moveshipped);

	}

	@Override
	@Transactional
	public OrderResponseDTO moveToDeliverd(Long id, OrderStatus status) {
		Order order = repo.findById(id).orElseThrow(() -> new RuntimeException("order not found"));
		try {
			if (!isValidTransaction(order.getStatus(), status)) {
				throw new IllegalStateException(
						"Invalid Status transaction from " + order.getStatus() + " to " + status);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());

		}

		order.setStatus(OrderStatus.DELIVERED);

		Order moveDeliverd = repo.save(order);

		return mapTOResponseDTO(moveDeliverd);

	}

	private boolean isValidTransaction(OrderStatus current, OrderStatus next) {
		switch (current) {
		case CREATED:
			return next == OrderStatus.CONFIRMED || next == OrderStatus.CANCLLED;

		case CONFIRMED:
			return next == OrderStatus.PROCESSING || next == OrderStatus.CANCLLED;

		case PROCESSING:
			return next == OrderStatus.SHIPPED;

		case SHIPPED:
			return next == OrderStatus.DELIVERED;

		default:
			return false;

		}
	}

	@Override
	public Page<OrderResponseDTO> getAllOrders(int page, int size, String Sort) {
		Pageable pageable = PageRequest.of(page, size);
		Page<Order> orders = repo.findAll(pageable);
		return orders.map(this::mapTOResponseDTO);
		
	}

	@Override
	public List<OrderResponseDTO> getOrderByStatus(OrderStatus status) {
		List<Order> orders= repo.findByStatus(status);
		
		return orders.stream().map(this::mapTOResponseDTO).toList();
	}

	@Override
	public List<OrderResponseDTO> getOrdersByCustomer(String customername) {
	
		return repo.findByCustomername(customername).stream().map(this:: mapTOResponseDTO).toList();
	}

	@Override
	public List<OrderResponseDTO> getOrdersByProduct(String productName) {
		return repo.findByCustomername(productName).stream().map(this:: mapTOResponseDTO).toList();
	
	}

	

	

	

}
