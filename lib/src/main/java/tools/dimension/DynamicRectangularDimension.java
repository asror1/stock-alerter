package tools.dimension;

public class DynamicRectangularDimension extends RectangularDimension {
	public DynamicRectangularDimension(double prefWidth, double prefHeight, double minWidth, double minHeight) {
		super(prefWidth, prefHeight, Double.valueOf(Integer.MAX_VALUE), Double.valueOf(Integer.MAX_VALUE), minWidth, minHeight);
	}
	public DynamicRectangularDimension(double prefWidth, double prefHeight) {
		super(prefWidth, prefHeight, Double.valueOf(Integer.MAX_VALUE), Double.valueOf(Integer.MAX_VALUE), prefWidth, prefHeight);
	}
}
