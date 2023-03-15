package designpatterns.decorator.letter;

public class DateDecorator implements Letter {
    private final Letter letter;

    public DateDecorator(Letter letter) {
        this.letter = letter;
    }

    @Override
    public String getText() {
        return letter.getText() + "\n" + new java.util.Date();
    }
}
