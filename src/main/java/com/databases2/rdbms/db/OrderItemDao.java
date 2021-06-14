package com.databases2.rdbms.db;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import com.databases2.rdbms.model.OrderItem;

public class OrderItemDao implements DAO {

	List<OrderItem> foods = new ArrayList<>();

	private OrderItem createOrderItem(ResultSet rs) {
		try {
			OrderItem order = new OrderItem(rs.getInt("OrderItemId"), 
					rs.getInt("OrderId"),  rs.getInt("ProductId"), rs.getInt("quantity"));

			return order;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;

	}

	public List<OrderItem> getOrderItems() {
		String sql = "SELECT * FROM  order_item";

		try {
			Class.forName(DRIVER);
			Connection con = DriverManager.getConnection(DB_URL, USER, PASS);
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				OrderItem p = createOrderItem(rs);
				foods.add(p);
			}
			rs.close();
			con.close();
		} catch (ClassNotFoundException | SQLException ex) {
		}
		return foods;
	}
	
	public void insertOrderItem(int orderId, int foodId, int quantity) {
		String sql = "INSERT INTO order_item (OrderId, ProductId, quantity) VALUES (?, ?, ?)";

		try {
			Class.forName(DRIVER);
			Connection con = DriverManager.getConnection(DB_URL, USER, PASS);

			PreparedStatement preparedStatment = con.prepareStatement(sql);
			preparedStatment.setInt(1, orderId);
			preparedStatment.setInt(2, foodId);
			preparedStatment.setInt(3, quantity);
			
			System.out.println(preparedStatment.toString());

			preparedStatment.executeUpdate();
			System.out.println(preparedStatment);

		} catch (ClassNotFoundException |

				SQLException e) {
			e.printStackTrace();
		}

	}


}
