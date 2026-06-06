package com.example.demo.Securityconfig;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.orderEntity.User;
import com.example.demo.orderrepository.UserRepository;
@Service
public class CustomerUserDetailsService implements UserDetailsService   {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username)
                .orElseThrow(() ->
                        new UsernameNotFoundException(
                                "User not found with username: " + username));
		
		System.out.println("username"+ user.getUsername());
		System.out.println("Role"+ user.getRole());
 
		UserDetails userDetails= org.springframework.security.core.userdetails.User
     
                .withUsername(user.getUsername())
                .password(user.getPassword())
                .roles(user.getRole().toUpperCase())
                .build();
		System.out.println("Authorities="+ userDetails.getAuthorities());
		
		return userDetails;
	}

}
