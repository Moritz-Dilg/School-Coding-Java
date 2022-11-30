package threading.bankaccount;

public class Withdrawer implements Runnable {
    private final Account account;

    public Withdrawer(Account account) {
        this.account = account;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            account.withdraw(i);
        }
    }
}
