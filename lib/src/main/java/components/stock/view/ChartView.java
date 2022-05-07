package components.stock.view;

import java.util.LinkedList;

import components.stock.model.StockPrice;
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

public class ChartView extends StockView {
	
	protected StackPane container = new StackPane();
	protected XYChart.Series<String, Number> dataSeries = new XYChart.Series<>();
	protected HBox stockInfo = new HBox();
	protected CategoryAxis xAxis = new CategoryAxis();
	protected NumberAxis yAxis;
	protected LineChart<String, Number> lineChart;
		
	protected LinkedList<StockPrice> dayPrice;
	
	protected int lowerBound,upperBound;
	
	public ChartView(LinkedList<StockPrice> dayPrice, String ticker) throws StockChartInitException{
		super(dayPrice, ticker);
		loadData();
		setStyle();
		container.getChildren().addAll(loadChart(), loadInfo());
	}
	private void setStyle() {
		xAxis.setStartMargin(0);
		xAxis.setTickMarkVisible(false);
		xAxis.setTickLabelsVisible(false);
		stockInfo.setAlignment(Pos.TOP_RIGHT);
		container.setAlignment(Pos.TOP_CENTER);
	}
	private LineChart<String,Number> loadChart() throws StockChartInitException{
		try {
			lineChart = new LineChart<>(xAxis, yAxis);
			lineChart.setLegendVisible(false);
			lineChart.getData().add(dataSeries);
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
			e.printStackTrace();
		} finally {
			if(lowerBound == 0 || upperBound == 0) throw new StockChartInitException("Data was not loaded properly");
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
		this.dataSeries.getData().add(new Data<>(price.getDate(),price.getAvgPrice()));
		dayPrice.add(price);
		if(upperBound < price.getAvgPrice()) upperBound = (int) (10 * Math.round(price.getAvgPrice()/ 10));
		else if(lowerBound > price.getAvgPrice()) lowerBound = (int) (10 * Math.round(price.getAvgPrice() / 10));
		lineChart.getData().add(dataSeries);
	}
	

	@Override
	public Pane loadView() {
		return container;
	}	
}