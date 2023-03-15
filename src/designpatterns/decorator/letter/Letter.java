package designpatterns.decorator.letter;

/**
 * Abstract base class for the letterComponent and the decorators
 */
public interface Letter {

    /**
     * Gets the letter text.
     *
     * @return the text of the letter.
     */
    abstract public String getText();

}
