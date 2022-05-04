package components.watchlist;

import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import tools.FXTools;
import tools.InvalidRGBAValueException;
import tools.RGBA;
import tools.dimention.DynamicRectangularDimention;
import tools.dimention.RectangularDimention;

public class DefaultWatchlistStrategy implements WatchlistStrategy {
	
	private HBox watchlist = new HBox();
	public DefaultWatchlistStrategy() {}

	private GridPane loadItemContainer() {
		GridPane grid = new GridPane();
		try {
			FXTools.setBackgroundColor(grid, new RGBA().setColor("#659df0").setAlpha(1));
			FXTools.setRegionSize(grid, new DynamicRectangularDimention(500, 500));
			System.out.println(grid.getPrefWidth());
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
		FXTools.setRegionSize(buttonContainer, new DynamicRectangularDimention(500, 500));
		return buttonContainer;
	}

	@Override
	public Pane loadWatchlist() {
		watchlist.getChildren().addAll(loadItemContainer(), loadButtonContainer());
		return watchlist;
	}

}
