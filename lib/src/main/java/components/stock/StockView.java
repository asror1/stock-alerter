package components.stock;

import java.util.List;

import javafx.geometry.Pos;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Data;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

public class StockView {
	private Stock stock;
	private String ticker;
	private List<StockPrice> dayPrice;
	private Pane stockView;
	
	public StockView(Stock stock, String type) {
		this.stock = stock;
		this.ticker = stock.getTicker();
		this.dayPrice = stock.getDayPrice();
		if(type.matches("(?i)chart")){
			try {
				stockView = new Chart();
			} catch(Exception e) {
				e.printStackTrace();
			}
			
		}
		else if(type.matches("(?i)item")) {
			stockView = new Item();
		}
	}
	public Pane loadView() {
		return stockView;
	}
	private class Item extends HBox {
		public Item() {
			super();
		}
	}
	private class Chart extends StackPane {
		private XYChart.Series<String, Number> dataSeries = new XYChart.Series<>();
		private CategoryAxis xAxis = new CategoryAxis();
		private NumberAxis yAxis;
		private int lowerBound,upperBound;
				
		public Chart() throws StockChartInitException{
			super();
			setAlignment(Pos.TOP_CENTER);
			loadData();
			xAxis.setStartMargin(0);
			xAxis.setTickMarkVisible(false);
			xAxis.setTickLabelsVisible(false);
			yAxis.setTickMarkVisible(false);
			yAxis.setMinorTickVisible(false);
			getChildren().addAll(loadChart(), loadInfo());
		}
		
		public void loadData() throws StockChartInitException{
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
				if(lowerBound == 0 || upperBound == 0 || xAxis == null) throw new StockChartInitException("Data was not loaded properly");
			}
		}
		public LineChart<String,Number> loadChart() throws StockChartInitException{
			LineChart<String, Number> lineChart = null;
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
		
		public HBox loadInfo() {
			HBox stockInfo = new HBox();
			stockInfo.setAlignment(Pos.TOP_RIGHT);
			return stockInfo;
		}
	}
}
