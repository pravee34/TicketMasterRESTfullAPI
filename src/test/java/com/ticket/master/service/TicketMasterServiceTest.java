package com.ticket.master.service;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ticket.master.config.ControllerConfiguration;
import com.ticket.master.config.EmbeddedDataSourceConfigurationTest;
import com.ticket.master.config.PropertyConfiguration;
import com.ticket.master.config.RepositoryConfiguration;
import com.ticket.master.config.ServiceConfiguration;
import com.ticket.master.entities.SeatHold;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { ControllerConfiguration.class, EmbeddedDataSourceConfigurationTest.class,
		PropertyConfiguration.class, RepositoryConfiguration.class, ServiceConfiguration.class })
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class TicketMasterServiceTest {

	private static final int NUMBER_OF_SEATS_AVAILABLE = 304;
	private static int orderNumber = 0;
	private final static String CUSTOMER_EMAIL = "test@gmail.com";
	@Autowired
	private TicketService ticketService;

	// Positive test case
	@Test
	public void testNumSeatsAvailable() {
		final int numSeatsAvailable = ticketService.numSeatsAvailable();
		assertEquals(NUMBER_OF_SEATS_AVAILABLE, numSeatsAvailable);
	}

	// Negative test case
	@Test
	public void negativetestForNumSeatsAvailable() {
		final int numSeatsAvailable = ticketService.numSeatsAvailable();
		Assert.assertTrue(NUMBER_OF_SEATS_AVAILABLE == numSeatsAvailable);
	}

	@Test
	public void testFindAndHoldSeats() {
		SeatHold seathold = ticketService.findAndHoldSeats(5, CUSTOMER_EMAIL);
		Assert.assertNotNull(seathold);
		orderNumber = seathold.getOrderNumber();
		Assert.assertTrue(orderNumber > 0);
	}

	@Test
	public void negativetestFindAndHoldSeats() {
		SeatHold seathold = ticketService.findAndHoldSeats(0, null);
		Assert.assertNull(seathold);
	}

	@Test
	public void testReserveSeats() {
		SeatHold seatHold = new SeatHold();
		seatHold.setOrderNumber(orderNumber);
		seatHold.setCustomerEmail(CUSTOMER_EMAIL);
		SeatHold seathold = ticketService.reserveSeats(seatHold);
		Assert.assertNotNull(seathold);

	}
	@Test
	public void negaticetestReserveSeats() {
		SeatHold seatHold = new SeatHold();
		seatHold.setOrderNumber(0);
		seatHold.setCustomerEmail(null);
		SeatHold seathold = ticketService.reserveSeats(seatHold);
		Assert.assertNull(seathold);
	}
}
