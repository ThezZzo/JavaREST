package com.example.REST.Controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class UserController {

    @GetMapping("/users/{id}")
    public Map<String, Object> getEmail() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Map<String, Object> userMap = new HashMap<>();
        userMap.put("email", authentication.getName());
        userMap.put("error", false);
        return userMap;
    }
}
