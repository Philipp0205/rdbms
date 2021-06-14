package com.databases2.rdbms.db;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import com.databases2.rdbms.model.FoodItem;

public class FoodItemDao implements DAO {
	List<FoodItem> foods = new ArrayList<>();

	private FoodItem createFoodItem(ResultSet rs) {
		FoodItem foodItem = new FoodItem();
		try {
			foodItem.setId(rs.getString("ITEM_ID"));
			foodItem.setName(rs.getString("ITEM_NAME"));
			foodItem.setPrice(rs.getString("PRICE"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return foodItem;
	}

	public List<FoodItem> getFoods() {
		String sql = "SELECT * FROM  FOOD_MENU";

		try {
			Class.forName(DRIVER);
			Connection con = DriverManager.getConnection(DB_URL, USER, PASS);
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				FoodItem p = createFoodItem(rs);
				foods.add(p);
			}
			rs.close();
			con.close();
		} catch (ClassNotFoundException | SQLException ex) {
		}
		return foods;
	}

}
