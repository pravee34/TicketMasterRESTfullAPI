package com.ticket.master.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.ticket.master.constants.Constants;
/**
 * 
 * Bootstrapping @Configuration
 * 
 */
@Configuration
@PropertySource({ Constants.SQL_QUERY_PROPERTIES, Constants.COMMON_PROPERTIES })
public class PropertyConfiguration {
}