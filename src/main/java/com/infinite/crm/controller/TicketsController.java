package com.infinite.crm.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import io.reactivex.rxjava3.core.Observable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infinite.crm.exceptions.UserNotFoundException;
import com.infinite.crm.model.Ticket;
import com.infinite.crm.model.TicketDTO;
import com.infinite.crm.service.TicketService;


@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("api/n1")
public class TicketsController {

	@Autowired
	private TicketService ticketService;

	@PostMapping("/{useremail}/ticket")
	Observable<Ticket> newTicket(@PathVariable String useremail, @RequestBody TicketDTO newTicket) {

		LocalDateTime myDateObj = LocalDateTime.now();
	    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd MMM yyyy HH:mm a");

	    String formattedDate = myDateObj.format(myFormatObj);

	    newTicket.setRaiseddate(formattedDate);

		return Observable.fromCallable(()->ticketService.addTicket(useremail,newTicket));
	}

	@GetMapping("/{useremail}/tickets")
	Observable<TicketDTO> getAllTicketsbyemail(@PathVariable String useremail) {
		return Observable.fromIterable(ticketService.findAllTickets(useremail));
	}

	@GetMapping("/tickets")
	Observable<TicketDTO> getAllTickets() {
		return Observable.fromIterable(ticketService.findAllTicketsforAdmin());
	}

	/*
	 * @GetMapping("/{useremail}/ticket/{tid}") TicketDTO
	 * getTicketById(@PathVariable String useremail,@PathVariable Long tid) throws
	 * Exception { return ticketService.findTicketById(useremail,tid); }
	 */

	@GetMapping("/ticket/{tid}")
	Observable<TicketDTO> getTicketById(@PathVariable Long tid) throws Exception {
		return Observable.fromCallable(()->ticketService.findTicketById(tid));
	}

	@PutMapping("/ticket/{tid}")
	Observable<TicketDTO> updateTicket(@RequestBody TicketDTO newTicket, @PathVariable Long tid) {
		return Observable.fromCallable(()->ticketService.updateTicket(tid,newTicket));
	}

	@DeleteMapping("/ticket/{tid}")
	Observable<String> deleteTicket(@PathVariable Long tid) {
		if (!ticketService.exist(tid)) {
			throw new UserNotFoundException(tid);
		}
		ticketService.deleteTicket(tid);
		return Observable.fromCallable(()->"User with id " + tid + " has been deleted success.");
	}
}
