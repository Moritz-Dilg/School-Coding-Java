package threading.bankaccount;

public class Depositer implements Runnable {
    private final Account account;

    public Depositer(Account account) {
        this.account = account;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            account.deposit(i);
        }
    }
}
