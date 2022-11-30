package threading.CharPrinter;

public class Main {
    public static void main(String[] args) {
        Thread t1 = new CharPrinter('*');
        Thread t2 = new CharPrinter('x');
        t1.start();
        t2.start();

        Thread t3 = new Thread(new BetterCharPrinter('0'));
        t3.start();

        System.out.println("Done main");
    }
}
