package threading.waitingroom;

public class Patient implements Runnable{
    private final Waitingroom waitingroom;
    public final int id;

    public Patient(Waitingroom waitingroom, int id) {
        this.waitingroom = waitingroom;
        this.id = id;
    }

    public void treat() {
        System.out.println("Patient " + id + " is treated");
    }

    @Override
    public void run() {
        waitingroom.enter(this);
    }
}
