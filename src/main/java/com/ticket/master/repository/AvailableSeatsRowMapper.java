package com.ticket.master.repository;

import org.springframework.jdbc.core.RowMapper;

import com.ticket.master.constants.TicketTableColumn;
import com.ticket.master.entities.AvailableSeats;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * AvailableseatsRowMapper implements RowMapper interface for mapping rows of a ResultSet
 * It maps each row to a result object 
 *  
 *
 */
public class AvailableSeatsRowMapper implements RowMapper<AvailableSeats> {
	@Override
	public AvailableSeats mapRow(ResultSet rs, int rowNum) throws SQLException {
		AvailableSeats as = new AvailableSeats();
		as.setAvailableSeats(rs.getInt(TicketTableColumn.AVAILABLE_SEATS.name()));
		return as;
	}
}