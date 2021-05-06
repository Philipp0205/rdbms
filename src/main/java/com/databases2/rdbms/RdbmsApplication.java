package com.databases2.rdbms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

@SpringBootApplication
public class RdbmsApplication extends Application {

	public static void main(String[] args) {
		SpringApplication.run(RdbmsApplication.class, args);
		launch(args);

	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(this.getClass().getClassLoader().getResource("mainwindow.fxml"));
		
		Scene scene = new Scene(root, 800, 600);
		primaryStage.setTitle("Database Project");
		primaryStage.setScene(scene);

		primaryStage.show();
	}
}
