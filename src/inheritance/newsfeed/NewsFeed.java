package inheritance.newsfeed;

import java.util.ArrayList;

public class NewsFeed {
    private static final ArrayList<Post> posts = new ArrayList<>();

    public static void main(String[] args) {
        addPosts(new MessagePost("BigH", "I bin da beste"));
        addPosts(new MessagePost("BigH", "I bin da olla beste"));
        addPosts(new PhotoPost("BigH", "nicePic.jpg", "This is a really nice pic"));

        posts.get(0).like();
        posts.get(1).like();
        posts.get(0).like();
        posts.get(1).like();
        posts.get(1).like();
        posts.get(2).like();
        posts.get(2).like();
        posts.get(1).dislike();
        posts.get(1).dislike();
        posts.get(1).dislike();
        posts.get(1).dislike();
        posts.get(2).dislike();

        showDetails();
    }

    static void addPosts(Post post) {
        posts.add(post);
    }

    static void showDetails() {
        for (Post post : posts) {
            System.out.println(post.display());
        }
    }
}
