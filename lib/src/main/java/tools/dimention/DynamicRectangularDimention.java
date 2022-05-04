package tools.dimention;

public class DynamicRectangularDimention extends RectangularDimention {
	public DynamicRectangularDimention(double prefWidth, double prefHeight, double minWidth, double minHeight) {
		super(prefWidth, prefHeight, Double.valueOf(Integer.MAX_VALUE), Double.valueOf(Integer.MAX_VALUE), minWidth, minHeight);
	}
	public DynamicRectangularDimention(double prefWidth, double prefHeight) {
		super(prefWidth, prefHeight, Double.valueOf(Integer.MAX_VALUE), Double.valueOf(Integer.MAX_VALUE), prefWidth, prefHeight);
	}
}
