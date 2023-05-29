package com.example.REST.Controller;

import com.example.REST.Model.Customer;
import com.example.REST.Repository.UserRepository;
import com.example.REST.Service.JwtUserDetailsService;
import com.example.REST.util.JwtTokenUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.security.auth.message.AuthException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {


    protected final Log logger = LogFactory.getLog(getClass());

    final UserRepository userRepository;
    final AuthenticationManager authenticationManager;
    final JwtUserDetailsService userDetailsService;
    final JwtTokenUtil jwtTokenUtil;

    public AuthenticationController(UserRepository userRepository, AuthenticationManager authenticationManager,
                                    JwtUserDetailsService userDetailsService, JwtTokenUtil jwtTokenUtil) {
        this.userRepository = userRepository;
        this.authenticationManager = authenticationManager;
        this.userDetailsService = userDetailsService;
        this.jwtTokenUtil = jwtTokenUtil;
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestParam("email") String email,
                                       @RequestParam("password") String password) {
        final Customer customer = userRepository.findByEmail(email);
        if (customer.getPassword().equals(password)) {
            UserDetails userDetails = userDetailsService.loadUserByEmail(email);
            final String accessToken = jwtTokenUtil.generateToken(userDetails);
            return ResponseEntity.ok(accessToken);
        } else {
            return ResponseEntity.ok("Пользователь не найден");
        }
    }


    @PostMapping("/register")
    public ResponseEntity<?> saveUser(@RequestParam("email") String email,
                                      @RequestParam("password") String password) {
        Map<String, Object> responseMap = new HashMap<>();
        Customer newCustomer = new Customer(email,password, "USER");
        UserDetails userDetails = userDetailsService.createUserDetails(email, password);
        String token = jwtTokenUtil.generateToken(userDetails);
        userRepository.save(newCustomer);
        responseMap.put("error", false);
        responseMap.put("email", newCustomer.getEmail());
        responseMap.put("message", "Account created successfully");
        responseMap.put("token", token);
        return ResponseEntity.ok(responseMap);
    }
}
