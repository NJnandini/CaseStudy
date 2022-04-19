package com.casestudy.homepage.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.casestudy.homepage.Repositories.UserRepository;
import com.casestudy.homepage.Services.UserService;
import com.casestudy.homepage.models.AuthRequest;
import com.casestudy.homepage.models.AuthResponse;
import com.casestudy.homepage.models.UserModel;
import com.casestudy.homepage.utils.JwtUtils;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@CrossOrigin(origins= {"*"}, maxAge = 4800, allowCredentials = "false"  )
public class AuthController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private JwtUtils jwtUtils; 
	
	@GetMapping("/dashboard")
	private String testingToken()
	{
		return "Welcome to DashBoard";
	}
	

	@PostMapping("/registration")
	private ResponseEntity<?> susbscribeClient(@RequestBody AuthRequest authRequest){
		
		String username = authRequest.getUsername();
		String password = authRequest.getPassword();
		String email = authRequest.getEmail();
		
		UserModel user = new UserModel();
		user.setUsername(username);
		user.setPassword(password);
		user.setEmail(email);
		try {
			
			userRepository.save(user);
			
		}catch(Exception e) {
			
			return ResponseEntity.ok(new AuthResponse("Error occured while your Subscription " + username));
		
		}
		
		return ResponseEntity.ok(new AuthResponse("Your Subscription is successful " + username));
	}
	
	@PostMapping("/token")
	private ResponseEntity<?> authenticateClient(@RequestBody AuthRequest authRequest){
		
		String username = authRequest.getUsername();
		String password = authRequest.getPassword();
		
		
		try {
			
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken( username, password));
		
		}catch(Exception e) {
			
			return ResponseEntity.ok(new AuthResponse("Error occured while your Authentication " + username));
		
		}
		

		UserDetails loadedUser = userService.loadUserByUsername(username);
		
		String generatedToken =jwtUtils.generateToken(loadedUser);
		
		return ResponseEntity.ok(new AuthResponse(generatedToken));

	}
	
    
    @GetMapping("/getAllUsers")
    public List<UserModel> findAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/findUser/{email}")
    public List<UserModel> findUser(@PathVariable String email) {
        return userRepository.findByEmail(email);
    }

    @DeleteMapping("/cancel/{id}")
    public List<UserModel> cancelRegistration(@PathVariable int id) {
        userRepository.deleteById(id);
        return userRepository.findAll();
    }
   
}
