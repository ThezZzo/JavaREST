package com.example.REST.Service;

import com.example.REST.Entity.Ticket;

import java.util.Date;
import java.util.List;

public interface ITicketService {
    List<Ticket> getAllTickets();

    Ticket getTicketById(Long id);

    Ticket createTicket(Ticket ticket);

    Ticket updateTicket(Long id, Ticket ticket);

    void deleteTicket(Long id);
}
