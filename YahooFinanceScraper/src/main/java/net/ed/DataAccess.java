package net.ed;

import java.sql.*;

public class DataAccess {
	
	Connection connect = null;
	Statement statement = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;

	public void connectToDB() throws SQLException {

		// setup connection with DB YahooScraperMySQLConnection
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String connectionString = "jdbc:mysql://localhost:3306/YahooScraper?autoReconnect=true&useSSL=false";
		connect = DriverManager.getConnection(connectionString, "yahoo", "yahoo");
	}

}
