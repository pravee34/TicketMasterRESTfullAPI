package com.ticket.master.util;

import java.util.List;

public class BestAvailableList {
	/**
	 * 
	 * @param baslist
	 * List of hold seats 
	 * @return list returns the best available seats
	 * 
	 */
	public static List<String> CompareAndGetBestMachedSeatNumberAndRownumberforMember(List<String> holdSeats,List<String> allSeats) {

		if (holdSeats != null && !holdSeats.isEmpty()) {
			for (String seatNumber : holdSeats) {
				if (allSeats.contains(seatNumber)) {
					allSeats.remove(seatNumber);
				}
			}
		}
		return allSeats;
	}

}
