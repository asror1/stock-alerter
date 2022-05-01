package tools;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.scene.shape.SVGPath;

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
		Region rgn = new Region();
		rgn.setPrefSize(d.getPrefWidth(), d.getPrefHeight());
		rgn.setMinSize(d.getMinWidth(), d.getMinHeight());
		rgn.setMaxSize(d.getMaxWidth(), d.getMaxHeight());
		return rgn;
	}
	public static Button createSimpleButton(RectangularDimention d, String text, String styleClass) {
		Button btn = new Button();
		btn.setAlignment(Pos.CENTER);
		btn.setPrefSize(d.getPrefWidth(), d.getPrefHeight());
		btn.setMinSize(d.getMinWidth(), d.getMinHeight());
		btn.setMaxSize(d.getMaxWidth(), d.getMaxHeight());
		btn.setText(text);
		btn.getStyleClass().add(styleClass);
		return btn;
	}
	public static Button createSimpleButton(RectangularDimention d, String text) {
		Button btn = new Button();
		btn.setAlignment(Pos.CENTER);
		btn.setPrefSize(d.getPrefWidth(), d.getPrefHeight());
		btn.setMinSize(d.getMinWidth(), d.getMinHeight());
		btn.setMaxSize(d.getMaxWidth(), d.getMaxHeight());
		btn.setText(text);
		return btn;
	}
	public static Button createGraphicButton(RectangularDimention d, String svgPath, double graphicRatio, String styleClass) {
		Button btn = new Button();
		Region rgn = createFillerRegion(new RectangularDimention((d.getPrefWidth()*graphicRatio), (d.getPrefHeight()*graphicRatio),null,null,null,null));
		SVGPath svg = new SVGPath();
		svg.setContent(svgPath);
		rgn.setShape(svg);
		setBackgroundColor(rgn, "black");
		btn.setGraphic(rgn);
		btn.getStyleClass().add(styleClass);
		return btn;
	}
	public static Button createGraphicButton(RectangularDimention d, String svgPath, double graphicRatio) {
		Button btn = new Button();
		Region rgn = createFillerRegion(new RectangularDimention((d.getPrefWidth()*graphicRatio), (d.getPrefHeight()*graphicRatio),null,null,null,null));
		SVGPath svg = new SVGPath();
		svg.setContent(svgPath);
		rgn.setShape(svg);
		setBackgroundColor(rgn, "black");
		btn.setGraphic(rgn);
		return btn;
	}
	
}
