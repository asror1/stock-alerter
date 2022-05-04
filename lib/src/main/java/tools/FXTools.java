package tools;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.scene.shape.SVGPath;
import tools.dimension.RectangularDimension;

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
	public static void setBackgroundColor(Node node, RGBA rgba) {
		if(node ==null) return; 
		node.setStyle("-fx-background-color: rgb("+rgba.getRed()+","+rgba.getGreen()+","+rgba.getBlue()+","+rgba.getAlpha()+");");
	}
	public static void setImageSize(ImageView image, RectangularDimension d) {
		image.setFitHeight(d.getPrefHeight());
		image.setFitWidth(d.getPrefWidth());
	}
	public static void setRegionSize(Region region, RectangularDimension d) {
		region.setPrefSize(d.getPrefWidth(), d.getPrefHeight());
		region.setMinSize(d.getMinWidth(), d.getMinHeight());
		region.setMaxSize(d.getMaxWidth(), d.getMaxHeight());
	}
	public static Region createFillerRegion(RectangularDimension d) {
		Region rgn = new Region();
		rgn.setPrefSize(d.getPrefWidth(), d.getPrefHeight());
		rgn.setMinSize(d.getMinWidth(), d.getMinHeight());
		rgn.setMaxSize(d.getMaxWidth(), d.getMaxHeight());
		return rgn;
	}
	public static Button createSimpleButton(RectangularDimension d, String text, String styleClass) {
		Button btn = new Button();
		btn.setAlignment(Pos.CENTER);
		btn.setPrefSize(d.getPrefWidth(), d.getPrefHeight());
		btn.setMinSize(d.getMinWidth(), d.getMinHeight());
		btn.setMaxSize(d.getMaxWidth(), d.getMaxHeight());
		btn.setText(text);
		btn.getStyleClass().add(styleClass);
		return btn;
	}
	public static Button createSimpleButton(RectangularDimension d, String text) {
		Button btn = new Button();
		btn.setAlignment(Pos.CENTER);
		btn.setPrefSize(d.getPrefWidth(), d.getPrefHeight());
		btn.setMinSize(d.getMinWidth(), d.getMinHeight());
		btn.setMaxSize(d.getMaxWidth(), d.getMaxHeight());
		btn.setText(text);
		return btn;
	}
	public static Button createGraphicButton(RectangularDimension d, String svgPath, double graphicRatio, String styleClass) {
		Button btn = new Button();
		Region rgn = createFillerRegion(new RectangularDimension((d.getPrefWidth()*graphicRatio), (d.getPrefHeight()*graphicRatio),null,null,null,null));
		SVGPath svg = new SVGPath();
		svg.setContent(svgPath);
		rgn.setShape(svg);
		setBackgroundColor(rgn, "black");
		btn.setGraphic(rgn);
		btn.getStyleClass().add(styleClass);
		return btn;
	}
	public static Button createGraphicButton(RectangularDimension d, String svgPath, double graphicRatio) {
		Button btn = new Button();
		Region rgn = createFillerRegion(new RectangularDimension((d.getPrefWidth()*graphicRatio), (d.getPrefHeight()*graphicRatio),null,null,null,null));
		SVGPath svg = new SVGPath();
		svg.setContent(svgPath);
		rgn.setShape(svg);
		setBackgroundColor(rgn, "black");
		btn.setGraphic(rgn);
		return btn;
	}
	public static void bindHeight(Region n1, Region n2) {
		n1.prefHeightProperty().bind(n2.heightProperty());
	}
	public static void bindWidth(Region n1, Region n2) {
		n1.prefWidthProperty().bind(n2.widthProperty());
	}
}
