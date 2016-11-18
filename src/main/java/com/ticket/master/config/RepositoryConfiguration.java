package com.ticket.master.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import com.ticket.master.constants.Constants;
import com.ticket.master.repository.TicketRepository;
import com.ticket.master.repository.TicketRepositoryImpl;

import javax.sql.DataSource;
/**
 * 
 * Bootstrapping @Configuration and this environments define the SQL mapping
 * 
 */
@Configuration
public class RepositoryConfiguration {

	@Bean
	public TicketRepository ticketRepository(final DataSource dataSource, final Environment environment) {
		final TicketRepositoryImpl ticketRepository = new TicketRepositoryImpl(
				environment.getProperty(Constants.SELECT_AVAILABLE_SEATS), 
				environment.getProperty(Constants.FIND_BEST_MATCH_AND_HOLD),
				environment.getProperty(Constants.INSERT_ORDERS_WITH_HOLDSTATUS),
				environment.getProperty(Constants.INSERT_RESERVATION_WITH_HOLD_STATUS),
				environment.getProperty(Constants.UPDATE_HOLD_STATUS_TO_RESERVATION_CONFIRMED));
		ticketRepository.setDataSource(dataSource);
		return ticketRepository;
	}
}
