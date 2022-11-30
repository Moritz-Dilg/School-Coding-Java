package threading.buffer;

public class Main {
    public static void main(String[] args) {
        Buffer buffer = new Buffer();
        Thread producer1 = new Thread(new Producer(buffer, "Producer 1"));
        Thread producer2 = new Thread(new Producer(buffer, "Producer 2"));
        Thread consumer = new Thread(new Consumer(buffer, "Consumer"));
        producer1.start();
        producer2.start();
        consumer.start();
    }
}
