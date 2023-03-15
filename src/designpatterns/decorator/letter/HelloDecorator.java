package designpatterns.decorator.letter;

public class HelloDecorator implements Letter {
    private final Letter letter;
    private final String name;

    public HelloDecorator(Letter letter, String name) {
        this.letter = letter;
        this.name = name;
    }

    @Override
    public String getText() {
        return "Hello " + name + ",\n\n" + letter.getText();
    }
}
