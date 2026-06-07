package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.OrderRequestDTO;
import com.example.demo.dto.OrderResponseDTO;
import com.example.demo.orderEntity.OrderStatus;
import com.example.demo.orderservice.Orderservice;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;

@SecurityRequirement(name = "bearerAuth")

@RestController
@RequestMapping("/orders")
public class OrderController {

	@Autowired
	private Orderservice serv;

	// create order
	@PostMapping
	public ResponseEntity<OrderResponseDTO> createOrder(@Valid @RequestBody OrderRequestDTO dto) {
		System.out.println("create order hit");
		OrderResponseDTO savedOrder = serv.createOrder(dto);
		return new ResponseEntity<>(savedOrder, HttpStatus.CREATED);

	}

	// GetAllOrders
	@GetMapping
	public ResponseEntity<List<OrderResponseDTO>> getAllOrders() {
		List<OrderResponseDTO> orders = serv.getAllOrders();
		return ResponseEntity.ok(orders);
	}

	// GetByid
	@GetMapping("/{id}")
	public ResponseEntity<OrderResponseDTO> getORderByID(@PathVariable Long id) {
		OrderResponseDTO order = serv.getOrderbyId(id);
		return ResponseEntity.ok(order);
	}

	// update order
	@PutMapping("/{id}")
	public ResponseEntity<OrderResponseDTO> updateOrder(@PathVariable Long id, @RequestBody OrderRequestDTO dto) {
		OrderResponseDTO updatedorder = serv.updateOrder(id, dto);
		return ResponseEntity.ok(updatedorder);
	}

	@PatchMapping("/{id}/status")
	public ResponseEntity<OrderResponseDTO> updateStatus(@PathVariable Long id, @RequestBody OrderRequestDTO dto) {
		OrderResponseDTO response = serv.updateOrderStatus(id, dto.getStatus());
		return ResponseEntity.ok(response);

	}

	@PatchMapping("/{id}/processing")
	public ResponseEntity<OrderResponseDTO> moveToProcessing(@PathVariable Long id, @RequestBody OrderRequestDTO dto) {
		OrderResponseDTO moveprocess = serv.moveToProcessing(id, dto.getStatus());
		return ResponseEntity.ok(moveprocess);

	}

	@PatchMapping("/{id}/Shipping")
	public ResponseEntity<OrderResponseDTO> moveToShipping(@PathVariable Long id, @RequestBody OrderRequestDTO dto) {
		OrderResponseDTO moveprocess = serv.moveToShipping(id, dto.getStatus());
		return ResponseEntity.ok(moveprocess);

	}

	@PatchMapping("/{id}/Deliverd")
	public ResponseEntity<OrderResponseDTO> moveToDeliverd(@PathVariable Long id, @RequestBody OrderRequestDTO dto) {
		OrderResponseDTO moveprocess = serv.moveToDeliverd(id, dto.getStatus());
		return ResponseEntity.ok(moveprocess);

	}

	// Detele order
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteOrder(@PathVariable Long id) {

		serv.deleteOrder(id);
		return ResponseEntity.ok("orderDeleted Successfully");

	}
}
