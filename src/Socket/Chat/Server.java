package Socket.Chat;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.stream.Collectors;

import org.json.JSONObject;

public class Server {
    public static void main(String[] args) {
        ArrayList<JSONObject> history = new ArrayList<>();
        ArrayList<PrintWriter> writers = new ArrayList<>();

        try (ServerSocket server = new ServerSocket(1234)) {
            while (true) {
                final Socket socket = server.accept();
                new ConnectionThread(socket, history, writers).start();
                System.out.println("New connection");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}

class ConnectionThread extends Thread {
    private final Socket socket;
    private final ArrayList<JSONObject> history;
    private final ArrayList<PrintWriter> writers;

    public ConnectionThread(Socket socket, ArrayList<JSONObject> history, ArrayList<PrintWriter> writers) {
        this.socket = socket;
        this.history = history;
        this.writers = writers;
    }

    @Override
    public void run() {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter outPrintWriter = new PrintWriter(socket.getOutputStream(), true)) {
            synchronized (writers) {
                writers.add(outPrintWriter);
            }

            while (true) {
                String payload = bufferedReader.readLine();
                JSONObject jsonObject = new JSONObject(payload);
                System.out.println(jsonObject);

                int type = (int) jsonObject.get("type");
                if (type == 0) {
                    synchronized (writers) {
                        for (PrintWriter writer : writers) {
                            writer.println(jsonObject);
                        }
                    }
                    synchronized (history) {
                        history.add(jsonObject);
                    }
                } else if (type == 1) {
                    JSONObject returnObject = new JSONObject();
                    returnObject.put("type", 2);
                    synchronized (history) {
                        returnObject.put("history", history);
                    }
                    outPrintWriter.println(returnObject);
                    System.out.println(returnObject);
                } else if (type == 3) {
                    break;
                }
            }

            socket.shutdownOutput();
        } catch (IOException e) {
            try {
                socket.close();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }
}
