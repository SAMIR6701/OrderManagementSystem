package com.example.demo.Securityconfig;

import java.io.IOException;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class JwtFilter extends OncePerRequestFilter {

	private final JwtUtil jwtUtil;

	private final UserDetailsService userDetailsService;
	private final CustomerUserDetailsService customerUserDetails;

	@Override
	protected boolean shouldNotFilter(HttpServletRequest request) {

		String path = request.getServletPath();

		return path.startsWith("/auth/") || path.startsWith("/swagger-ui/") || path.startsWith("/v3/api-docs")
				|| path.startsWith("/h2-console/");
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		System.out.println("jwt filter triggered");
		System.out.println("URL=" + request.getRequestURI());

		String authHeader = request.getHeader("Authorization");
		System.out.println("auth Header= " + authHeader);
		if (authHeader != null && authHeader.startsWith("Bearer ")) {

			String token = authHeader.substring(7);

			System.out.println("token= " + token);
			try {

				String username = jwtUtil.extractUsername(token);
				System.out.println("username extracted :" + username);

				if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {

					UserDetails userDetails = userDetailsService.loadUserByUsername(username);
					System.out.println("username" + username);
					System.out.println("Authorities =" + userDetails.getAuthorities());

					if (jwtUtil.validateToken(token, userDetails)) {
						UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
								userDetails, null, userDetails.getAuthorities());
						authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
						SecurityContextHolder.getContext().setAuthentication(authToken);
					}
					

				}

			} catch (Exception ex) {
				System.out.println("Exception :" + ex.getMessage());
				SecurityContextHolder.clearContext();
			}
		}

		filterChain.doFilter(request, response);
		System.out.println("filter chain continued:");
	}
}
