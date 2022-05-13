package components.stock.view;

import java.util.LinkedList;

import components.stock.model.StockPrice;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import util.FXTools;
import util.InvalidRGBAValueException;
import util.RGBA;
import util.dimension.StaticRectangularDimension;

public class ItemView extends StockView {
	protected HBox container = new HBox();
	protected HBox removeButton = new HBox();
	public ItemView(LinkedList<StockPrice> dayPrice, String ticker) {
		super(dayPrice, ticker);
		try {
			FXTools.setBackgroundColor(container, new RGBA().setColor("#f9bf6c"));
			FXTools.setRegionSize(container, new StaticRectangularDimension(300,100));
			if(!loadRemoveButton()) throw new Exception("Remove button was unable to load");
			
		} catch (InvalidRGBAValueException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		container.setAlignment(Pos.TOP_RIGHT);
		container.getChildren().add(removeButton);
	}
	private boolean loadRemoveButton() {
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
		container.setOnMousePressed(event);
		return this;
	}
	@Override 
	public String toString() {
		return ticker;
	}
	@Override
	public void update(StockPrice price) {
	}

	@Override
	public Pane loadView() {
		return container;
	}

}
