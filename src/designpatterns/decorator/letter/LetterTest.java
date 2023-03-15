package designpatterns.decorator.letter;

public class LetterTest {
    public static void main(String[] args) {
        ContentLetter letter = new ContentLetter();
        letter.appendLine("This is a test letter.");
        letter.appendLine("It has two lines.");

        Letter formalLetter =
                new DateDecorator(
                        new DearDecorator(
                                new YoursSincerelyDecorator(
                                        letter,
                                        "Paul",
                                        "Smith"),
                                "Mrs.",
                                "Brown")
                );

        System.out.println(formalLetter.getText());
        System.out.println();
        System.out.println("--------------------------------------------------");

        Letter informalLetter =
                new HelloDecorator(
                        new BestWishesDecorator(
                                letter,
                                "Paul",
                                "Smith"),
                        "Susan");
        System.out.println(informalLetter.getText());
    }
}
