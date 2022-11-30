package threading.waitingroom;

public class Main {
    public static void main(String[] args) {
        Waitingroom waitingroom = new Waitingroom();
        Thread doctor1 = new Thread(new Doctor(waitingroom, 1));
        Thread doctor2 = new Thread(new Doctor(waitingroom, 2));
        doctor1.start();
        doctor2.start();
        for (int i = 0; i < 100; i++) {
            new Thread(new Patient(waitingroom, i)).start();
        }
    }
}
