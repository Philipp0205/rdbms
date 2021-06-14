package com.databases2.rdbms.controller;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import com.databases2.rdbms.db.CustomerDao;
import com.databases2.rdbms.db.FoodItemDao;
import com.databases2.rdbms.db.OrderDao;
import com.databases2.rdbms.db.OrderItemDao;
import com.databases2.rdbms.model.Customer;
import com.databases2.rdbms.model.FoodItem;
import com.databases2.rdbms.model.OrderItem;
import com.databases2.rdbms.model.OrderModel;
import com.jfoenix.controls.JFXTextField;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

public class CustomerController extends AbstractController<AnchorPane> {

	@FXML
	private TableView<Customer> customerTableView;
	@FXML
	private TableColumn<Customer, String> customerIdCol;
	@FXML
	private TableColumn<Customer, String> customerNameCol;
	@FXML
	private TableColumn<Customer, String> customerPhoneCol;
	@FXML
	private TableColumn<Customer, String> customerFeedbackCol;

	@FXML
	private TableView<FoodItem> foodTableView;
	@FXML
	private TableView<FoodItem> selectedFoodTableView;

	@FXML
	private TableColumn<FoodItem, String> foodIdCol;
	@FXML
	private TableColumn<FoodItem, String> foodNameCol;
	@FXML
	private TableColumn<FoodItem, String> foodPriceCol;

	@FXML
	private TableColumn<FoodItem, String> selectedFoodIdCol;
	@FXML
	private TableColumn<FoodItem, String> selectedFoodNameCol;
	@FXML
	private TableColumn<FoodItem, String> selectedFoodPriceCol;
	@FXML
	private TableColumn<FoodItem, String> selectedFoodAmountCol;

	@FXML
	private TableView<OrderModel> orderTableView;
	@FXML
	private TableColumn<OrderModel, String> orderIdCol;
	@FXML
	private TableColumn<OrderModel, String> customerOrderIdCol;
	@FXML
	private TableColumn<OrderModel, String> orderTypeCol;
	
	@FXML
	private JFXTextField amountTextField;


	CustomerDao customerDao = new CustomerDao();
	ObservableList<Customer> customerList = FXCollections.observableArrayList();

	FoodItemDao foodItemDao = new FoodItemDao();

	ObservableList<FoodItem> foodList = FXCollections.observableArrayList();
	ObservableList<FoodItem> selectedFoodList = FXCollections.observableArrayList();

	OrderDao orderDao = new OrderDao();
	OrderItemDao orderItemDao = new OrderItemDao();
	ObservableList<OrderModel> orderList = FXCollections.observableArrayList();

	@FXML
	private void initialize() {
		customerIdCol.setCellValueFactory(new PropertyValueFactory<Customer, String>("id"));
		customerNameCol.setCellValueFactory(new PropertyValueFactory<Customer, String>("name"));
		customerPhoneCol.setCellValueFactory(new PropertyValueFactory<Customer, String>("phone"));
		customerFeedbackCol.setCellValueFactory(new PropertyValueFactory<Customer, String>("feedback"));

		customerList.addAll(customerDao.getCustomers());
		customerTableView.setItems(customerList);

		foodIdCol.setCellValueFactory(new PropertyValueFactory<FoodItem, String>("id"));
		foodNameCol.setCellValueFactory(new PropertyValueFactory<FoodItem, String>("name"));
		foodPriceCol.setCellValueFactory(new PropertyValueFactory<FoodItem, String>("price"));

		selectedFoodIdCol.setCellValueFactory(new PropertyValueFactory<FoodItem, String>("id"));
		selectedFoodNameCol.setCellValueFactory(new PropertyValueFactory<FoodItem, String>("name"));
		selectedFoodPriceCol.setCellValueFactory(new PropertyValueFactory<FoodItem, String>("price"));
		selectedFoodAmountCol.setCellValueFactory(new PropertyValueFactory<FoodItem, String>("amount"));
		

		orderIdCol.setCellValueFactory(new PropertyValueFactory<OrderModel, String>("id"));
		customerOrderIdCol.setCellValueFactory(new PropertyValueFactory<OrderModel, String>("customerId"));
		orderTypeCol.setCellValueFactory(new PropertyValueFactory<OrderModel, String>("orderType"));

		foodList.addAll(foodItemDao.getFoods());
		orderList.addAll(orderDao.getOrders());

		foodTableView.setItems(foodList);
		selectedFoodTableView.setItems(selectedFoodList);
		orderTableView.setItems(orderList);
	}

	@FXML
	private void backButtonOnAction() {

	}

	@FXML
	private void selectButtonOnAction() {
		FoodItem selectedItem = foodTableView.getSelectionModel().getSelectedItem();
		String amount = amountTextField.getText();
		
		if (amount == null) {
			amount = "1";
		}
		selectedItem.setAmount(amountTextField.getText());
		selectedFoodList.add(selectedItem);
		foodList.remove(selectedItem);
		

	}

	@FXML
	private void deselectButtonOnAction() {
		FoodItem selectedItem = selectedFoodTableView.getSelectionModel().getSelectedItem();
		selectedFoodList.remove(selectedItem);
		foodList.add(selectedItem);
	}

	@FXML
	private void checkoutButtonOnAction() {
		List<FoodItem> selectedFoods = selectedFoodTableView.getItems();
		Customer selectedCustomer = customerTableView.getSelectionModel().getSelectedItem();

		orderDao.insertOrder(Integer.parseInt(selectedCustomer.getId()), "Test", selectedFoods);
		
		
		orderList.clear();
		orderList.addAll(orderDao.getOrders());

	}

	@FXML
	private void updateTableButtonOnAction() {
		orderList.clear();
		orderList.addAll(orderDao.getOrders());
		
	}

	@FXML
	private void deleteOrderButtonOnAction() {
		OrderModel selectedOrder = orderTableView.getSelectionModel().getSelectedItem();
		orderDao.delteOrder(selectedOrder.getId());

		orderList.remove(selectedOrder);

	}

}
