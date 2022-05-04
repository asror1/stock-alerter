package tools.dimension;

public class RectangularDimension {
	private Double maxHeight;
	private Double maxWidth;
	private Double minWidth;
	private Double minHeight;
	private double prefHeight;
	private double prefWidth;
	public RectangularDimension(double prefWidth, double prefHeight) {
		this(prefWidth,prefHeight,Double.valueOf(Integer.MAX_VALUE), Double.valueOf(Integer.MAX_VALUE));
	}
	public RectangularDimension(double prefWidth, double prefHeight, Double maxWidth, Double maxHeight) {
		this(prefWidth,prefHeight,maxWidth,maxHeight,0.0,0.0);
	}
	public RectangularDimension(double prefWidth, double prefHeight, Double maxWidth, Double maxHeight, Double minWidth, Double minHeight) {
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
	public void setMinHeight(Double minHeight) {
		this.minHeight = minHeight;
	}
	public double getMinWidth() {
		if(minWidth==null)return prefWidth;
		return minWidth;
	}
	public void setMinWidth(Double minWidth) {
		this.minWidth = minWidth;
	}
	public double getMaxWidth() {
		if(maxWidth==null)return prefWidth;
		return maxWidth;
	}
	public void setMaxWidth(Double maxWidth) {
		this.maxWidth = maxWidth;
	}
	public double getMaxHeight() {
		if(maxHeight==null)return prefHeight;
		return maxHeight;
	}
	public void setMaxHeight(Double maxHeight) {
		this.maxHeight = maxHeight;
	}
}
