package components.stock.view;

import java.util.LinkedList;

import components.stock.model.StockPrice;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

public class ItemView extends StockView {
	protected HBox container = new HBox();
	public ItemView(LinkedList<StockPrice> dayPrice, String ticker) {
		super(dayPrice, ticker);
	}
	
	@Override
	public void update(StockPrice price) {
	}

	@Override
	public Pane loadView() {
		return container;
	}

}
