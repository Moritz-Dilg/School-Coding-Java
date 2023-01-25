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

        try (ServerSocket server = new ServerSocket(1234)) {
            while (true) {
                final Socket socket = server.accept();
                new ConnectionThread(socket, history).start();
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

    public ConnectionThread(Socket socket, ArrayList<JSONObject> history) {
        this.socket = socket;
        this.history = history;
    }

    @Override
    public void run() {
        PrintWriter outPrintWriter = null;
        try {
            InputStream inputStream = socket.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            OutputStream outputStream = socket.getOutputStream();
            outPrintWriter = new PrintWriter(outputStream, true);

            while (true) {
                String payload = bufferedReader.readLine();
                JSONObject jsonObject = new JSONObject(payload);
                System.out.println(jsonObject);

                int type = (int) jsonObject.get("type");
                if (type == 0) {
                    outPrintWriter.println(jsonObject);
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
            if (outPrintWriter != null) outPrintWriter.close();
        }
    }
}
