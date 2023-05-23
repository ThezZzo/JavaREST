package com.example.REST.Controller;

import com.example.REST.Entity.Ticket;
import com.example.REST.Service.ITicketService;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
public class TicketController {

        private final ITicketService ITicketService;

        public TicketController(ITicketService ITicketService) {
            this.ITicketService = ITicketService;
        }

        @GetMapping("/tickets")
        public List<Ticket> getAllTickets() {
            return ITicketService.getAllTickets();
        }

        @GetMapping("/tickets/{id}")
        public Ticket getUserById(@PathVariable Long id) {
            return ITicketService.getTicketById(id);
        }

        @PostMapping("/tickets")
        public Ticket createUser(@RequestBody Ticket ticket) {
            return ITicketService.createTicket(ticket);
        }

        @PutMapping("/tickets/{id}")
        public Ticket updateTicket(@PathVariable Long id, @RequestBody Ticket ticket) {
            return ITicketService.updateTicket(id, ticket);
        }

        @DeleteMapping("/tickets/{id}")
        public void deleteUser(@PathVariable Long id) {
            ITicketService.deleteTicket(id);
        }
    }
