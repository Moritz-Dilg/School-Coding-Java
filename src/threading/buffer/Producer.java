package threading.buffer;

public class Producer implements Runnable {
    private final Buffer buffer;
    private String name;

    public Producer(Buffer buffer, String name) {
        this.buffer = buffer;
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 60; i++) {
            try {
                String s = name + " - " + i;
                buffer.put(s);
                System.out.println(s);

                Thread.sleep((int) (Math.random() * 1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
