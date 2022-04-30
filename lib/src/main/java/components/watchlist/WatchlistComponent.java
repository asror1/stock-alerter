package components.watchlist;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

public class WatchlistComponent extends StackPane{
	private final static double MAX_TAB_WIDTH = 303.5;
	private ImageView bgImg = new ImageView(new Image("..\\..\\..\\resources\\mountains.jpg"));
	public WatchlistComponent() {
		super();
	}
}
