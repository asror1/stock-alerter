package components.stock.model;

import java.util.List;

public class Stock {
	private String ticker;
	private List<StockPrice> dayPrice;
	public Stock(String ticker) {
		this.setTicker(ticker);
	}
	public Stock(String ticker, List<StockPrice> dayPrice) {
		this.setTicker(ticker);
		this.setDayPrice(dayPrice);
	}
	
	public String getTicker() {
		return ticker;
	}

	public void setTicker(String ticker) {
		this.ticker = ticker;
	}
	public List<StockPrice> getDayPrice(){
		return dayPrice;
	}

	public void setDayPrice(List<StockPrice> dailyPrice) {
		this.dayPrice = dailyPrice;
	}
}
