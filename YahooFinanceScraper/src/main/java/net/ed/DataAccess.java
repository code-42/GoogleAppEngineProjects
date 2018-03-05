package net.ed;

import java.sql.*;

public class DataAccess {
	
	Connection connect = null;
	Statement statement = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;

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
	
	public void readData() throws Exception {
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
