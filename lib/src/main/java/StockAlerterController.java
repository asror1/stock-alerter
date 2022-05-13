import java.util.LinkedList;

import components.default_buttons.DefaultButtons;
import components.stock.model.StockPrice;
import components.stock.view.ItemView;
import components.watchlist.WatchlistComponent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import util.FXTools;
import util.InvalidRGBAValueException;
import util.RGBA;

public class StockAlerterController {
	private double sceneHeight = 1000, sceneWidth = 1500; 
	protected StackPane root = new StackPane();
	private final Scene scene = new Scene(root,sceneWidth,sceneHeight);
	
	public StockAlerterController() {
		root.setAlignment(Pos.TOP_LEFT);
		try {
			FXTools.setBackgroundColor(root, new RGBA().setColor("#212326"));
		} catch (InvalidRGBAValueException e) {
			e.printStackTrace();
		}
		root.setBorder(new Border(new BorderStroke(Paint.valueOf("black"), BorderStrokeStyle.SOLID, new CornerRadii(5), BorderStroke.THIN)));
		root.getChildren().add(new VBox(new DefaultButtons(scene),loadDisplay()));
	}
	private HBox loadDisplay() {
		HBox display = new HBox();
		WatchlistComponent watchlist = new WatchlistComponent(scene);
		LinkedList<StockPrice> price = new LinkedList<>();
//		(long timeStamp, int numTransactions, double close, double open, double high, double low, int volume, double avgPrice)
		price.add(new StockPrice(157794120,1,75.0875,74.06,75.15,73.7975,135647456,74.6099));
		ItemView  item = new ItemView(price,"AAPL");
		watchlist.add(item);
		
		display.getChildren().addAll(watchlist);
		return display;
	}
	public Scene loadApp() {
		return scene;
	}
}
