package com.ticket.master.config;


import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.ticket.master.constants.Constants;
/**
 * 
 * Bootstrapping @Configuration
 * 
 */
@Configuration
@EnableTransactionManagement
public class EmbeddedDataSourceConfigurationTest {

	@Bean
	public JdbcTemplate jdbcTemplate(final DataSource dataSource) {
		return new JdbcTemplate(dataSource);
	}

	@Bean
	public DataSource dataSource() {
		return new EmbeddedDatabaseBuilder().addScripts(Constants.DATABASE_DDL,Constants.DATABASE_DML).build();
	}

	@Bean
	public PlatformTransactionManager transactionManager(final DataSource dataSource) {
		return new DataSourceTransactionManager(dataSource);
	}
}
