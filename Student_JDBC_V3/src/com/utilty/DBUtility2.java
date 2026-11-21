package com.utilty;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtility2{
	private static String url;
	private static String driverClass;
	private static String username;
	private static String password;

	static {
		try (FileInputStream fileInputStream = new FileInputStream("db.properties")) {

			if (fileInputStream == null) {
				System.err.println("FILE NOT FOUND  " + "db.properties");
				throw new RuntimeException("File Not Found");
			}

			Properties properties = new Properties();
			properties.load(fileInputStream);
			url = properties.getProperty("db.url");
			driverClass = properties.getProperty("db.driver_class");
			username = properties.getProperty("db.username");
			password = properties.getProperty("db.password");

		} catch (Exception e) {
			System.out.println("---->  " + e);
		}

	}

	public static Connection getDBConnection() {
		Connection con = null;

		try {
			Class.forName(driverClass);
			con = DriverManager.getConnection(url, username, password);

		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("--->" + e);
		}
		return con;
	}

}