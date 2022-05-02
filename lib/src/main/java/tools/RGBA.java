package tools;


public class RGBA {
	private double red;
	private double green;
	private double blue;
	private double alpha;
	public RGBA(double red, double green, double blue,double alpha) {
		try {
			if(red >255.0 || blue >255.0 || green > 255.0) throw new InvalidRGBAValueException("RGBA value cannot exceed 255.0 or be less than 0");
			this.setRed(red);
			this.setGreen(green);
			this.setBlue(blue);
		} catch(InvalidRGBAValueException e) {
			e.printStackTrace();
			System.err.printf("The returned value for %d instance is defaulted to (%s)%n",hashCode(), "red");
		}
	}
	public RGBA setColor(String color) throws InvalidRGBAValueException {
		if(color.matches("(?i)red")) {
			this.red = 255.0;
			this.green = 0;
			this.blue = 0;
			this.alpha = 1;
		}
		else if(color.matches("(?i)lime")) {
			this.green = 255.0;
			this.red = 0;
			this.blue = 0;
			this.alpha = 1;
		}
		else if(color.matches("(?i)blue")) {
			this.blue = 255.0;
			this.red = 0;
			this.green = 0;
			this.alpha = 1;
		}
		else if(color.matches("(?i)white")) {
			this.blue = 255.0;
			this.red = 255.0;
			this.green = 255.0;
			this.alpha = 1;
		}
		else if(color.matches("(?i)black")) {
			this.blue = 0;
			this.red = 0;
			this.green = 0;
			this.alpha = 1;
		}
		else if(color.matches("(?i)yellow")) {
			this.blue = 0;
			this.red = 255.0;
			this.green = 255.0;
			this.alpha = 1;
		}
		else if(color.matches("(?i)yellow")) {
			this.blue = 0;
			this.red = 255.0;
			this.green = 255.0;
			this.alpha = 1;
		}
		else if(color.matches("(?i)cyan")) {
			this.blue = 255.0;
			this.red = 0;
			this.green = 255.0;
			this.alpha = 1;
		}
		else if(color.matches("(?i)magenta")) {
			this.blue = 255.0;
			this.red = 255.0;
			this.green = 0;
			this.alpha = 1;
		}
		else if(color.matches("(?i)silver")) {
			this.blue = 192.0;
			this.red = 192.0;
			this.green = 192.0;
			this.alpha = 1;
		}
		else throw new InvalidRGBAValueException("This color is not implemented in this class "+color);
		return this;
		
	}
	public RGBA() {
		this(255.0,255.0,255.0,1);
	}
	public double getRed() {
		return red;
	}
	public RGBA setRed(double red) {
		this.red = red;
		return this;
	}
	public double getGreen() {
		return green;
	}
	public RGBA setGreen(double green) {
		this.green = green;
		return this;
	}
	public double getBlue() {
		return blue;
	}
	public RGBA setBlue(double blue) {
		this.blue = blue;
		return this;
	}
	public double getAlpha() {
		return alpha;
	}
	public RGBA setAlpha(double alpha) {
		this.alpha = alpha;
		return this;
	}
	
}

