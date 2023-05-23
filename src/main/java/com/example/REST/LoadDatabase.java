package com.example.REST;

import com.example.REST.Entity.Ticket;
import com.example.REST.Repository.TicketRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;


import javax.sql.DataSource;

@Configuration
public class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(TicketRepository repository) {
        return args -> {
          log.info(" " + repository.save(new Ticket("5000", "26.06.2022")));
            log.info(" " + repository.save(new Ticket("6000", "27.06.2022")));
        };
    }
}