package com.databases2.rdbms.controller;

import org.springframework.beans.factory.annotation.Autowired;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import javafx.fxml.FXML;
import javafx.scene.layout.BorderPane;

public class LoginController extends AbstractController<BorderPane> {
	
	@FXML
	private JFXTextField usernameField;
	@FXML
	private JFXPasswordField passwordField;
	@FXML
	private JFXButton loginButton;
	
	@Autowired
	private RestaurantApplication application;
	
	@FXML
	private void loginButtonOnAction() {
		application.showMainWindow();
	}
}
