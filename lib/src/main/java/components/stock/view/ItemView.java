package components.stock.view;

import java.util.LinkedList;


import components.stock.model.StockPrice;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import util.FXTools;
import util.dimension.StaticRectangularDimension;

public class ItemView extends StockView {
	protected HBox container = new HBox();
	protected HBox removeButton = new HBox();
	public final static double PREF_WIDTH = 300, PREF_HEIGHT = 100; 
	public ItemView(LinkedList<StockPrice> dayPrice, String ticker) {
		super(dayPrice, ticker);
		try {
			FXTools.setBackgroundColor(container,Color.valueOf("#e86d5e"));
			FXTools.setRegionSize(container, new StaticRectangularDimension(PREF_WIDTH,PREF_HEIGHT));
			FXTools.setBorder(container, "black", 0, new BorderWidths(0,1,1,1));
			if(!loadButton()) throw new Exception("Remove button was unable to load");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		container.setAlignment(Pos.TOP_RIGHT);
		container.getChildren().add(removeButton);
	}
	private boolean loadButton() {
		FXTools.setRegionSize(removeButton, new StaticRectangularDimension(25,25));
		FXTools.setBackgroundColor(removeButton, "white");
		removeButton.setAlignment(Pos.CENTER);
		FXTools.setSvgGraphic(removeButton,new StaticRectangularDimension(15,2), "M40 500 l0 -40 460 0 460 0 0 40 0 40 -460 0 -460 0 0 -40z", 0.6);
		return true;
	}
	public ItemView setOnClicked(EventHandler<Event> event) {
		container.setOnMousePressed(event);
		return this;
	}
	public ItemView setOnButtonPressed(EventHandler<Event> event) {
		removeButton.setOnMousePressed(event);
		return this;
	}
	@Override 
	public String toString() {
		return ticker + "@["+hashCode()+"]";
	}
	@Override
	public void update(StockPrice price) {
	}

	@Override
	public Pane loadView() {
		return container;
	}

}
