package com.infinite.crm.controller;

import com.infinite.crm.model.TicketDTO;
import com.infinite.crm.model.User;
import com.infinite.crm.service.TicketService;
import com.infinite.crm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("api/n2")
public class TicketsAdminController {

    @Autowired
    private TicketService ticketService;

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    List<User> getAllUsers() {
        return userService.findAll();

    }

    @GetMapping("/tickets")
    List<TicketDTO> getAllTickets() {
        return ticketService.findAllTicketsforAdmin();
    }

    @GetMapping("/ticket/{tid}")
    TicketDTO getTicketById(@PathVariable Long tid) throws Exception {
        return ticketService.findTicketById(tid);
    }

    @PutMapping("/ticket/{tid}")
    TicketDTO updateTicket(@RequestBody TicketDTO newTicket, @PathVariable Long tid) {
        return ticketService.updateTicket(tid,newTicket);
    }
}
