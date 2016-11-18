package com.ticket.master.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import com.ticket.master.repository.TicketRepository;
import com.ticket.master.service.TicketService;
import com.ticket.master.service.TicketServiceImpl;
/**
 * 
 * Bootstrapping @Configuration 
 * 
 */
@Configuration
public class ServiceConfiguration {

	@Bean
	public TicketService ticketService(final TicketRepository ticketRepository, final Environment environment) {
		return new TicketServiceImpl(ticketRepository,
				environment.getProperty("seat.hold.expiration.seconds", Integer.class));
	}

}
