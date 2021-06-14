package com.databases2.rdbms.controller;

import java.awt.Button;
import java.util.List;

import com.databases2.rdbms.db.FoodItemDao;
import com.databases2.rdbms.model.FoodItem;
import com.jfoenix.utils.JFXUtilities;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class RestaurantApplicationController extends AbstractController<BorderPane> {

	@FXML
	private TabPane rootTabPane;

	
	
	@Inject
	private ApplicationContext applicationContext;

	
	@FXML
	private void initialize() {
		
	}
	
	@PostConstruct
	private void postConstruct() {
	}
	
	private <T extends AbstractController<AnchorPane>> void setActiveControllerInTabPane(Class<T> controllerClass,
			String name) {
		Tab newTab = getTab(name);

		T newController = applicationContext.getBean(controllerClass);
		AnchorPane controllerPane = newController.getRoot();

		if (newTab == null) {
			newTab = new Tab(name, controllerPane);

			rootTabPane.getTabs().add(newTab);
			rootTabPane.getSelectionModel().select(newTab);
		}

	}
	
	

	private Tab getTab(String tabName) {
		return rootTabPane.getTabs().stream().filter(tab -> tab.getText().equals(tabName)).findFirst().orElse(null);

	}

	@FXML
	private void customerButtonOnAction() {
		showCustomerControler();

	}

	public void showCustomerControler() {
		setActiveControllerInTabPane(CustomerController.class, "Customers");
	}


}
