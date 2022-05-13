package util;

public class InvalidRGBAValueException extends Exception{
	private static final long serialVersionUID = -3492370121517387132L;
	public InvalidRGBAValueException() {
		super();
	}
	public InvalidRGBAValueException(String reason) {
		super(reason);
	}
}
