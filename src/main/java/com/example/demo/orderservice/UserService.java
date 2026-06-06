package com.example.demo.orderservice;

import com.example.demo.dto.RegisterRequestDTO;
import com.example.demo.orderEntity.User;

public interface UserService {
	User registerUser(RegisterRequestDTO request);

}
