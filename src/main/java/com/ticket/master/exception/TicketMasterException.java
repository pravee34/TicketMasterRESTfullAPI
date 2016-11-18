package com.ticket.master.exception;

public class TicketMasterException extends Exception {

	private static final long serialVersionUID = -260099562201568792L;

	private final String message;

	/**
	 * Creates a new {@link ProcessorException} with the specified message and
	 * cause.
	 * 
	 * @param message
	 *            the detail message
	 * @param cause
	 *            the cause.
	 */
	public TicketMasterException(String message, Throwable cause) {
		super(message, cause);
		this.message = message;
	}

	@Override
	public String getMessage() {
		return message;
	}
}
