package com.example.demo.orderservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.RegisterRequestDTO;
import com.example.demo.orderEntity.User;
import com.example.demo.orderrepository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;

	@Override
	public User registerUser(RegisterRequestDTO request) {
		User user = new User();
		user.setUsername(request.getUsername());
		user.setPassword(request.getPassword());
		user.setRole(request.getRole());
	
		return userRepository.save(user);
	}

}
