package com.ticket.master.repository;

import com.ticket.master.entities.SeatHold;

/**
 * 
 * Repository Interface
 * 
 */

public interface TicketRepository {
	/**
	 * 
	 * Find available seats in the venue that are neither held nor reserved
	 *
	 * 
	 * 
	 * @return the number of seats available in the venue
	 * 
	 */
	int findAvailableSeats();
	/**
	 * 
	 * Find and hold the best available seats for a customer
	 *
	 * 
	 * 
	 * @param numSeats
	 *            the number of seats to find and hold
	 * 
	 * @param customerEmail
	 *            unique identifier for the customer
	 * 
	 * @return a SeatHold object identifying the specific seats and related
	 * 
	 *         information
	 * 
	 */
	SeatHold findSeatBestAvailableSeatsAndHold(int numSeats, String customerEmail);
	/**
	 * 
	 * Reserve seats held for a specific customer
	 *
	 * 
	 * 
	 * @param seatHoldId
	 *            the seat hold identifier
	 * 
	 * @return a reservation confirmation code
	 * 
	 */
	void confirmReservations(SeatHold seatHold);

}
