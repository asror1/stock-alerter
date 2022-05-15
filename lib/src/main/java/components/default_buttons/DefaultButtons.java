package components.default_buttons;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
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
		Region space = new Region();
		FXTools.bindDimention(space.prefWidthProperty(), scene.widthProperty());
		FXTools.bindDimention(maxWidthProperty(), scene.widthProperty());
		space.setOnMousePressed(event ->{
			xOffset = event.getX();
			yOffset = event.getY();
		});
		space.setOnMouseDragged(event ->{
			Stage stage = (Stage) scene.getWindow();
			stage.setX(event.getScreenX() - xOffset);
			stage.setY(event.getScreenY() - yOffset);
		});
		FXTools.setBottomBorder(this, "black", BorderStrokeStyle.SOLID, 2.5);
		getChildren().addAll(space,loadMinimizeButton(),loadMaximizeButton(),loadCloseButton());
	}
	private Pane loadCloseButton() {
		HBox closeButton = new HBox();
		closeButton.setAlignment(Pos.CENTER);
		FXTools.setRegionSize(closeButton, new StaticRectangularDimension(25.0,25.0));
		FXTools.setBackgroundColor(closeButton, Color.web("#212035"));
		FXTools.setBorder(closeButton, "#585268", 0, new BorderWidths(1,1,1,0));
		FXTools.setSvgGraphic(closeButton, new StaticRectangularDimension(25.0,25.0), "M1475 3736 c-61 -27 -105 -94 -105 -158 0 -68 35 -108 495 "
				+ "-568 l455 -455 -460 -460 c-466 -467 -490 -495 -490 -565 0 -88 83 -170 172 -170 68 0 108 35 568 495 l455 455 460 "
				+ "-460 c467 -466 495 -490 565 -490 88 0 170 83 170 171 0 69 -25 98 -490 564 l-460 460 455 455 c297 297 462 469 475 496 34 "
				+ "70 21 142 -36 196 -53 49 -115 60 -182 33 -25 -11 -182 -161 -497 -475 l-"
				+ "460 -460 -455 455 c-297 297 -469 462 -496 475 -46 23 -96 25 -139 6z", Color.web("#b1abaf"),0.459);
		closeButton.setOnMousePressed(event->{
			Stage stage = (Stage) scene.getWindow();
			stage.close();
		});
		return closeButton;
	}
	private Pane loadMaximizeButton() {
		HBox maximizeButton = new HBox();
		maximizeButton.setAlignment(Pos.CENTER);
		FXTools.setBorder(maximizeButton, "#585268", 0, new BorderWidths(1,1,1,0));
		FXTools.setRegionSize(maximizeButton, new StaticRectangularDimension(25.0,25.0));
		FXTools.setBackgroundColor(maximizeButton, Color.web("#212035"));
		Region max = FXTools.createSvgGraphic(new StaticRectangularDimension(25.0,25.0), "M13.5 10a3.5 3.5 0 0 0-3.5 3.5v73a3.5 3.5 0 0 0 3.5 3.5h73a3.5 3.5 0 0 0 3.5-3.5v-73a3.5 3.5 0 0 0-3.5-3.5h-73zm3.5 7h66v66H17V17z", Color.web("#b1abaf"),0.55);
		Region min = FXTools.createSvgGraphic(new StaticRectangularDimension(25.0,25.0), "M8 3v3a2 2 0 0 1-2 2H3m18 0h-3a2 2 0 0 1-2-2V3m0 18v-3a2 2 0 0 1 2-2h3M3 16h3a2 2 0 0 1 2 2v3", Color.web("#b1abaf"),0.55);
		FXTools.setGraphic(maximizeButton, max);
		maximizeButton.setOnMousePressed(event->{
			Stage stage = (Stage) scene.getWindow();
			if(stage.isMaximized()) {
				FXTools.setGraphic(maximizeButton, max);
				stage.setMaximized(false);
			}
			else {
				FXTools.setGraphic(maximizeButton, min);
				stage.setMaximized(true);
			}
		});
		return maximizeButton;
	}
	private Pane loadMinimizeButton() {
		HBox minimizeButton = new HBox();
		minimizeButton.setAlignment(Pos.CENTER);
		FXTools.setBorder(minimizeButton, "#585268", 0, new BorderWidths(1,1,1,0));
		FXTools.setRegionSize(minimizeButton, new StaticRectangularDimension(25.0,25.0));
		FXTools.setBackgroundColor(minimizeButton, Color.web("#212035"));
		Label underscore = new Label("-");
		underscore.setFont(Font.font(35));
		underscore.setTextFill(Paint.valueOf("#b1abaf"));
		minimizeButton.getChildren().add(underscore);
		minimizeButton.setOnMousePressed(event->{
			Stage stage = (Stage) scene.getWindow();
			stage.setIconified(true);
		});
		return minimizeButton;
	}
}
