package components.watchlist;

import components.stock.view.ItemView;
import javafx.beans.property.ReadOnlyDoubleProperty;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Ellipse;
import javafx.scene.text.Font;
import javafx.scene.transform.Rotate;
import util.FXTools;
import util.dimension.DynamicRectangularDimension;
import util.dimension.StaticRectangularDimension;

public class WatchlistComponent extends HBox implements Watchlist {
	
	private VBox buttonContainer = new VBox();
	private VBox stockContainer = new VBox();
	private ScrollPane scrollPane = new ScrollPane();
	protected boolean isOpen = true;
	public static final int PREF_WIDTH = 410;
	
	public WatchlistComponent(ReadOnlyDoubleProperty fullHeight) {
		super();
		scrollPane.setHbarPolicy(ScrollBarPolicy.NEVER);
		scrollPane.setVbarPolicy(ScrollBarPolicy.NEVER);
		try {
		
			if(!loadButton()) throw new Exception("Button container unable to load");
			if(!loadStockContainer()) throw new Exception("Button container unable to load");
					
		} catch (Exception e) {
			e.printStackTrace();
		}
		FXTools.setRegionSize(scrollPane, new DynamicRectangularDimension(300,0));
		getChildren().addAll(scrollPane,buttonContainer);
		FXTools.bindDimention(prefHeightProperty(), fullHeight);
		
	}

	private boolean loadStockContainer() {
		HBox header = new HBox();
		header.setAlignment(Pos.CENTER_LEFT);
		try {
			FXTools.setBackgroundColor(scrollPane, Color.valueOf("black"));
			FXTools.setRegionSize(stockContainer, new DynamicRectangularDimension(300, 0));	
			scrollPane.setContent(stockContainer);
			FXTools.setRegionSize(header, new StaticRectangularDimension(300,60));
			FXTools.setBackgroundColor(header, "#272424");
			
			FXTools.setInlinePadding(header, 0, 15);
			header.getChildren().addAll(loadProfileImage(),loadHeaderText());
			stockContainer.getChildren().add(header);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	private Ellipse loadProfileImage() {
		Ellipse profileImg = new Ellipse(20,20);
		Image img = new Image("C:\\Users\\Asror\\Desktop\\java-projects\\iconImage.jpg");
		profileImg.setFill(new ImagePattern(img));
		
		return profileImg;
	}
	private Label loadHeaderText() {
		Label headerText = new Label("watchlist");
		FXTools.setInlinePadding(headerText, 0, 75);
		headerText.setFont(Font.font("Space Grotesk, Times New Roman"));
		headerText.setFont(new Font(17));
		return headerText;
	}
	private boolean loadButton() {
		HBox button = new HBox();
		button.setAlignment(Pos.CENTER);
		buttonContainer.setAlignment(Pos.CENTER);
		try {
			
			FXTools.setBackgroundColor(buttonContainer, Color.valueOf("#212035"));
			FXTools.setBorder(button, "black", 1,1);
			FXTools.setRegionSize(buttonContainer, new DynamicRectangularDimension(35, 0));
			FXTools.setBorder(buttonContainer, "black", 0, new BorderWidths(1,1,1,0));
			FXTools.setBackgroundColor(button, Color.web("#585268"));
			FXTools.setRegionSize(button, new StaticRectangularDimension(35,100.0));
			Rotate r = new Rotate();r.setAngle(180); r.setPivotX(8);r.setPivotY(8);
			Region region = FXTools.createSvgGraphic(new StaticRectangularDimension(35,35), "M122.55,560.23c10.876,10.204,25.07,15.824,39.965,15.824c14.448,0,28.33-5.403,39.086-15.216l251.715-229.607 "
					+ "    c12.049-10.99,18.959-26.647,18.959-42.954c0-16.309-6.91-31.964-18.959-42.954L201.602,15.716  "
					+ "   C190.845,5.904,176.964,0.5,162.515,0.5c-14.896,0-29.089,5.619-39.965,15.823c-5.68,5.329-10.155,11.63-13.3,18.727    "
					+ " c-3.298,7.442-4.97,15.389-4.97,23.62v459.214c0,8.231,1.672,16.179,4.971,23.621C112.396,548.603,116.871,554.902,122.55,560.23    "
					+ " z M147.121,58.67c0-9.17,7.511-15.33,15.395-15.33c3.546,0,7.169,1.247,10.216,4.026l251.714,229.607   "
					+ "  c6.651,6.068,6.651,16.54,0,22.607L172.731,529.188c-3.048,2.78-6.669,4.026-10.216,4.026c-7.883,0-15.396-6.161-15.396-15.33    "
					+ " L147.121,58.67L147.121,58.67z",Color.web("#212035"), 0.5);
			region.getTransforms().add(r);
			FXTools.setGraphic(button, region);
			buttonContainer.getChildren().add(button);
			button.setOnMousePressed(event ->{
				if(isOpen) {
					region.getTransforms().add(r);
					getChildren().remove(scrollPane);
					isOpen=false;
				}
				else {
					region.getTransforms().remove(r);
					getChildren().add(0, scrollPane);
					isOpen=true;
				}
			});
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public void add(ItemView stock) {
		stockContainer.getChildren().add(stock.loadView());
		stockContainer.setPrefHeight(stockContainer.getPrefHeight()+ItemView.PREF_HEIGHT);
		
		
	}

	@Override
	public void remove(ItemView stock) {
		stockContainer.getChildren().remove(stock.loadView());
		stockContainer.setPrefHeight(stockContainer.getPrefHeight()-ItemView.PREF_HEIGHT);
	}


}
