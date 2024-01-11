package strings;

public class Strings_1 {
    public static void main(String[] args) {
        String s = "Hello World";
        System.out.println("'l' found " + count(s, "l") + " times in " + s);
        System.out.println(toUpper(s, "l"));
    }

    private static int count(String s, String toFind) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.startsWith(toFind, i)) {
                count++;
            }
        }

        return count;
    }

    private static String toUpper(String s, String toUpperCase) {
        return s.replaceAll(toUpperCase, toUpperCase.toUpperCase());
    }
}
