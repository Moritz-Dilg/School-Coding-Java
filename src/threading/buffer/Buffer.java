package threading.buffer;

public class Buffer {
    private static final int size = 4;
    private final String[] buffer = new String[size];
    private int tail = 0;
    private int head = 0;
    private int count = 0;

    public void put(String c) {
        synchronized (this) {
            while (count == size) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            buffer[tail] = c;
            tail = (tail + 1) % size;
            count++;

            notifyAll();
        }
    }

    public String get() {
        synchronized (this) {
            while (count == 0) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            String c = buffer[head];
            head = (head + 1) % size;
            count--;

            notifyAll();
            return c;
        }
    }
}
