package components.watchlist;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

public class WatchlistComponent extends StackPane{
	
	public WatchlistComponent() {
		
	}
	private final static double MAX_TAB_WIDTH = 303.5;
	private ImageView bgImg = new ImageView(new Image("C:\\Users\\Asror\\Desktop\\java-projects\\stock-alerter\\lib\\src\\main\\resources\\mountains.jpg"));
	private WatchlistStrategy contentStrategy; 
	public WatchlistComponent(WatchlistStrategy contentStrategy) {
		super();
		getChildren().addAll(bgImg,contentStrategy.loadWatchlist());
	}
}
