package com.databases2.rdbms.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBDemo {

	public static void main(String[] args) {
		String JdbcURL = "jdbc:mysql://localhost:3306/restaurant?useSSL=false";
		String Username = "root";
		String password = "Trollinger37";
		Connection con = null;

		try {
			System.out.println("Connecting to database..............." + JdbcURL);
			con = DriverManager.getConnection(JdbcURL, Username, password);
			System.out.println("Connection is successful!!!!!!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
