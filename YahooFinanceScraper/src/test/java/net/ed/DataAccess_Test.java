package net.ed;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

public class DataAccess_Test {

	@Test
	public void connectToDB() throws Exception {
		try {
			Class.forName("net.ed.jdbc.Driver");
			
			// setup connection with DB YahooScraperMySQLConnection
			String connectionString = "jdbc:mysql://localhost:3306/YahooScraper";
			Connection connect = DriverManager.getConnection(connectionString);

		} catch (Exception e) {
			throw e;
		}
	}
}
