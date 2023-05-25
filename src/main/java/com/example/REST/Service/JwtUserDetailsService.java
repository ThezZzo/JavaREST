package com.example.REST.Service;

import com.example.REST.Model.Customer;
import com.example.REST.Repository.UserRepository;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    final UserRepository userRepository;

    public JwtUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public UserDetails loadUserByEmail(String email) throws UsernameNotFoundException {
        final Customer customer = userRepository.findByEmail(email);
        if (customer == null) {
            throw new UsernameNotFoundException(email);
        }
        UserDetails user = User.withUsername(customer.getEmail()).password(customer.getPassword()).authorities("USER").build();
        return user;
    }
}
