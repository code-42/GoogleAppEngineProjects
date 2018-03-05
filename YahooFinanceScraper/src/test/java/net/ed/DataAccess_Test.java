package net.ed;

import java.sql.*;

import org.testng.annotations.Test;

import static org.testng.Assert.*;
import org.testng.annotations.*;

public class DataAccess_Test {
	
	Connection connect = null;
	Statement statement = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;

	@Test(priority = 1)
	public void connectToDB_Test() throws Exception {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			// setup connection with DB YahooScraperMySQLConnection
			String connectionString = "jdbc:mysql://localhost:3306/YahooScraper";
			connect = DriverManager.getConnection(connectionString, "yahoo", "yahoo");
			System.out.print("25. connect.toString() == ");
			System.out.println(connect.toString());
		} catch (Exception e) {
			throw e;
		}
	}
	
	@Test(priority = 2)
	public void readData_Test() throws Exception {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			// setup connection with DB YahooScraperMySQLConnection
			String connectionString = "jdbc:mysql://localhost:3306/YahooScraper";
			connect = DriverManager.getConnection(connectionString, "yahoo", "yahoo");
			statement = connect.createStatement();
			resultSet = statement
					.executeQuery("select * from YahooScraper.myWatchlist where symbol like 'INTC'");
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String symbol = resultSet.getString("symbol");

				System.out.println(String.format("id: %d symbol: %5s", id, symbol));
			}
		} catch (Exception e) {
			throw e;
		}
	}
}
