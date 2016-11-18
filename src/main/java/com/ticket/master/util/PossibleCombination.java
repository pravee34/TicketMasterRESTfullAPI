package com.ticket.master.util;

import java.util.ArrayList;
import java.util.List;

import com.ticket.master.constants.Constants;
import com.ticket.master.entities.BestAvailableSeats;

public class PossibleCombination {
	private static int rowCount = 0;
	private static int columnCount = 0;
	/**
	 * 
	 * @param baslist
	 *            List of seats already reserved.
	 * @return a list with combination of possible rows
	 * 
	 */
	public static List<String> PossibleCombinationOfAvailableSeatsTable(List<BestAvailableSeats> baslist) {
		
		List<String> allSeats = new ArrayList<String>();
		
		if (baslist != null && !baslist.isEmpty()) {			

			//row counts information
			if (baslist.get(0).getRowCount() <= 0) {
				rowCount = Constants.DEFAULT_ROW_COUNT;
			} else {
				rowCount = baslist.get(0).getRowCount();
			}
			// Column count
			if (baslist.get(0).getColumnCount() <= 0) {
				columnCount = Constants.DEFAULT_COLUMN_COUNT;
			} else {
				columnCount = baslist.get(0).getColumnCount();
			}
			
			for (int i = 1; i <= rowCount; i++) {
				for (int j = 1; j <= columnCount; j++) {
					allSeats.add(Integer.toString(i) + Integer.toString(j));
				}
			}
		}
		return allSeats;
	}
}