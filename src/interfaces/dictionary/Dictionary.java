package interfaces.dictionary;

import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public class Dictionary {
    public static void main(String[] args) {
        Dictionary dictionary = new Dictionary();
        dictionary.insert("hello", "hallo");
        dictionary.insert("goodbye", "auf wiedersehen");

        System.out.println(dictionary.lookupGermanWord("hello"));
        System.out.println(dictionary.lookupGermanWord("goodbye"));
    }

    private final Set<Word> words;

    public Dictionary() {
        words = new TreeSet<>();
    }

    public void insert(String english, String german) {
        words.add(new Word(english, german));
    }

    public String lookupGermanWord(String english) {
        for (Word word : words) {
            if (word.english.equals(english)) {
                return word.german;
            }
        }
        return "";
    }


    private static class Word implements Comparable<Word> {
        String english;
        String german;

        Word(String english, String german) {
            this.english = english;
            this.german = german;
        }

        @Override
        public int hashCode() {
            return Objects.hash(english, german);
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof Word word) {
                return english.equals(word.english);
            }
            return false;
        }

        @Override
        public int compareTo(Word o) {
            return this.equals(o) ? 0 : 1;
        }
    }
}
