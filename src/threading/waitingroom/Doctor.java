package threading.waitingroom;

public class Doctor implements Runnable{
    private final Waitingroom waitingroom;
    private final int id;

    public Doctor(Waitingroom waitingroom, int id) {
        this.waitingroom = waitingroom;
        this.id = id;
    }

    @Override
    public void run() {
        while (true) {
            Patient p = waitingroom.getPatient(id);

            try {
                Thread.sleep((int) (Math.random() * 1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
                return;
            }

            p.treat();
        }
    }
}
