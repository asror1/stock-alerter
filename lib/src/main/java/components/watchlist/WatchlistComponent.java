package components.watchlist;

import components.stock.view.ItemView;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import util.FXTools;
import util.InvalidRGBAValueException;
import util.RGBA;
import util.dimension.DynamicRectangularDimension;
import util.dimension.StaticRectangularDimension;

public class WatchlistComponent extends HBox implements Watchlist {
	
	private VBox buttonContainer = new VBox();
	private GridPane stockContainer = new GridPane();
	protected boolean isOpen = true;
	
	public WatchlistComponent(Scene s) {
		super();
		if(!loadStockContainer()) {
			getChildren().add(new VBox(new Label("Stock container unable to load")));
		}
		if(!loadButton()) {
			getChildren().add(new VBox(new Label("Button container unable to load")));
		}
		getChildren().addAll(stockContainer,buttonContainer);
		FXTools.bindDimention(prefHeightProperty(), s.heightProperty());
		FXTools.bindDimention(maxWidthProperty(), s.widthProperty());
	}

	private boolean loadStockContainer() {
		try {
			FXTools.setBackgroundColor(stockContainer, new RGBA().setColor("#659df0"));
			FXTools.setRegionSize(stockContainer, new DynamicRectangularDimension(300, 0));
			
		} catch (InvalidRGBAValueException e) {
			e.printStackTrace();
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	private boolean loadButton() {
		Pane button = new HBox();
		buttonContainer.setAlignment(Pos.CENTER);
		try {
			FXTools.setBackgroundColor(buttonContainer, new RGBA().setColor("#e1328c"));
			FXTools.setRegionSize(buttonContainer, new DynamicRectangularDimension(35, 0));
			FXTools.setBackgroundColor(button, "lime");
			FXTools.setRegionSize(button, new StaticRectangularDimension(35,100.0));
			buttonContainer.getChildren().add(button);
			button.setOnMousePressed(event ->{
				if(isOpen) {
					getChildren().remove(stockContainer);
					isOpen=false;
				}
				else {
					getChildren().add(0, stockContainer);
					isOpen=true;
				}
			});
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
	public void add(ItemView stock) {
		stockContainer.getChildren().add(stock.loadView());
		
	}

	@Override
	public void remove(ItemView stock) {
		stockContainer.getChildren().remove(stock.loadView());
	}


}
