package com.ticket.master.entities;
/**
 * Best Available Seats entity and this is used for /hold instance
 *
 */
public class BestAvailableSeats {
	private int rowNumber;
	private int seatNumber;
	private int memberId;
	private int eventId;
	private int rowCount;
	private int columnCount;
	private String emailAddress;

	/**
	 * Setter for rowNumber
	 *@param rowNumber is to set rowNumber
	 *
	 */
	public void setRowNumber(int rowNumber) {
		this.rowNumber = rowNumber;
	}
	/**
	 * Getter for rowNumber
	 * return rowNumber
	 *
	 */
	public int getRowNumber() {
		return rowNumber;
	}

	/**
	 * Setter for seatNumber
	 *@param seatNumber is to set seatNumber
	 *
	 */
	public void setSeatNumber(int seatNumber) {
		this.seatNumber = seatNumber;
	}
	/**
	 * Getter for seatNumber
	 * return seatNumber
	 *
	 */
	public int getSeatNumber() {
		return seatNumber;
	}

	/**
	 * Setter for memberId
	 *@param AvailableSeats is to set memberId
	 *
	 */
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
	/**
	 * Getter for memberId
	 * return memberId
	 *
	 */
	public int getMemberId() {
		return memberId;
	}

	/**
	 * Setter for eventId
	 *@param eventId is to set eventId
	 *
	 */
	public void setEventId(int eventId) {
		this.eventId = eventId;
	}
	/**
	 * Getter for eventId
	 * return eventId
	 *
	 */
	public int getEventId() {
		return eventId;
	}

	/**
	 * Setter for rowCount
	 *@param rowCount is to set rowCount
	 *
	 */
	public void setRowCount(int rowCount) {
		this.rowCount = rowCount;
	}
	/**
	 * Getter for rowCount
	 * return rowCount
	 *
	 */
	public int getRowCount() {
		return rowCount;
	}

	/**
	 * Setter for columnCount
	 *@param columnCount is to set columnCount
	 *
	 */
	public void setColumnCount(int columnCount) {
		this.columnCount = columnCount;
	}
	/**
	 * Getter for columnCount
	 * return columnCount
	 *
	 */
	public int getColumnCount() {
		return columnCount;
	}

	/**
	 * Setter for emailAddress
	 *@param emailAddress is to set emailAddress
	 *
	 */
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	/**
	 * Getter for emailAddress
	 * return emailAddress
	 *
	 */
	public String getEmailAddress() {
		return emailAddress;
	}

}
