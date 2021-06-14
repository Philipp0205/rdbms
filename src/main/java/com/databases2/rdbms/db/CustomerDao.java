package com.databases2.rdbms.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.databases2.rdbms.model.Customer;

public class CustomerDao implements DAO {
	List<Customer> customers = new ArrayList<>();

	private Customer createCustomer(ResultSet rs) {
		try {
			Customer customer = new Customer(rs.getInt("CustomerId"), rs.getString("NAME"),
					rs.getString("PHONE"), rs.getString("FEEDBACK"));

			return customer;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;

	}

	public List<Customer> getCustomers() {
		String sql = "SELECT * FROM customer";

		try {
			Class.forName(DRIVER);
			Connection con = DriverManager.getConnection(DB_URL, USER, PASS);
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Customer p = createCustomer(rs);
				customers.add(p);
			}
			rs.close();
			con.close();
		} catch (ClassNotFoundException | SQLException ex) {
		}
		return customers;

	}

}
