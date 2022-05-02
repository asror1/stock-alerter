package tools;

public class RectangularDimention {
	private Double maxHeight;
	private Double maxWidth;
	private Double minWidth;
	private Double minHeight;
	private double prefHeight;
	private double prefWidth;
	public RectangularDimention(double prefWidth, double prefHeight) {
		this(prefWidth,prefHeight,20000.0, 20000.0);
	}
	public RectangularDimention(double prefWidth, double prefHeight, Double  maxWidth, Double maxHeight) {
		this(prefWidth,prefHeight,maxWidth == null ? 20000.0 : maxWidth,maxHeight == null ? 20000.0 : maxHeight ,0.0,0.0);
	}
	public RectangularDimention(double prefWidth, double prefHeight, Double maxWidth, Double maxHeight, Double minWidth, Double minHeight) {
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
		if(minHeight==null)return prefHeight;
		return minHeight;
	}
	public void setMinHeight(double minHeight) {
		this.minHeight = minHeight;
	}
	public double getMinWidth() {
		if(minWidth==null)return prefWidth;
		return minWidth;
	}
	public void setMinWidth(double minWidth) {
		this.minWidth = minWidth;
	}
	public double getMaxWidth() {
		if(maxWidth==null)return prefWidth;
		return maxWidth;
	}
	public void setMaxWidth(double maxWidth) {
		this.maxWidth = maxWidth;
	}
	public double getMaxHeight() {
		if(maxHeight==null)return prefHeight;
		return maxHeight;
	}
	public void setMaxHeight(double maxHeight) {
		this.maxHeight = maxHeight;
	}
}
