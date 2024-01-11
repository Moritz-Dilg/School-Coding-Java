package interfaces;

import java.util.Iterator;

public record Tokenizer(String sentence) implements Iterable<String> {

    public String[] getTokens() {
        return sentence.split(" ");
    }

    @Override
    public Iterator<String> iterator() {
        return new Iterator<String>() {
            private final String[] strings = getTokens();
            private int counter = 0;

            @Override
            public boolean hasNext() {
                return counter < strings.length;
            }

            @Override
            public String next() {
                return strings[counter++];
            }
        };
    }
}

