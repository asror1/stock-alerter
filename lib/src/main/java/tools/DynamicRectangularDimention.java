package tools;

public class DynamicRectangularDimention extends RectangularDimention{

	public DynamicRectangularDimention(double prefWidth, double prefHeight, double minWidth, double minHeight) {
		super(prefWidth, prefHeight, Integer.MAX_VALUE, Integer.MAX_VALUE, minWidth, minHeight);
	}
	
}
