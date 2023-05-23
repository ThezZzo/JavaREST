package com.example.REST.Entity;

import org.springframework.data.annotation.*;
import javax.persistence.Id;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tickets")
public class Ticket {
    @Id
    @Column(name="Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String summazaloga;

    @Column(nullable = false)
    private String datazaloga;

    public Ticket (String summazaloga, String datazaloga) {
        this.datazaloga = datazaloga;
        this.summazaloga = summazaloga;
    }

    public Long getId(Long id) {
        return id;
    }

    public Ticket() {

    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setSummazaloga(String sum) {
        this.summazaloga = sum;
    }

    public void setDatazaloga(String date) {
        this.datazaloga = date;
    }

    public String getDatazaloga() {
        return datazaloga;
    }

    public String getSummazaloga() {
        return summazaloga;
    }

    public Long getId() {
        return id;
    }

    // геттеры и сеттеры
}
