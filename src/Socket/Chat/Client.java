package Socket.Chat;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 1234)) {
            InputStream inputStream = socket.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            OutputStream outputStream = socket.getOutputStream();
            PrintWriter outPrintWriter = new PrintWriter(outputStream, true);

            // Get History
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("type", 1);
            outPrintWriter.println(jsonObject);

            JSONObject historyPayload = new JSONObject(bufferedReader.readLine());
            JSONArray history = (JSONArray) historyPayload.get("history");
            System.out.println("Previous conversation");
            for (int i = 0; i < history.length(); i++) {
                printMessage((JSONObject) history.get(i));
            }

            PostThread postThread = new PostThread(outPrintWriter);
            postThread.start();

            while (true) {
                String payload = bufferedReader.readLine();
                printMessage(payload);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void printMessage(String payload) {
        if (payload.length() != 0) {
            printMessage(new JSONObject(payload));
        }
    }

    public static void printMessage(JSONObject jsonPayload) {
        System.out.println(jsonPayload.get("name") + ": " + jsonPayload.get("message"));
    }
}

class PostThread extends Thread {
    private final PrintWriter outPrintWriter;

    public PostThread(PrintWriter outPrintWriter) {
        this.outPrintWriter = outPrintWriter;
    }

    @Override
    public void run() {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            String message = scanner.next();

            JSONObject newMessage = new JSONObject();
            newMessage.put("type", 0);
            newMessage.put("name", "Moritz");
            newMessage.put("message", message);
            outPrintWriter.println(newMessage);
        }
    }
}
