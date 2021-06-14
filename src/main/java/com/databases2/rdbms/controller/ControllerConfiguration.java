package com.databases2.rdbms.controller;

import java.io.IOException;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Configuration
public class ControllerConfiguration  extends AbstractFxmlConfiguration {
	@Bean
	@Lazy
	public RestaurantApplicationController restaurantApplicationController() throws IOException {
		return loadController(RestaurantApplicationController.class);
	}
	
	@Bean
	@Lazy
	public LoginController logincontroller() throws IOException {
		return loadController(LoginController.class);
	}
	
	@Bean
	@Lazy
	public CustomerController customerController() throws IOException {
		return loadController(CustomerController.class);
	}
	
	
	
	

}
