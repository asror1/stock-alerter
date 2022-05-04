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
		else if(color.startsWith("#")) {
			int red = 0, green = 0, blue = 0;
			color = color.substring(1).toUpperCase();
			switch(color.length()) {
			case 2: 
				red = hexToDecimal(color);
				this.setRed(red);
				this.setGreen(0.0);
				this.setBlue(0.0);
				break;
			case 4: 
				red = hexToDecimal(color.substring(0, 2));
				green = hexToDecimal(color.substring(2,4));
				this.setRed(red);
				this.setGreen(green);
				this.setBlue(0.0);
				break;
			case 6: 
				red = hexToDecimal(color.substring(0, 2));
				green = hexToDecimal(color.substring(2,4));
				blue = hexToDecimal(color.substring(4,6));
				this.setRed(red);
				this.setGreen(green);
				this.setBlue(blue);
				break;
			default: throw new InvalidRGBAValueException("The hex color is invalid: #"+color);
			}
		}
		else throw new InvalidRGBAValueException("This color is not implemented: "+color);
		return this;
		
	}
	static int hexToDecimal(String hexNumber) {
		String hex = "0123456789ABCDEF";
		hexNumber = hexNumber.toUpperCase();
		int value = 0;
		for(int i=0;i<hexNumber.length();++i) {
			char c = hexNumber.charAt(i);
			int d = hex.indexOf(c);
			value = value*16+d;
		}
		return value;
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

