package designpatterns.mvc.magicMarbles.magicmarbles.model;

/**
 * The exception class for exceptions with the magic marble game
 */
public class MMException extends Exception {

	private static final long serialVersionUID = 8614515858833371347L;
	
	/**
	 * Constructor
	 * @param message the message of the exception
	 */
	public MMException(String message) {
		super(message);
	}
}
