package classes;

public class Classes {
    public static void main(String[] args) {
        /*--DATE--*/
        Date date1 = new Date(1, 1, 2020);
        Date date2 = new Date(1, 1, 2021);
        System.out.println(diffDate(date1, date2));

        /*--RECTANGLE--*/
        Rectangle r1 = new Rectangle(0, 0, 10, 10);
        Rectangle r2 = new Rectangle(5, 5, 10, 10);
        Rectangle r3 = intersection(r1, r2);
        System.out.println("X: " + r3.x + ", Y: " + r3.y + ", Width: " + r3.width + ", Height: " + r3.height);
    }


    /*--DATE--*/
    private static int diffDate(Date date1, Date date2) {
        //date1...first date
        //date2...second date
        Date date = date1;
        if (date1.year > date2.year) {
            //Swap dates
            date1 = date2;
            date2 = date;
        } else if (date1.year == date2.year) {
            if (date1.month > date2.month) {
                //Swap dates
                date1 = date2;
                date2 = date;
            } else if (date1.month == date2.month) {
                if (date1.day > date2.day) {
                    //Swap dates
                    date1 = date2;
                    date2 = date;
                } else if (date1.day == date2.day) {
                    return 0;
                }
            }
        }


        int days = 0;
        //Full years in between
        if (Math.abs(date1.year - date2.year) > 1) {
            days += (Math.abs(date1.year - date2.year) - 2) * 365;
        }

        if (date1.year != date2.year) {
            //Full months from first date until new year
            for (int i = date1.month + 1; i <= 12; i++) {
                days += getDaysInMonth(i);
            }
            //Full months until second date
            for (int i = 1; i < date2.month; i++) {
                days += getDaysInMonth(i);
            }
        } else {
            //Full months from first to second date
            for (int i = date1.month + 1; i < date2.month; i++) {
                days += getDaysInMonth(i);
            }
        }

        if (date1.month != date2.month || date1.year != date2.year) {
            //Days from first date until next month
            days += getDaysInMonth(date1.month) - date1.day;
            //Days until second date
            days += date2.day;
        } else {
            //Full days from first to second date
            days += date2.day - date1.day;
        }

        return days;
    }

    private static int getDaysInMonth(int month) {
        return switch (month) {
            case 1, 3, 5, 7, 8, 10, 12 -> 31;
            case 4, 6, 9, 11 -> 30;
            case 2 -> 28;
            default -> 0;
        };
    }

    private static class Date {
        int day;
        int month;
        int year;

        private Date(int day, int month, int year) {
            this.day = day;
            this.month = month;
            this.year = year;
        }
    }


    /*--RECTANGLE--*/
    private static Rectangle intersection(Rectangle r1, Rectangle r2) {
        Rectangle rectangle = new Rectangle(0, 0, 0, 0);
        rectangle.x = Math.max(r1.x, r2.x);
        rectangle.y = Math.max(r1.y, r2.y);
        rectangle.width = Math.min(r1.x + r1.width, r2.x + r2.width) - rectangle.x;
        rectangle.height = Math.min(r1.y + r1.height, r2.y + r2.height) - rectangle.y;

        if (rectangle.height < 0 || rectangle.width < 0) {
            return null;
        }
        return rectangle;
    }

    private static class Rectangle {
        int x, y;
        int width;
        int height;

        private Rectangle(int x, int y, int width, int height) {
            this.x = x;
            this.y = y;
            this.width = width;
            this.height = height;
        }
    }


    /*--ARTICLE--*/
    private static void printArticle(Article article) {
        System.out.println("Article number: " + article.articleNr + ", Revenue: " + article.singlePrice * article.sold);
    }

    private static Article readArticle(String input) {
        Article article = new Article();
        String[] parts = input.split(" ");
        article.articleNr = Integer.parseInt(parts[0]);
        article.singlePrice = Integer.parseInt(parts[1]);

        article.sold = 0;
        for (int i = 2; i < parts.length; i++) {
            article.sold += Integer.parseInt(parts[i]);
        }

        return article;
    }

    private static class Article {
        int articleNr;
        int singlePrice;
        int sold;
    }
}
