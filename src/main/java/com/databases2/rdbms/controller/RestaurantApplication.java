package com.databases2.rdbms.controller;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

@SpringBootApplication
public class RestaurantApplication implements CommandLineRunner {
	private static Stage primaryStage;


	
	@Autowired
	private LoginController loginController;

	@Autowired
	private RestaurantApplicationController applicationController;

	@Bean
	public Stage getPrimaryStage() {
		return primaryStage;
	}

	
	@Override
	public void run(String... args) {
		 Scene scene = new Scene(this.loginController.getRoot(), 1200, 600);

		primaryStage.setScene(scene);
		primaryStage.show();
		
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.register(ControllerConfiguration.class);
		ctx.refresh();
	}

	public static void setPrimaryStage(Stage primarystage) {
		RestaurantApplication.primaryStage = primarystage;
	}

	

	public void showMainWindow() {
		Scene scene = new Scene(applicationController.getRoot(), 1200, 700);

		primaryStage.setScene(scene);
		primaryStage.show();
	}
	

	
	

}
