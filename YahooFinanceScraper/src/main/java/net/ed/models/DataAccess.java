package net.ed.models;

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
			String connectionString = "jdbc:mysql://localhost:3306/YahooScraper?autoReconnect=true&useSSL=false";
			connect = DriverManager.getConnection(connectionString, "yahoo", "yahoo");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
	
	public void addNewStock() throws Exception {

		try{
			Class.forName("com.mysql.jdbc.Driver");
			
			// setup connection with DB YahooScraperMySQLConnection
			String connectionString = "jdbc:mysql://localhost:3306/YahooScraper";
			connect = DriverManager.getConnection(connectionString, "yahoo", "yahoo");
			
			String symbol = "AMD";
			Double lastPrice = 11.81;
			Double todaysChange = 1.14;
			String percentChange = "+2.38";
			String currency = "USD";
			String marketTime = "Mar 2 EST";
			String volume = "33.31";
			Double shares = 10.0;
			String avgVol = "34.80";
			String dayRange = null;
			String fftyTwoWkRange = null;
			String dayChart = null;
			String marketCap = "229.23";
			
			String query = "INSERT INTO YahooScraper.myWatchlist ("
					+ "symbol, lastPrice,todaysChange,percentChange,currency,marketTime,volume,shares,"
					+ "avgVol,dayRange,fftyTwoWkRange,dayChart,marketCap)"
					+ "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
			
			preparedStatement = connect.prepareStatement(query);
			preparedStatement.setString(1, symbol);
			preparedStatement.setDouble(2, lastPrice);
			preparedStatement.setDouble(3, todaysChange);
			preparedStatement.setString(4, percentChange);
			preparedStatement.setString(5, currency);
			preparedStatement.setString(6, marketTime);
			preparedStatement.setString(7, volume);
			preparedStatement.setDouble(8, shares);
			preparedStatement.setString(9, avgVol);
			preparedStatement.setString(10, dayRange);
			preparedStatement.setString(11, fftyTwoWkRange);
			preparedStatement.setString(12, dayChart);
			preparedStatement.setString(13, marketCap);
			preparedStatement.executeUpdate();
			
			
		}  catch (Exception e) {
			throw e;
		}
	}
}