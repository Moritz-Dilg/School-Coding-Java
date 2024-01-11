package inheritance.newsfeed;

public class MessagePost extends Post {
    private final String message;

    MessagePost(String username, String message) {
        super(username);
        this.message = message;
    }

    String getMessage() {
        return message;
    }

    String display() {
        return message + super.display();
    }
}
