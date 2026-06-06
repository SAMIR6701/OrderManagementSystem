package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Securityconfig.JwtUtil;
import com.example.demo.dto.AuthRequest;
import com.example.demo.dto.RegisterRequestDTO;
import com.example.demo.orderEntity.User;
import com.example.demo.orderrepository.UserRepository;
import com.example.demo.orderservice.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

	@Autowired
	private UserService userService;

	private final JwtUtil jwtUtil;
	private final PasswordEncoder passwordEncoder;

	private final UserRepository userRepository;

	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody AuthRequest request) {

		User user = userRepository.findByUsername(request.getUsername()).orElse(null);
		if (user == null) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
		}

		if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid   password");
		}

		String token = jwtUtil.generateToken(user.getUsername());
		return ResponseEntity.ok(token);

	}

	@PostMapping("/register")
	public ResponseEntity<?> registerUser(@RequestBody RegisterRequestDTO request) {
		System.out.println("Register api hit");
	 
	    if (userRepository.existsByUsername(request.getUsername())) {
	        return ResponseEntity.badRequest()
	                .body("Username already exists");
	    }
	 
	    User user = new User();
	    user.setUsername(request.getUsername());
	    user.setPassword(passwordEncoder.encode(request.getPassword()));
	    user.setRole(request.getRole());
	 
	    userRepository.save(user);
	 
	    return ResponseEntity.status(HttpStatus.CREATED)
	            .body("User registered successfully");
	}
}
