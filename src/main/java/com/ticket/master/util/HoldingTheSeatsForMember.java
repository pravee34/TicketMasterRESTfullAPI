package com.ticket.master.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.support.GeneratedKeyHolder;

import com.ticket.master.constants.Constants;

public class HoldingTheSeatsForMember {
	/**
	 * 
	 * @param orders
	 *            list of values to place an order
	 * @return orders object
	 * 
	 */
	public static Map<String, Object>SeatsHoldforMemberBasedOnTheOrderCreated(GeneratedKeyHolder generatedKeyHolder,List<String> allSeats, int qty) {
		final Map<String, Object> reservations = new HashMap<>(2);
		reservations.put(Constants.DEAFULT_RESERVATIONS_ORDER_ID, generatedKeyHolder.getKey().intValue());
		reservations.put(Constants.DEAFULT_RESERVATIONS_SECTION_ID, 53456);
		reservations.put(Constants.DEAFULT_RESERVATIONS_ROW_NUMBER, Integer.valueOf(allSeats.get(qty).substring(0, 1)));
		reservations.put(Constants.DEAFULT_RESERVATIONS_SEAT_NUMBER,Integer.valueOf(allSeats.get(qty).substring(1, allSeats.get(qty).length())));
		return reservations;
	}

}
