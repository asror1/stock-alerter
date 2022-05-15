package util;

import java.net.URL;
import java.nio.file.Paths;

import javafx.beans.property.DoubleProperty;
import javafx.beans.value.ObservableNumberValue;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.SVGPath;
import util.dimension.RectangularDimension;
import util.dimension.StaticRectangularDimension;

public class FXTools {
	
	public static void setInlinePadding(Region region, double right, double left) {
		region.setPadding(new Insets(0,right,0,left));
	}
	public static void setShadow(Node node, double radius, String color) {
		DropShadow ds = new DropShadow(radius, Color.web(color));
		node.setEffect(ds);
	}
	public static void setBackgroundColor(Node node, String color) {
		if(node!=null) node.setStyle("-fx-background-color: "+color+";");
	}
	public static void setBackgroundColor(Node node, Color color) {
		if(node ==null) return; 
		node.setStyle("-fx-background-color: rgb("+color.getRed()*255+","+color.getGreen()*255+","+color.getBlue()*255+");");
	}
	public static void setImageSize(ImageView image, RectangularDimension d) {
		image.setFitHeight(d.getPrefHeight());
		image.setFitWidth(d.getPrefWidth());
	}
	public static void setBorder(Region region, String color, BorderStrokeStyle stroke, double radii, double width) {
		region.setBorder(new Border(new BorderStroke(Paint.valueOf(color), stroke, new CornerRadii(radii), new BorderWidths(width))));
	}
	public static void setBorder(Region region, String color, double radii, double width) {
		region.setBorder(new Border(new BorderStroke(Paint.valueOf(color), BorderStrokeStyle.SOLID, new CornerRadii(radii), new BorderWidths(width))));
	}
	public static void setBorder(Region region, String color, double radii, BorderWidths widths) {
		region.setBorder(new Border(new BorderStroke(Paint.valueOf(color), BorderStrokeStyle.SOLID, new CornerRadii(radii), widths)));
	}
	public static void setBorder(Region region, String color, CornerRadii radii, double width) {
		region.setBorder(new Border(new BorderStroke(Paint.valueOf(color), BorderStrokeStyle.SOLID, radii, new BorderWidths(width))));
	}
	public static void setBorder(Region region, String color, CornerRadii radii, BorderWidths widths) {
		region.setBorder(new Border(new BorderStroke(Paint.valueOf(color), BorderStrokeStyle.SOLID, radii, widths)));
	}
	public static void setBottomBorder(Region region, String color, BorderStrokeStyle stroke, double width) {
		region.setBorder(new Border(new BorderStroke(Paint.valueOf(color), stroke,new CornerRadii(0), new BorderWidths(0,0,width,0))));
	}
	
	public static void setRegionSize(Region region, RectangularDimension d) {
		region.setPrefSize(d.getPrefWidth(), d.getPrefHeight());
		region.setMinSize(d.getMinWidth(), d.getMinHeight());
		region.setMaxSize(d.getMaxWidth(), d.getMaxHeight());
	}
	public static void setSvgGraphic(Pane pane, RectangularDimension d, String svgPath, double graphicRatio) {
		Region rgn = createFillerRegion(new StaticRectangularDimension((d.getPrefWidth()*graphicRatio), (d.getPrefHeight()*graphicRatio)));
		SVGPath svg = new SVGPath();
		svg.setContent(svgPath);
		rgn.setShape(svg);
		setBackgroundColor(rgn, "black");
		pane.getChildren().add(rgn);
	}
	public static void setSvgGraphic(Pane pane, RectangularDimension d, String svgPath, String color, double graphicRatio) {
		Region rgn = createFillerRegion(new StaticRectangularDimension((d.getPrefWidth()*graphicRatio), (d.getPrefHeight()*graphicRatio)));
		SVGPath svg = new SVGPath();
		svg.setContent(svgPath);
		rgn.setShape(svg);
		setBackgroundColor(rgn, color);
		pane.getChildren().add(rgn);
	}
	public static void setSvgGraphic(Pane pane, RectangularDimension d, String svgPath, Color color, double graphicRatio) {
		Region rgn = createFillerRegion(new StaticRectangularDimension((d.getPrefWidth()*graphicRatio), (d.getPrefHeight()*graphicRatio)));
		SVGPath svg = new SVGPath();
		svg.setContent(svgPath);
		rgn.setShape(svg);
		setBackgroundColor(rgn, color);
		pane.getChildren().add(rgn);
	}
	public static void setGraphic(Pane pane, Region graphic) {
		pane.getChildren().clear();
		pane.getChildren().add(graphic);
	}
	public static Region createSvgGraphic(RectangularDimension d, String svgPath, Color color, double graphicRatio) {
		Region rgn = createFillerRegion(new StaticRectangularDimension((d.getPrefWidth()*graphicRatio), (d.getPrefHeight()*graphicRatio)));
		SVGPath svg = new SVGPath();
		svg.setContent(svgPath);
		rgn.setShape(svg);
		setBackgroundColor(rgn, color);
		return rgn;
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
		Region rgn = createFillerRegion(new StaticRectangularDimension((d.getPrefWidth()*graphicRatio), (d.getPrefHeight()*graphicRatio)));
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
		Region rgn = createFillerRegion(new StaticRectangularDimension((d.getPrefWidth()*graphicRatio), (d.getPrefHeight()*graphicRatio)));
		SVGPath svg = new SVGPath();
		svg.setContent(svgPath);
		rgn.setShape(svg);
		setBackgroundColor(rgn, "black");
		btn.setGraphic(rgn);
		return btn;
	}
	public static URL createURL(String path) {
		URL url = null;
		try {
			url = Paths.get(path).toUri().toURL();
		} catch (java.net.MalformedURLException e) {
			e.printStackTrace();
		}
		return url;
	}
	
	public static void bindDimention(DoubleProperty binder, ObservableNumberValue bindee) {
		binder.bind(bindee);
	}
	public static void bindHeight(Region n1, Region n2) {
		n1.prefHeightProperty().bind(n2.heightProperty());
	}
	public static void bindWidth(Region n1, Region n2) {
		n1.prefWidthProperty().bind(n2.widthProperty());
	}
}
