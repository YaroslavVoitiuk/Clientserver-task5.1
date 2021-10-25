package org.example;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client extends Thread {
    private static final int PORT = 12345;
    private static final String HOST = "127.0.0.1";

    @Override
    public void run() {
        Socket socket = null;
        try {
            socket = new Socket(HOST, PORT);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            assert socket != null;
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                 PrintWriter writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
                 Scanner scanner = new Scanner(System.in)) {
                String data;
                //while (true) {
                    System.out.println("Введите число для подсчёта...");
                    data = scanner.nextLine();
                    writer.println(data);
               //     if ("end".equals(data)) break;
                    System.out.println("SERVER RESPONSE: " + reader.readLine());
                //}
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
