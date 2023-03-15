package designpatterns.decorator.letter;

public class DearDecorator implements Letter {
    private final Letter letter;
    private final String title;
    private final String lastName;

    public DearDecorator(Letter letter, String title, String lastName) {
        this.letter = letter;
        this.title = title;
        this.lastName = lastName;
    }

    @Override
    public String getText() {
        return "Dear " + title + " " + lastName + ",\n\n" + letter.getText();
    }
}
