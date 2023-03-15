package designpatterns.decorator.letter;

public class YoursSincerelyDecorator implements Letter {
    private final Letter letter;
    private final String firstName;
    private final String lastName;

    public YoursSincerelyDecorator(Letter letter, String firstName, String lastName) {
        this.letter = letter;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String getText() {
        return letter.getText() + "\nYours sincerely,\n" + firstName + " " + lastName;
    }
}
