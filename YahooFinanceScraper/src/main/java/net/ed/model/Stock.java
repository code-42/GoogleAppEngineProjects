package net.ed.model;

public class Stock {
	
	private String symbol;
	private Double lastPrice;
	private Double todaysChange;
	private String percentChange;
	private String currency;
	private String marketTime;
	private String volume;
	private Double shares;
	private String avgVol;
	private String dayRange;
	private String fftyTwoWkRange;
	private String dayChart;
	private Double marketCap;
	
	/**
	 * @param symbol
	 * @param lastPrice
	 * @param todaysChange
	 * @param percentChange
	 * @param currency
	 * @param marketTime
	 * @param volume
	 * @param shares
	 * @param avgVol
	 * @param dayRange
	 * @param fftyTwoWkRange
	 * @param dayChart
	 * @param marketCap
	 */
	
	public Stock(String symbol, Double lastPrice, Double todaysChange, String percentChange, String currency,
			String marketTime, String volume, Double shares, String avgVol, String dayRange, String fftyTwoWkRange,
			String dayChart, Double marketCap) {
		super();
		this.symbol = symbol;
		this.lastPrice = lastPrice;
		this.todaysChange = todaysChange;
		this.percentChange = percentChange;
		this.currency = currency;
		this.marketTime = marketTime;
		this.volume = volume;
		this.shares = shares;
		this.avgVol = avgVol;
		this.dayRange = dayRange;
		this.fftyTwoWkRange = fftyTwoWkRange;
		this.dayChart = dayChart;
		this.marketCap = marketCap;
		
	}

	/**
	 * @return the symbol
	 */
	public String getSymbol() {
		return symbol;
	}

	/**
	 * @param symbol the symbol to set
	 */
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	/**
	 * @return the lastPrice
	 */
	public Double getLastPrice() {
		return lastPrice;
	}

	/**
	 * @param lastPrice the lastPrice to set
	 */
	public void setLastPrice(Double lastPrice) {
		this.lastPrice = lastPrice;
	}

	/**
	 * @return the todaysChange
	 */
	public Double getTodaysChange() {
		return todaysChange;
	}

	/**
	 * @param todaysChange the todaysChange to set
	 */
	public void setTodaysChange(Double todaysChange) {
		this.todaysChange = todaysChange;
	}

	/**
	 * @return the percentChange
	 */
	public String getPercentChange() {
		return percentChange;
	}

	/**
	 * @param percentChange the percentChange to set
	 */
	public void setPercentChange(String percentChange) {
		this.percentChange = percentChange;
	}

	/**
	 * @return the currency
	 */
	public String getCurrency() {
		return currency;
	}

	/**
	 * @param currency the currency to set
	 */
	public void setCurrency(String currency) {
		this.currency = currency;
	}

	/**
	 * @return the marketTime
	 */
	public String getMarketTime() {
		return marketTime;
	}

	/**
	 * @param marketTime the marketTime to set
	 */
	public void setMarketTime(String marketTime) {
		this.marketTime = marketTime;
	}

	/**
	 * @return the volume
	 */
	public String getVolume() {
		return volume;
	}

	/**
	 * @param volume the volume to set
	 */
	public void setVolume(String volume) {
		this.volume = volume;
	}

	/**
	 * @return the shares
	 */
	public Double getShares() {
		return shares;
	}

	/**
	 * @param shares the shares to set
	 */
	public void setShares(Double shares) {
		this.shares = shares;
	}

	/**
	 * @return the avgVol
	 */
	public String getAvgVol() {
		return avgVol;
	}

	/**
	 * @param avgVol the avgVol to set
	 */
	public void setAvgVol(String avgVol) {
		this.avgVol = avgVol;
	}

	/**
	 * @return the dayRange
	 */
	public String getDayRange() {
		return dayRange;
	}

	/**
	 * @param dayRange the dayRange to set
	 */
	public void setDayRange(String dayRange) {
		this.dayRange = dayRange;
	}

	/**
	 * @return the fftyTwoWkRange
	 */
	public String getFftyTwoWkRange() {
		return fftyTwoWkRange;
	}

	/**
	 * @param fftyTwoWkRange the fftyTwoWkRange to set
	 */
	public void setFftyTwoWkRange(String fftyTwoWkRange) {
		this.fftyTwoWkRange = fftyTwoWkRange;
	}

	/**
	 * @return the dayChart
	 */
	public String getDayChart() {
		return dayChart;
	}

	/**
	 * @param dayChart the dayChart to set
	 */
	public void setDayChart(String dayChart) {
		this.dayChart = dayChart;
	}

	/**
	 * @return the marketCap
	 */
	public Double getMarketCap() {
		return marketCap;
	}

	/**
	 * @param marketCap the marketCap to set
	 */
	public void setMarketCap(Double marketCap) {
		this.marketCap = marketCap;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Stock [symbol=" + symbol + ", lastPrice=" + lastPrice + ", todaysChange=" + todaysChange
				+ ", percentChange=" + percentChange + ", currency=" + currency + ", marketTime=" + marketTime
				+ ", volume=" + volume + ", shares=" + shares + ", avgVol=" + avgVol + ", dayRange=" + dayRange
				+ ", fftyTwoWkRange=" + fftyTwoWkRange + ", dayChart=" + dayChart + ", marketCap=" + marketCap + "]";
	}
	
	
	

}
