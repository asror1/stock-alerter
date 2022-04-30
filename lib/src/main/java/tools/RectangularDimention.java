package tools;

public class RectangularDimention {
	private double maxHeight;
	private double maxWidth;
	private double minWidth;
	private double minHeight;
	private double prefHeight;
	private double prefWidth;
	public RectangularDimention(double prefWidth, double prefHeight) {
		this(prefWidth,prefHeight,Integer.MAX_VALUE, Integer.MAX_VALUE);
	}
	public RectangularDimention(double prefWidth, double prefHeight, double maxWidth, double maxHeight) {
		this(prefWidth,prefHeight,maxWidth,maxHeight,0.0,0.0);
	}
	public RectangularDimention(double prefWidth, double prefHeight, double maxWidth, double maxHeight, double minWidth, double minHeight) {
		this.setPrefWidth(prefWidth);
		this.setPrefHeight(prefHeight);
		this.setMaxWidth(maxWidth);
		this.setMaxHeight(maxHeight);
		this.setMinWidth(minWidth);
		this.setMinHeight(minHeight);
	}
	public double getPrefWidth() {
		return prefWidth;
	}
	public void setPrefWidth(double prefWidth) {
		this.prefWidth = prefWidth;
	}
	public double getPrefHeight() {
		return prefHeight;
	}
	public void setPrefHeight(double prefHeight) {
		this.prefHeight = prefHeight;
	}
	public double getMinHeight() {
		return minHeight;
	}
	public void setMinHeight(double minHeight) {
		this.minHeight = minHeight;
	}
	public double getMinWidth() {
		return minWidth;
	}
	public void setMinWidth(double minWidth) {
		this.minWidth = minWidth;
	}
	public double getMaxWidth() {
		return maxWidth;
	}
	public void setMaxWidth(double maxWidth) {
		this.maxWidth = maxWidth;
	}
	public double getMaxHeight() {
		return maxHeight;
	}
	public void setMaxHeight(double maxHeight) {
		this.maxHeight = maxHeight;
	}
}
