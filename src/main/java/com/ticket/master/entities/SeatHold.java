package com.ticket.master.entities;

/**
 * SeatHold entity
 *
 */
public class SeatHold {
	

	private int numSeats;
	private String customerEmail;
	private int orderNumber;
	
	/**
	 * Getter for numSeats
	 * return numSeats
	 *
	 */
	public int getNumSeats() {
		return numSeats;
	}
	/**
	 * Setter for numSeats
	 *@param numSeats is to set numSeats
	 *
	 */
	public void setNumSeats(int numSeats) {
		this.numSeats = numSeats;
	}
	/**
	 * Getter for customerEmail
	 * return customerEmail
	 *
	 */
	public String getCustomerEmail() {
		return customerEmail;
	}
	/**
	 * Setter for customerEmail
	 *@param customerEmail is to set customerEmail
	 *
	 */
	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}
	/**
	 * Getter for orderNumber
	 * return orderNumber
	 *
	 */
	public int getOrderNumber() {
		return orderNumber;
	}
	/**
	 * Setter for orderNumber
	 *@param orderNumber is to set orderNumber
	 *
	 */
	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}

	

}
