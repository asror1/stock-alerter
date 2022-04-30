package tools;

import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Region;

public class FXTools {
	public static void setShadow(Node node, double radius, String color) {
		
	}
	public static void setBackgroundColor(Node node, String color) {
		if(node!=null) {
			node.setStyle("-fx-background-color: "+color+";");
		}
	}
	public static void setImageSize(ImageView image, RectangularDimention d) {
		
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
