package com.ticket.master.service;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.ticket.master.entities.SeatHold;
import com.ticket.master.repository.TicketRepository;

@Transactional(isolation = Isolation.SERIALIZABLE)
public class TicketServiceImpl implements TicketService {

	private final TicketRepository ticketRepository;

	public TicketServiceImpl(final TicketRepository ticketRepository, final int expirationSeconds) {
		this.ticketRepository = ticketRepository;
	}

	/**
	 * 
	 * returns number of available seats	  
	 */
	@Override
	public int numSeatsAvailable() {
		final int availableSeats;
		availableSeats = ticketRepository.findAvailableSeats();
		return availableSeats;
	}
	/**
	 * 
	 * find and holds the best available seats	  
	 */
	@Override
	public SeatHold findAndHoldSeats(final int numSeats, final String customerEmail) {
		SeatHold seathold = null;
		if (!(numSeats == 0 || customerEmail == null)) {
		seathold = new SeatHold();
		seathold.setCustomerEmail(customerEmail);
		seathold.setNumSeats(numSeats);
		seathold = ticketRepository.findSeatBestAvailableSeatsAndHold(numSeats, customerEmail);
		}
		return seathold;
	}
	/**
	 * 
	 * Returns the reservation confirmation code	  
	 */

	@Override
	public SeatHold reserveSeats(SeatHold seathold) {
		if(!(seathold == null || seathold.getOrderNumber() == 0 || seathold.getCustomerEmail() == null)){
			ticketRepository.confirmReservations(seathold);
		}
		else{
			seathold = null;
		}
		return seathold;
	}
}
