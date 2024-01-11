package inheritance.newsfeed;

import java.util.Random;

public class Post {
    private final String username;
    private int likes;
    private final long timestamp;

    Post(String username) {
        this.username = username;
        this.likes = 0;
        this.timestamp = System.currentTimeMillis();
    }

    void like() {
        likes++;
    }

    void dislike() {
        likes--;
        if (likes < 0) likes = 0;
    }

    String display() {
        return " (From: " + username + ", " + likes + " Like" + (likes != 1 ? "s," : ",") + " posted " + timeString() + " ago)";
    }

    String timeString() {
        long diffTime = System.currentTimeMillis() - timestamp;
        double seconds = (double) diffTime / 1000;
        double minutes = seconds / 60;
        seconds = (int) (minutes - Math.floor(minutes)) * 60;
        int min = (int) Math.floor(minutes);
        int sec = (int) ((minutes - Math.floor(minutes)) * 60);

        return min + ":" + sec;
    }
}
