package Socket.Chat;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private String name;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

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

            PostThread postThread = new PostThread(outPrintWriter, name);
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
    private final String name;

    public PostThread(PrintWriter outPrintWriter, String name) {
        this.outPrintWriter = outPrintWriter;
        this.name = name;
    }

    @Override
    public void run() {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            String message = scanner.next();

            JSONObject newMessage = new JSONObject();
            newMessage.put("type", 0);
            newMessage.put("name", name);
            newMessage.put("message", message);
            outPrintWriter.println(newMessage);
        }
    }
}
