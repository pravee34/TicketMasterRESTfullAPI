package com.ticket.master.constants;

/**
 * Class holds the constants used in this application.
 * 
 */
public class Constants {
	
	public static final String DATABASE_DDL = "database/ddl.sql";
	
	public static final String DATABASE_DML = "database/dml.sql";
	
	public static final String SQL_QUERY_PROPERTIES = "classpath:database/sql-query.properties";
	
	public static final String COMMON_PROPERTIES = "classpath:common.properties";
	
   public static final String   SELECT_AVAILABLE_SEATS= "select.available.seats"; 
   
   public static final String  FIND_BEST_MATCH_AND_HOLD = "find.best.match.and.hold";
   
   public static final String INSERT_ORDERS_WITH_HOLDSTATUS = "insert.orders.with.holdstatus";
   
   public static final String INSERT_RESERVATION_WITH_HOLD_STATUS= "insert.reservation.with.hold.status";
  
   public static final String UPDATE_HOLD_STATUS_TO_RESERVATION_CONFIRMED= "update.hold.status.to.reservation.confirmed";
	
   public static final int DEFAULT_ROW_COUNT=9;
   
   public static final int DEFAULT_COLUMN_COUNT=34;
   
   public static final int DEFAULT_EVENT_ID=23456;
   
   public static final int DEFAULT_MEMBER_ID=76565;
   
   public static final String DEFAULT_ORDER_STATUS="HOLD";
   
   public static final String DEAFULT_RESERVATIONS_ORDER_ID = "orderId";
   
   public static final String DEAFULT_RESERVATIONS_SECTION_ID = "sectionId";
   
   public static final String DEAFULT_RESERVATIONS_ROW_NUMBER = "rowNumber";
   
   public static final String DEAFULT_RESERVATIONS_SEAT_NUMBER = "seatNumber";
   
   private Constants() {
   }
   
}
