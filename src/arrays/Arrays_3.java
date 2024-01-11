package arrays;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class Arrays_3 {
    private static final DecimalFormat df2 = new DecimalFormat("#.##");
    private static final DecimalFormat df3 = new DecimalFormat("#.###");

    private static void bsp4() {
        ListWalter listWalter = new ListWalter();
        String[] name = {"Felix", "Flo", "Steve", "Mattl", "Simon", "Pascal", "Karim", "Sepp", "Justin", "Markus"};

        for (int i = 0; i < 10; i++) {
            listWalter.addFine(name[i], new Random().nextDouble(0.10, 20));
        }

        listWalter.printList();
        listWalter.finePaid(name[new Random().nextInt(10)]);
        listWalter.printList();
        listWalter.sortByAmount();
        listWalter.printList();
    }

    private static class ListWalter {
        ArrayList<String> name = new ArrayList<>();
        ArrayList<Double> fine = new ArrayList<>();

        private void addFine(String name, double amount) {
            if (this.name.contains(name)) {
                int idx = this.name.indexOf(name);
                this.fine.set(idx, this.fine.get(idx) + amount);

                return;
            }
            this.name.add(name);

            this.fine.add(amount);
        }

        private void printList() {
            for (int i = 0; i < this.name.size(); i++) {
                System.out.println(this.name.get(i) + " owns Walter " + df2.format(this.fine.get(i)) + "€");
            }
            System.out.println("");
        }

        private void finePaid(String name) {
            if (this.name.contains(name)) {
                int idx = this.name.indexOf(name);
                this.name.remove(idx);
                this.fine.remove(idx);
            }
        }

        private void sortByAmount() {
            for (int i = 0; i < name.size() - 1; i++) {
                for (int j = 0; j < name.size() - i - 1; j++) {
                    if (fine.get(j) <= fine.get(j + 1)) {
                        Collections.swap(name, j, j + 1);
                        Collections.swap(fine, j, j + 1);
                    }
                }
            }
        }
    }


    private static void bsp3() {
        CountWords countWords = new CountWords();
        Scanner scanner = new Scanner(System.in);
        String word = scanner.nextLine();

        while (!word.equals("ENDE")) {
            countWords.addWord(word);
            word = scanner.nextLine();
        }

        countWords.printWords();
    }

    private static class CountWords {
        ArrayList<String> words = new ArrayList<>();
        ArrayList<Integer> count = new ArrayList<>();

        private void addWord(String word) {
            if (this.words.contains(word)) {
                int idx = this.words.indexOf(word);
                this.count.set(idx, this.count.get(idx) + 1);
            } else {
                this.words.add(word);
                this.count.add(1);
            }
        }

        private void printWords() {
            for (int i = 0; i < words.size(); i++) {
                System.out.println("'" + words.get(i) + "' has been entered " + count.get(i) + " Times.");
            }

            int maxVal = Collections.max(count);
            int maxId = count.indexOf(maxVal);
            System.out.println("\n'" + words.get(maxId) + "' has been entered most often. (" + maxVal + ")");
        }
    }


    private static void bsp2() {
        ArrayList<schoolWayStatistics> statistics = new ArrayList<>();
        String[] name = {"Felix", "Flo", "Steve", "Mattl", "Simon", "Pascal", "Karim", "Sepp", "Justin", "Markus"};

        for (int i = 0; i < 10; i++) {
            statistics.add(new schoolWayStatistics(name[i]));
            for (int j = 0; j < 15; j++) {
                statistics.get(i).newTime(new Random().nextInt(15, 20));
            }
        }

        for (int i = 0; i < 10; i++) {
            System.out.println(statistics.get(i).getName() + ":\tAverage: " + df3.format(statistics.get(i).getAverage()) + " - Standard deviation: " + df3.format(statistics.get(i).getStandardDeviation()));
        }

        //Longest way to school
        double max_time = 0;
        String name_max = null;
        for (int i = 0; i < 10; i++) {
            if (max_time < statistics.get(i).getAverage()) {
                max_time = statistics.get(i).getAverage();
                name_max = statistics.get(i).getName();
            }
        }
        System.out.println("\nLongest way to school: " + name_max + " with " + df3.format(max_time));


        //Most constant way to school
        double smallest_StandardDeviation = 0;
        String name_smallest_StandardDeviation = null;
        for (int i = 0; i < 10; i++) {
            if (smallest_StandardDeviation > statistics.get(i).getStandardDeviation() || smallest_StandardDeviation == 0) {
                smallest_StandardDeviation = statistics.get(i).getStandardDeviation();
                name_smallest_StandardDeviation = statistics.get(i).getName();
            }
        }
        System.out.println("Most constant way to school: " + name_smallest_StandardDeviation + " with " + df3.format(smallest_StandardDeviation));
    }


    private static void bsp1() {
        schoolWayStatistics statistics = new schoolWayStatistics("NAME");
        for (int i = 0; i < 15; i++) {
            statistics.newTime(new Random().nextInt(15, 20));
        }
        System.out.println("Average: " + df3.format(statistics.getAverage()) + ", Standard deviation: " + df3.format(statistics.getStandardDeviation()));
    }

    private static class schoolWayStatistics {
        ArrayList<Integer> statistics = new ArrayList<>();
        String name;

        private schoolWayStatistics(String name) {
            this.name = name;
        }

        private void newTime(int time) {
            this.statistics.add(time);
        }

        private double getAverage() {
            double sum = 0;
            for (int x : statistics)
                sum += x;

            return sum / statistics.size();
        }

        private double getStandardDeviation() {
            double average = getAverage();

            int sum = 0;
            for (int x : statistics)
                sum += Math.pow(x - average, 2);

            return Math.sqrt((double) (sum) / (average * statistics.size()));
        }

        private String getName() {
            return this.name;
        }
    }
}
