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
	
	@BeforeTest
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

	@Test(priority = 1)
	public void connectToDB_Test() throws Exception {
		try {
//			Class.forName("com.mysql.jdbc.Driver");
			
			System.out.print("25. connect.toString() == ");
			System.out.println(connect.toString());
		} catch (Exception e) {
			throw e;
		}
	}
	
	@Test(priority = 2)
	public void readData_Test() throws Exception {
		try {
//			Class.forName("com.mysql.jdbc.Driver");
			
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
	
	@Test(priority = 3)
	public void addNewStock() throws Exception {

		try{
//			Class.forName("com.mysql.jdbc.Driver");
			
			String symbol = "NFLX";
			Double lastPrice = 301.05;
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
