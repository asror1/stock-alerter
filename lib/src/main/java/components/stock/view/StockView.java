package components.stock.view;

import java.util.LinkedList;

import components.stock.model.PriceObserver;
import components.stock.model.StockPrice;
import javafx.scene.layout.Pane;

abstract class StockView implements PriceObserver {
	
	protected String ticker;
	protected LinkedList<StockPrice> dayPrice;
	protected StockPrice latestPrice;
	public StockView(LinkedList<StockPrice> dayPrice, String ticker) {
		this.ticker = ticker;
		this.dayPrice = dayPrice;
		this.latestPrice = dayPrice.peekLast();
	}
	public abstract Pane loadView();
	
	public abstract void update(StockPrice price);
	 
}
