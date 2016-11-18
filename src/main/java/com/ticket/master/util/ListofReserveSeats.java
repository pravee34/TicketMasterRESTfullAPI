package com.ticket.master.util;

import java.util.ArrayList;
import java.util.List;

import com.ticket.master.entities.BestAvailableSeats;

public class ListofReserveSeats {
	/**
	 * 
	 * @param baslist
	 *            All ready Reserved Seats or Hold but expire 
	 * @return a combine list of rows and seat number
	 * 
	 */
	public static List<String> ListofReserverSeatsByRowNumberAndSeatNumber(List<BestAvailableSeats> baslist) {

		List<String> reservedseats = new ArrayList<String>();
		
		if (baslist != null && !baslist.isEmpty()) {
			for (int i = 0; i < baslist.size(); i++) {
				
				String holdSeatDetails = Integer.toString(baslist.get(i).getRowNumber())
						+ Integer.toString(baslist.get(i).getSeatNumber());		
				reservedseats.add(holdSeatDetails);
			}
		}
		return reservedseats;
	}

}
