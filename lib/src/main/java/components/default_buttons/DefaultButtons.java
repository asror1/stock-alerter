package components.default_buttons;

import components.watchlist.WatchlistComponent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import util.FXTools;
import util.dimension.StaticRectangularDimension;

public class DefaultButtons extends HBox {
	private static Scene scene;
	private double xOffset = 0, yOffset = 0;
	public DefaultButtons(Scene s) {
		super();
		scene = s;
		setAlignment(Pos.TOP_RIGHT);
		setMaxHeight(25.0);
		setOnMousePressed(event ->{
			xOffset = event.getX();
			yOffset = event.getY();
		});
		setOnMouseDragged(event ->{
			Stage stage = (Stage) scene.getWindow();
			stage.setX(event.getScreenX() - xOffset);
			stage.setY(event.getScreenY() - yOffset);
		});
		setBorder(new Border(new BorderStroke(Paint.valueOf("rgba(0,0,0,0)"), Paint.valueOf("rgba(0,0,0,0)"), Paint.valueOf("rgba(0,0,0,1)"), Paint.valueOf("rgba(0,0,0,0)"), BorderStrokeStyle.NONE, BorderStrokeStyle.NONE, BorderStrokeStyle.SOLID, BorderStrokeStyle.NONE, new CornerRadii(0), new BorderWidths(0, 0, 3, 0), Insets.EMPTY)));
		getChildren().addAll(loadMinimizeButton(),loadMaximizeButton(),loadCloseButton());
	}
	private Pane loadCloseButton() {
		Pane closeButton = new HBox();
		FXTools.setRegionSize(closeButton, new StaticRectangularDimension(25.0,25.0));
		FXTools.setBackgroundColor(closeButton, "red");
		closeButton.setOnMousePressed(event->{
			Stage stage = (Stage) scene.getWindow();
			stage.close();
		});
		return closeButton;
	}
	private Pane loadMaximizeButton() {
		Pane maximizeButton = new HBox();
		FXTools.setRegionSize(maximizeButton, new StaticRectangularDimension(25.0,25.0));
		FXTools.setBackgroundColor(maximizeButton, "blue");
		maximizeButton.setOnMousePressed(event->{
			Stage stage = (Stage) scene.getWindow();
			if(stage.isMaximized()) {
				FXTools.setBackgroundColor(maximizeButton, "blue");
				stage.setMaximized(false);
			}
			else {
				FXTools.setBackgroundColor(maximizeButton, "white");
				stage.setMaximized(true);
			}
		});
		return maximizeButton;
	}
	private Pane loadMinimizeButton() {
		Pane minimizeButton = new HBox();
		FXTools.setRegionSize(minimizeButton, new StaticRectangularDimension(25.0,25.0));
		FXTools.setBackgroundColor(minimizeButton, "green");
		minimizeButton.setOnMousePressed(event->{
			Stage stage = (Stage) scene.getWindow();
			stage.setIconified(true);
		});
		return minimizeButton;
	}
}
