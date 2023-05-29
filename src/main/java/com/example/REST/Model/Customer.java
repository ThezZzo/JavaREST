package com.example.REST.Model;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Id;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class Customer {

    @Id
    @Column(name="Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column
    private String role;

    public Customer(String email, String password, String role) {
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public String getRole() {
        return role;
    }
    public Customer() {

    }
    public void setRole(String role) {
        this.role = role;
    }
    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

}
