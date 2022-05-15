import java.util.LinkedList;

import components.default_buttons.DefaultButtons;
import components.stock.model.StockPrice;
import components.stock.view.ChartView;
import components.stock.view.ItemView;
import components.watchlist.WatchlistComponent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import util.FXTools;

public class StockAlerterController {
	private final static double STARTER_HEIGHT = 1000, STARTER_WIDTH = 1500; 
	private final static String CSS = "src\\main\\resources\\style.css";
	protected StackPane root = new StackPane();
	private final Scene scene = new Scene(root,STARTER_WIDTH,STARTER_HEIGHT);
	
	public StockAlerterController() {
		root.setAlignment(Pos.TOP_LEFT);
		FXTools.setBackgroundColor(root, Color.web("#212035"));
		 
		FXTools.setBorder(root, "black", 2, 1);
		root.getChildren().add(new VBox(new DefaultButtons(scene),loadDisplay()));
	}
	private HBox loadDisplay() {
		HBox display = new HBox();
		display.setAlignment(Pos.CENTER_LEFT);
		WatchlistComponent watchlist = new WatchlistComponent(scene.heightProperty());
		
		
		LinkedList<StockPrice> price = new LinkedList<>();
//		(long timeStamp, int numTransactions, double close, double open, double high, double low, int volume, double avgPrice)
		price.add(new StockPrice(157794120,1,75.0875,74.06,75.15,73.7975,135647456,74.6099));
		ChartView chart =new ChartView(scene.widthProperty(), watchlist.widthProperty(), price,"AAPL");
		
		for(int i=0;i<5;++i) {
			ItemView view = new ItemView(price,"AAPL");
			view.setOnButtonPressed(event ->{
				watchlist.remove(view);
			});
			watchlist.add(view);
		}
		display.getChildren().addAll(watchlist,chart.loadView());
		return display;
	}
	public Scene loadApp() {
		scene.getStylesheets().add(FXTools.createURL(CSS).toExternalForm());
		return scene;
	}
}
