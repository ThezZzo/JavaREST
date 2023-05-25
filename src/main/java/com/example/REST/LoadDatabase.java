package com.example.REST;

import com.example.REST.Entity.Ticket;
import com.example.REST.Model.Customer;
import com.example.REST.Repository.TicketRepository;
import com.example.REST.Repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Configuration
public class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(TicketRepository ticketRepository, UserRepository userRepository) {
        return args -> {
          log.info(" " + ticketRepository.save(new Ticket("5000", "26.06.2022")));
          log.info(" " + ticketRepository.save(new Ticket("6000", "27.06.2022")));
        };
    }

}