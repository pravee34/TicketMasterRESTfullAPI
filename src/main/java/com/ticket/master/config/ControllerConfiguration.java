package com.ticket.master.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ticket.master.controller.TicketController;
import com.ticket.master.service.TicketService;
/**
 * 
 * Bootstrapping @Configuration
 * 
 */
@Configuration
public class ControllerConfiguration {
	@Bean
	public TicketController ticketController(final TicketService ticketService) {
		return new TicketController(ticketService);
	}

}
