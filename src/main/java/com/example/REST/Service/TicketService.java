package com.example.REST.Service;

import com.example.REST.Entity.Ticket;
import com.example.REST.Repository.TicketRepository;
import org.springframework.stereotype.Service;


import java.util.Date;
import java.util.List;

@Service
public class TicketService implements ITicketService {

    private final TicketRepository ticketRepository;

    public TicketService(TicketRepository userRepository) {
        this.ticketRepository = userRepository;
    }

    @Override
    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll();
    }

    @Override
    public Ticket getTicketById(Long id) {
        return ticketRepository.findById(id).orElseThrow(() -> new RuntimeException("Билет не найден"));
    }

    @Override
    public Ticket createTicket(Ticket ticket) {
        return ticketRepository.save(ticket);
    }

    @Override
    public Ticket updateTicket(Long id, Ticket ticket) {
        Ticket existingTicket = ticketRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        existingTicket.setDatazaloga(ticket.getDatazaloga());
        existingTicket.setSummazaloga(ticket.getSummazaloga());
        return ticketRepository.save(existingTicket);
    }

    @Override
    public void deleteTicket(Long id) {
        ticketRepository.deleteById(id);
    }
}