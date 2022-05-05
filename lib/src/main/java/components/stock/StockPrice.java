package components.stock;

import java.text.SimpleDateFormat;
import java.util.Date;

public class StockPrice {
	private long timeStamp;
	private int numTransactions;
	private double close;
	private double open;
	private double high; 
	private double low;
	private int volume; 
	private double avgPrice;
	private static final SimpleDateFormat DATE_FORMATTER = new SimpleDateFormat("MMM d, ^yy");
	public StockPrice() {}
	public StockPrice(long timeStamp, int numTransactions, double close, double open, double high, double low, int volume, double avgPrice) {
		this.setTimeStamp(timeStamp);
		this.setNumTransactions(numTransactions);
		this.setClose(close);
		this.setOpen(open);
		this.setHigh(high);
		this.setLow(low);
		this.setVolume(volume);
		this.setAvgPrice(avgPrice);
	}
	public String getDate() {
		return DATE_FORMATTER.format(new Date(timeStamp));
	}
	public long getTimeStamp() {
		return timeStamp;
	}
	public StockPrice setTimeStamp(long timeStamp) {
		this.timeStamp = timeStamp;
		return this;
	}
	public int getNumTransactions() {
		return numTransactions;
	}
	public StockPrice setNumTransactions(int numTransactions) {
		this.numTransactions = numTransactions;
		return this;
	}
	public double getClose() {
		return close;
	}
	public StockPrice setClose(double close) {
		this.close = close;
		return this;
	}
	public double getOpen() {
		return open;
	}
	public StockPrice setOpen(double open) {
		this.open = open;
		return this;
	}
	public double getHigh() {
		return high;
	}
	public StockPrice setHigh(double high) {
		this.high = high;
		return this;
	}
	public double getLow() {
		return low;
	}
	public StockPrice setLow(double low) {
		this.low = low;
		return this;
	}
	public int getVolume() {
		return volume;
	}
	public StockPrice setVolume(int volume) {
		this.volume = volume;
		return this;
	}
	public double getAvgPrice() {
		return avgPrice;
	}
	public StockPrice setAvgPrice(double avgPrice) {
		this.avgPrice = avgPrice;
		return this;
	}
}