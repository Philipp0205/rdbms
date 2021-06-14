package com.databases2.rdbms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import com.databases2.rdbms.controller.LoginController;
import com.databases2.rdbms.controller.RestaurantApplication;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

@SpringBootApplication
public class Main extends Application {
	
	private static final int WINDOW_WIDTH = 2000;
	private static final int WINDOW_HEIGHT = 1300;

	public static void main(String[] args) {
		launch(args);

	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		RestaurantApplication.setPrimaryStage(primaryStage);
		new SpringApplicationBuilder(RestaurantApplication.class).run();

	}
}
