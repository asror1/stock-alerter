package components.stock.view;

import java.util.LinkedList;

import components.stock.model.StockPrice;
import javafx.beans.property.ReadOnlyDoubleProperty;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Data;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import util.FXTools;
import util.dimension.DynamicRectangularDimension;

public class ChartView extends StockView {
	
	protected StackPane container = new StackPane();
	protected HBox stockInfo = new HBox();
	protected LineChart<String, Number> lineChart;
	
	
	protected XYChart.Series<String, Number> dataSeries = new XYChart.Series<>();
	protected CategoryAxis xAxis = new CategoryAxis();
	protected NumberAxis yAxis;
			
	protected LinkedList<StockPrice> dayPrice;
	protected int lowerBound,upperBound;
	
	public ChartView(ReadOnlyDoubleProperty fullWidth, ReadOnlyDoubleProperty watchlistWidth, LinkedList<StockPrice> dayPrice, String ticker){
		super(dayPrice, ticker);
		try {
			loadData();
			setStyle();
			FXTools.setBackgroundColor(container, Color.web("#212035"));
			FXTools.bindDimention(container.prefWidthProperty(), fullWidth.subtract(watchlistWidth));
			container.setPadding(new Insets(10,30,20,10));
			container.getChildren().addAll(loadIcon(),loadChart(), loadInfo());	
		} catch(StockChartInitException e) {
			e.printStackTrace();
		}
		
	}
	private void setStyle() {
		xAxis.setStartMargin(0);
		xAxis.setTickMarkVisible(false);
		xAxis.setTickLabelsVisible(false);
		stockInfo.setAlignment(Pos.TOP_RIGHT);
		container.setAlignment(Pos.TOP_CENTER);
	}
	private HBox loadIcon() {
		HBox iconContainer = new HBox();
		iconContainer.setAlignment(Pos.CENTER);
		FXTools.setSvgGraphic(iconContainer, new DynamicRectangularDimension(900,900), "M212,168v40a4.01467,4.01467,0,0,1-.079.7832c-.02344.11817-.0675.22754-.1012.34131a2.33467,2.33467,0,0,1-.32727.78809c-.05578.102-.10046.208-.16589.30566a4.01417,4.01417,0,0,1-1.10767,1.10791c-.10083.06738-.21.11377-.31518.17139a2.3237,2.3237,0,0,1-.779.32226c-.11426.0337-.22351.07764-.34168.10108A3.98812,3.98812,0,0,1,208,212H168a4,4,0,0,1,0-8h30.34338L45.17188,50.82861a3.99991,3.99991,0,0,1,5.65624-5.65722L204,198.34326V168a4,4,0,0,1,8,0Zm-.079-120.7832c-.02356-.11866-.06775-.228-.10144-.34229a2.34186,2.34186,0,0,0-.32861-.79c-.05542-.10107-.09961-.20556-.16419-.30273a4.01567,4.01567,0,0,0-1.10937-1.10889c-.09485-.06347-.19763-.10644-.29627-.16064a3.8938,3.8938,0,0,0-.39221-.20655,4.0383,4.0383,0,0,0-.39563-.123c-.11719-.03467-.22949-.07959-.35083-.10352a3.99082,3.99082,0,0,0-.76843-.07764L208,44H168a4,4,0,0,0,0,8h30.34351l-50.54468,50.54443a3.99975,3.99975,0,1,0,5.65625,5.65674L204,57.65674V88a4,4,0,0,0,8,0V48A4.01467,4.01467,0,0,0,211.921,47.2168Zm-109.3761,100.582-57.373,57.37256a3.99991,3.99991,0,1,0,5.65624,5.65722l57.37305-57.373a3.99975,3.99975,0,0,0-5.65625-5.65674Z",Color.web("#393e65"), 0.7);
		return iconContainer;
	}
	private LineChart<String,Number> loadChart() throws StockChartInitException{
		try {
			lineChart = new LineChart<>(xAxis, yAxis);
			lineChart.setLegendVisible(false);
			lineChart.getData().add(dataSeries);
			lineChart.setStyle("");
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(lineChart == null) throw new StockChartInitException("Chart was unable to load");
		}
		return lineChart;
	}
	private void loadData() throws StockChartInitException{
		try {
			double price = 0.0d;
			for(var e: dayPrice) {
				price = e.getAvgPrice();
				if(price==0) {
					lowerBound = upperBound = (int) price;
				} else {
					if(price > upperBound) upperBound = (int) (10 * Math.round(price / 10));
					else lowerBound = (int) (10 * Math.round(price / 10));
				}
				dataSeries.getData().add(new Data<>(e.getDate(),price));
			}
		} catch (Exception e) {
//			e.printStackTrace();
		} finally {
			if(lowerBound == 0 || upperBound == 0) {
				lowerBound = 0;
				upperBound = 100;
			}
			yAxis = new NumberAxis(lowerBound, upperBound, 20);
			yAxis.setTickMarkVisible(false);
			yAxis.setMinorTickVisible(false);
		}
	}
		
	private HBox loadInfo() {
		VBox legendContainer = new VBox();
		legendContainer.getChildren().add(new Label("Stock Text"));
		stockInfo.getChildren().add(legendContainer);
		return stockInfo;
	}
	@Override
	public void update(StockPrice price) {
		if(upperBound < price.getAvgPrice()) upperBound = (int) (10 * Math.round(price.getAvgPrice()/ 10));
		else if(lowerBound > price.getAvgPrice()) lowerBound = (int) (10 * Math.round(price.getAvgPrice() / 10));
		this.yAxis=new NumberAxis((lowerBound-10),(upperBound+10),20);
		this.dayPrice.add(price);
		this.dataSeries.getData().add(new Data<>(price.getDate(),price.getAvgPrice()));
		this.lineChart.getData().add(dataSeries);
	}
	

	@Override
	public Pane loadView() {
		return container;
	}	
}