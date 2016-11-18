package com.ticket.master.entities;

import java.util.Date;
/**
 * Orders entity 
 *
 */
public class Orders {
	private int orderId;
	private int eventId;
	private int memberId;
	private String orderStatus;
	private Date orderDate;
	/**
	 * Getter for orderId
	 * return orderId
	 *
	 */
	public int getOrderId() {
		return orderId;
	}
	/**
	 * Setter for orderId
	 *@param orderId is to set orderId
	 *
	 */
	public void setOrderId(int orderId) {
		this.orderId = orderId;
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
	 * Setter for eventId
	 *@param eventId is to set eventId
	 *
	 */
	public void setEventId(int eventId) {
		this.eventId = eventId;
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
	 * Setter for memberId
	 *@param memberId is to set memberId
	 *
	 */
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
	/**
	 * Getter for orderStatus
	 * return orderStatus
	 *
	 */
	public String getOrderStatus() {
		return orderStatus;
	}
	/**
	 * Setter for orderStatus
	 *@param orderStatus is to set orderStatus
	 *
	 */
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	/**
	 * Getter for orderDate
	 * return orderDate
	 *
	 */
	public Date getOrderDate() {
		return orderDate;
	}
	/**
	 * Setter for orderDate
	 *@param orderDate is to set orderDate
	 *
	 */
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
}
