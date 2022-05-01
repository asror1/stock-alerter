package tools;

import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;

public class FXTools {
	public static void setShadow(Node node, double radius, String color) {
		DropShadow ds = new DropShadow(radius, Color.web(color));
		node.setEffect(ds);
	}
	public static void setBackgroundColor(Node node, String color) {
		if(node!=null) {
			node.setStyle("-fx-background-color: "+color+";");
		}
	}
	public static void setImageSize(ImageView image, RectangularDimention d) {
		image.setFitHeight(d.getPrefHeight());
		image.setFitWidth(d.getPrefWidth());
	}
	public static Region createFillerRegion(RectangularDimention d) {
		return null;
	}
	public static Button createSimpleButton(RectangularDimention d, String text, String styleClass) {
		return null;
	}
	public static Button createSimpleButton(RectangularDimention d, String text) {
		return null;
	}
	public static Button createGraphicButton(RectangularDimention d, String svgPath, String styleClass) {
		return null;
	}
	public static Button createGraphicButton(RectangularDimention d, String svgPath) {
		return null;
	}
	
}
