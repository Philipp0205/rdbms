package com.databases2.rdbms.db;

import java.util.List;
import java.util.ArrayList;
import java.awt.print.Printable;
import java.sql.*;

import com.databases2.rdbms.model.FoodItem;
import com.databases2.rdbms.model.OrderModel;

public class OrderDao implements DAO {
	OrderItemDao orderItemDao = new OrderItemDao();

	private OrderModel createOrder(ResultSet rs) {
		try {
			OrderModel order = new OrderModel(rs.getInt("OrderId"), rs.getString("OrderType"), rs.getInt("CustomerId"));

			return order;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;

	}

	public List<OrderModel> getOrders() {
		String sql = "SELECT * FROM  customer_order";
		List<OrderModel> orders = new ArrayList<>();

		try {
			Class.forName(DRIVER);
			Connection con = DriverManager.getConnection(DB_URL, USER, PASS);
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				OrderModel order = createOrder(rs);
				orders.add(order);
			}
			rs.close();
			con.close();
		} catch (ClassNotFoundException | SQLException ex) {
		}
		return orders;
	}

	public void insertOrder(int customerId, String orderType, List<FoodItem> selectedFoods) {
		String sql = "INSERT INTO customer_order (OrderType, CustomerId) VALUES (?, ?)";
		ResultSet rs = null;

		try {
			Class.forName(DRIVER);
			Connection con = DriverManager.getConnection(DB_URL, USER, PASS);

			PreparedStatement preparedStatment = con.prepareStatement(sql);
			preparedStatment.setString(1, orderType);
			preparedStatment.setInt(2, customerId);

			preparedStatment.executeUpdate();
			System.out.println(preparedStatment);

		} catch (ClassNotFoundException |

				SQLException e) {
			e.printStackTrace();
		}

		OrderModel latestOrder = getLatestOrder();
		selectedFoods.forEach(food -> orderItemDao.insertOrderItem(Integer.parseInt(latestOrder.getId()),
				Integer.parseInt(food.getId()), Integer.parseInt(food.getAmount())));
	}

	public void delteOrder(String orderId) {
		String sql = "DELETE FROM customer_order WHERE OrderId=" + orderId;

		try {
			Class.forName(DRIVER);
			Connection con = DriverManager.getConnection(DB_URL, USER, PASS);
			Statement stmt = con.createStatement();
			System.out.println(sql);
			stmt.executeUpdate(sql);
		} catch (ClassNotFoundException | SQLException ex) {
			ex.printStackTrace();
		}

	}

	public OrderModel getLatestOrder() {
		String sql = "SELECT * FROM customer_order ORDER BY OrderId DESC LIMIT 1;";

		try {
			Class.forName(DRIVER);
			Connection con = DriverManager.getConnection(DB_URL, USER, PASS);
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			OrderModel order = null;
			while (rs.next()) {
				order = createOrder(rs);
			}
			rs.close();
			con.close();
			return order;


		} catch (ClassNotFoundException | SQLException ex) {
		}
		
		return null;
	}

}
