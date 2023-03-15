package designpatterns.decorator.letter;

public class BestWishesDecorator implements Letter {
    private final Letter letter;
    private final String firstName;
    private final String lastName;

    public BestWishesDecorator(Letter letter, String firstName, String lastName) {
        this.letter = letter;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String getText() {
        return letter.getText() + "\nBest wishes,\n" + firstName + " " + lastName;
    }
}
