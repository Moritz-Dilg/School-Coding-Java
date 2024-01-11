package inheritance.newsfeed;

public class PhotoPost extends Post {
    private final String filename;
    private final String caption;

    PhotoPost(String username, String filename, String caption) {
        super(username);
        this.filename = filename;
        this.caption = caption;
    }

    String getFilename() {
        return filename;
    }

    String getCaption() {
        return caption;
    }

    String display() {
        return filename + ": " + caption + super.display();
    }
}
