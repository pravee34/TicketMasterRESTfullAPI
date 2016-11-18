package com.ticket.master.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ticket.master.constants.TicketTableColumn;
import com.ticket.master.entities.BestAvailableSeats;
/**
 * SeatsReservedRowMapper implements RowMapper interface for mapping rows of a ResultSet
 * It maps each row to a result object  
 *
 */
public class SeatsReservedRowMapper implements RowMapper<BestAvailableSeats> {
	@Override
	public BestAvailableSeats mapRow(ResultSet rs, int rowNum) throws SQLException {
		BestAvailableSeats bas = new BestAvailableSeats();
		bas.setRowNumber(rs.getInt(TicketTableColumn.ROW_NUMBER.name()));
		bas.setSeatNumber(rs.getInt(TicketTableColumn.SEAT_NUMBER.name()));
		bas.setMemberId(rs.getInt(TicketTableColumn.MEMBER_ID.name()));
		bas.setEventId(rs.getInt(TicketTableColumn.EVENT_ID.name()));
		bas.setRowCount(rs.getInt(TicketTableColumn.ROW_COUNT.name()));
		bas.setColumnCount(rs.getInt(TicketTableColumn.COLUMN_COUNT.name()));
		bas.setEmailAddress(rs.getString(TicketTableColumn.EMAIL_ADDRESS.name()));
		return bas;
	}
}
