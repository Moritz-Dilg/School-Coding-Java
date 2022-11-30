package threading.bankaccount;

public class Main {
    public static void main(String[] args) {
        Account account = new Account();
        Thread withdrawer = new Thread(new Withdrawer(account));
        Thread depositor = new Thread(new Depositer(account));
        withdrawer.start();
        depositor.start();
        try {
            withdrawer.join();
            depositor.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(account.getBalance());
    }
}
