package com.ticket.master.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ticket.master.entities.SeatHold;
import com.ticket.master.service.TicketService;


/**
 * Controller for the ticket service application,That handles the HTTP requests.
 *  RequestMapping maps all HTTP operations. It handles GET requests for /availableseats to review number of seats 
 *  available and POST requests for /hold to hold the seats for 90 seconds and PUT requests for /reservations to 
 *  confirm the hold seats. 
 *
 */
@RestController
public class TicketController {

	private final TicketService ticketService;

	public TicketController(final TicketService ticketService) {
		this.ticketService = ticketService;
	}

	@RequestMapping(value = "/availableseats", method = RequestMethod.GET)
	public int allAvailableSeats() {
		final int numSeatsAvailable = ticketService.numSeatsAvailable();
		return numSeatsAvailable;
	}

	@RequestMapping(value = "/hold", consumes = "application/json", method = RequestMethod.POST)
	public ResponseEntity<SeatHold> findAndHoldSeats(@RequestBody SeatHold seathold) {
		seathold = ticketService.findAndHoldSeats(seathold.getNumSeats(), seathold.getCustomerEmail());
		ResponseEntity<SeatHold> response;
		response = new ResponseEntity<>(seathold, HttpStatus.CREATED);
		return response;
	}

	@RequestMapping(value = "/reservations", consumes = "application/json", method = RequestMethod.PUT)
	public ResponseEntity<SeatHold> reserveSeats(@RequestBody SeatHold seathold) {
		ResponseEntity<SeatHold> response;
		ticketService.reserveSeats(seathold);
		response = new ResponseEntity<>(seathold, HttpStatus.OK);
		return response;
	}
}
