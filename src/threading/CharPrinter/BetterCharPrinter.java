package threading.CharPrinter;

public class BetterCharPrinter extends Thread{
    private char signal;

    public BetterCharPrinter(char signal){
        this.signal = signal;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.print(signal);
            int delay = (int) (Math.random() * 1000);
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                e.printStackTrace();
                return;
            }
        }
    }
}
