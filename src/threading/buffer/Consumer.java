package threading.buffer;

public class Consumer implements Runnable {
    private final Buffer buffer;
    private final String name;

    public Consumer(Buffer buffer, String name) {
        this.buffer = buffer;
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 60; i++) {
            try {
                String s = buffer.get();
                System.out.println(name + " - " + s);

                Thread.sleep((int) (Math.random() * 1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
