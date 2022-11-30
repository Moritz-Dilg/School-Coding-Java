package threading.bankaccount;

public class Account {
    private int balance;
    private final Object monitor = new Object();

    public Account() {
        balance = 0;
    }

    public void deposit(int amount) {
        synchronized (monitor) {
            balance = complexLogic(balance + amount);
        }
    }

    public void withdraw(int amount) {
        synchronized (monitor) {
            balance = complexLogic(balance - amount);
        }
    }

    public int getBalance() {
        return balance;
    }

    private int complexLogic(int b) {
        int delay = (int) (Math.random() * 1000);
        try {
            Thread.sleep(delay);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }

        return b;
    }
}
