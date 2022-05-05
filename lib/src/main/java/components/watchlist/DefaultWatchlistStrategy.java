package components.watchlist;

import components.stock.StockView;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import tools.FXTools;
import tools.InvalidRGBAValueException;
import tools.RGBA;
import tools.dimension.DynamicRectangularDimension;

public class DefaultWatchlistStrategy implements WatchlistStrategy {
	
	private HBox watchlist = new HBox();
	private VBox buttonContainer = new VBox();
	private GridPane stockContainer = new GridPane();
	public DefaultWatchlistStrategy() {
		if(!loadStockContainer()) {
			watchlist.getChildren().add(new VBox(new Label("Stock container unable to load")));
		}
		if(!loadButtonContainer()) {
			watchlist.getChildren().add(new VBox(new Label("Button container unable to load")));
		}
	}

	private boolean loadStockContainer() {
		try {
			FXTools.setBackgroundColor(stockContainer, new RGBA().setColor("#659df0").setAlpha(0.5));
			FXTools.setRegionSize(stockContainer, new DynamicRectangularDimension(500, 500));
		} catch (InvalidRGBAValueException e) {
			e.printStackTrace();
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	private boolean loadButtonContainer() {
		try {
			FXTools.setBackgroundColor(buttonContainer, new RGBA().setColor("#e1328c").setAlpha(0.5));
			FXTools.setRegionSize(buttonContainer, new DynamicRectangularDimension(500, 500));
		} catch (InvalidRGBAValueException e) {
			e.printStackTrace();
			return false;
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public Pane loadWatchlist() {
		watchlist.getChildren().addAll(stockContainer,buttonContainer);
		return watchlist;
	}

	@Override
	public void add(StockView stock) {
	}

	@Override
	public void remove(StockView stock) {
		
	}

}
