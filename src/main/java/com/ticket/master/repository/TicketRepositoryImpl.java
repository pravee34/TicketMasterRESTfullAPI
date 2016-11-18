package com.ticket.master.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.jdbc.support.GeneratedKeyHolder;

import com.ticket.master.entities.AvailableSeats;
import com.ticket.master.entities.BestAvailableSeats;
import com.ticket.master.entities.Orders;
import com.ticket.master.entities.SeatHold;
import com.ticket.master.util.BestAvailableList;
import com.ticket.master.util.HoldingTheSeatsForMember;
import com.ticket.master.util.ListofReserveSeats;
import com.ticket.master.util.MemberOrderhold;
import com.ticket.master.util.PossibleCombination;
/**
 * 
 * TicketReservationImpl is an implementation for TicketRepository
 * 
 */
public class TicketRepositoryImpl extends NamedParameterJdbcDaoSupport implements TicketRepository {

	private final String selectAvailableSeats;
	private final String findBestMatchandHold;
	private final String insertOrdersWithHoldStatus;
	private final String insertReservationWithHoldStatus;
	private final String updateHoldStatusToReservationConfirmed;

	public TicketRepositoryImpl(String selectAvailableSeats, String findBestMatchandHold,
			String insertOrdersWithHoldStatus, String insertReservationWithHoldStatus,
			String updateHoldStatusToReservationConfirmed) {
		this.selectAvailableSeats = selectAvailableSeats;
		this.findBestMatchandHold = findBestMatchandHold;
		this.insertOrdersWithHoldStatus = insertOrdersWithHoldStatus;
		this.insertReservationWithHoldStatus = insertReservationWithHoldStatus;
		this.updateHoldStatusToReservationConfirmed = updateHoldStatusToReservationConfirmed;
	}
	/**
	 * 
	 * Finds the number of available seats 
	 * @return number of available seats
	 * 
	 */
	@Override
	public int findAvailableSeats() {
		int numberOfAvailableSeats = 0;
		try {
			List<AvailableSeats> totalSeatsAvailable = getJdbcTemplate().query(selectAvailableSeats, null, null,
					new AvailableSeatsRowMapper());
			if (totalSeatsAvailable != null && !totalSeatsAvailable.isEmpty()) {
				numberOfAvailableSeats = totalSeatsAvailable.get(0).getAvailableSeats();
			}
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return numberOfAvailableSeats;
	}
	/**
	 * 
	 * Find and hold best available seats
	 * finding seats is based on venue designed. 
	 * the searching algorithm can be much better if we design the
	 *            previously selected rows and seats by the customer,
	 *            also distance to the parking and the direction that he
	 *            is traveling from home.
	 *            **I have not implemented all my thoughts because, this
	 *            is not the requirement for this homework but wanted to specify
	 *            my thoughts.
	 * @return a list with combination of possible rows and seat number
	 * 
	 */
	@Override
	public SeatHold findSeatBestAvailableSeatsAndHold(int numSeats, String customerEmail) {

		try {

			// extract the data from database
			List<BestAvailableSeats> baslist = getJdbcTemplate().query(findBestMatchandHold, null, null,
					new SeatsReservedRowMapper());            

			/**
			 * @return a list with combination of possible rows and seat number,which is reserved already
			 * 
			 */
			List<String> holdSeats = ListofReserveSeats.ListofReserverSeatsByRowNumberAndSeatNumber(baslist);
			/**
			 * 
			 * @return list with combination of possible rows and seat number of all seats
			 * 
			 */
			List<String> allSeats = PossibleCombination.PossibleCombinationOfAvailableSeatsTable(baslist);

			/**
			 * compares holdseats with allseats
			 * @return a Best available list with combination of possible rows and seat number
			 * 
			 */
			allSeats = BestAvailableList.CompareAndGetBestMachedSeatNumberAndRownumberforMember(holdSeats, allSeats);

			/**
			 * 
			 * @return Orders object          
			 */		
			Orders ord = MemberOrderhold.MemberInformationNeededToPlaceOnholdONBehalfOfCustomer();

			/**
			 * @param 
			 *  Generate key hold to get the order number from the Order Sequence
			  */		
			GeneratedKeyHolder generatedKeyHolder = new GeneratedKeyHolder();
			
			getNamedParameterJdbcTemplate().update(insertOrdersWithHoldStatus, new BeanPropertySqlParameterSource(ord),generatedKeyHolder);

			/**
			 * 
			 * Process to create the reservation records based on the qty requested 
			  
			 */				
			for (int qty = 0; qty < numSeats; qty++) {				
				final Map<String, Object> reservations = HoldingTheSeatsForMember.SeatsHoldforMemberBasedOnTheOrderCreated(generatedKeyHolder,allSeats,qty);
				getNamedParameterJdbcTemplate().update(insertReservationWithHoldStatus, reservations);
			}			
			SeatHold seathold = new SeatHold();			
			seathold.setOrderNumber(generatedKeyHolder.getKey().intValue());
			seathold.setCustomerEmail(customerEmail);
			seathold.setNumSeats(numSeats);			
			return seathold;
		} catch (DataAccessException e) {
			e.printStackTrace();
			return null;
		}
	}
	/**
	 * 
	 * confirm the reservations based on order id (or) hold id  
	 */	
	@Override
	public void confirmReservations(SeatHold seatHold) {
		final Map<String, Object> params = new HashMap<>(2);
		params.put("orderId", seatHold.getOrderNumber());
		try {
			getNamedParameterJdbcTemplate().update(updateHoldStatusToReservationConfirmed, params);
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
	}
}
