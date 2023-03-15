package designpatterns.decorator.letter;

/**
 * The concrete letterComponent realizing the real letter. Contains the content text of the letter.
 */
public class ContentLetter implements Letter {

    private String text;

    /**
     * Constructor initializing the letter text.
     */
    public ContentLetter() {
        this.text = "";
    }

    @Override
    public String getText() {
        return text;
    }

    /**
     * Appends a line at the end of the letter text.
     *
     * @param line the line to be added.
     */
    public void appendLine(String line) {
        text = text + line + "\n";
    }

}
