package geek.brains2_6;

import java.io.*;
import java.net.Socket;

public class Client {
    private DataInputStream inputStream;
    private DataOutputStream outputStream;
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public Client(Socket socket) throws IOException {
        inputStream = new DataInputStream(socket.getInputStream());
        outputStream = new DataOutputStream(socket.getOutputStream());
    }

    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 8189)) {
            System.out.println("Клиент запущен.");
            Client client = new Client(socket);
            Thread getMessage = new Thread(client::messageGet);
            Thread sendMessage = new Thread(client::messageSend);
            sendMessage.start();
            getMessage.start();
            getMessage.join();
            sendMessage.join();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void messageSend() {
        while (true) {
            try {
                String message = reader.readLine();
                if (!message.trim().isEmpty()) {
                    if (message.equalsIgnoreCase("/exit")) System.exit(0);
                    outputStream.writeUTF(message);
                    System.out.println("Сообщение отправлено.");
                }
            } catch (IOException e) {
                e.printStackTrace();
                break;
            }
        }
    }

    public void messageGet() {
        while (true) {
            try {
                String message = inputStream.readUTF();
                System.out.println("Сервер написал: " + message);
            } catch (IOException e) {
                System.out.println("Сервер недоступен.");
                System.exit(0);
                break;
            }
        }
    }
}