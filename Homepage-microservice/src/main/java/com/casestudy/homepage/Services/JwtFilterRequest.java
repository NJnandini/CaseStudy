package com.casestudy.homepage.Services;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.casestudy.homepage.utils.JwtUtils;

import io.jsonwebtoken.ExpiredJwtException;

@Component
public class JwtFilterRequest extends OncePerRequestFilter{
		
	@Autowired
	private JwtUtils jwtUtils;
	
	@Autowired
	private UserService userService;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		String authorizationHeader = request.getHeader("Authorization");
		String username= null;
		//String password = null;
		String jwtToken = null;
		
		if(authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
			
			jwtToken = authorizationHeader.substring(7);
			try {
				username = jwtUtils.extractUsername(jwtToken);
			} catch (IllegalArgumentException e) {
				System.out.println("Unable to get JWT Token");
			} catch (ExpiredJwtException e) {
				System.out.println("JWT Token has expired");
			}
			
		} else {
			System.out.println("JWT token does not start with Bearer");
		}
		
		if( username != null && SecurityContextHolder.getContext().getAuthentication() == null) {

			UserDetails currentUserDetails = userService.loadUserByUsername(username);
			Boolean tokenValidate = jwtUtils.validateToken(jwtToken, currentUserDetails);
			
			if (tokenValidate) {
				
				UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(currentUserDetails, null,  currentUserDetails.getAuthorities());
				usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				 SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
				
			}
			
		}
		
		filterChain.doFilter(request, response);
		
	}

}
