package components.stock;

public class StockChartInitException extends Exception {

	private static final long serialVersionUID = -8700849787275440865L;
	public StockChartInitException() {
		super();
	}
	public StockChartInitException(String reason) {
		super(reason);
	}
}
