package components.watchlist;

import javafx.scene.Node;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import tools.FXTools;
import tools.InvalidRGBAValueException;
import tools.RGBA;
import tools.RectangularDimention;

public class DefaultWatchlistStrategy implements WatchlistStrategy {

	public DefaultWatchlistStrategy() {
	}

	private GridPane loadItemContainer() {
		GridPane grid = new GridPane();
		try {
			FXTools.setBackgroundColor(grid, new RGBA().setColor("red").setAlpha(0.3));
			FXTools.setRegionSize(grid, new RectangularDimention(500, 100, null, null));
		} catch (InvalidRGBAValueException e) {
			e.printStackTrace();
		}

		return grid;
	}

	private VBox loadButtonContainer() {
		VBox buttonContainer = new VBox();
		try {
			FXTools.setBackgroundColor(buttonContainer, new RGBA().setColor("blue").setAlpha(0.3));
		} catch (InvalidRGBAValueException e) {
			e.printStackTrace();
		}
		FXTools.setRegionSize(buttonContainer, new RectangularDimention(500, 500, null, null));
		return buttonContainer;
	}

	private Pane loadWatchlist(Node... nodes) {
		HBox watchlist = new HBox();
		watchlist.getChildren().addAll(nodes);
		return watchlist;
	}

	@Override
	public Pane loadWatchlist() {
		return loadWatchlist(loadItemContainer(), loadButtonContainer());
	}

}
