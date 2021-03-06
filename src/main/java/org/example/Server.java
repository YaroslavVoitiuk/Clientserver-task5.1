package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server extends Thread {
    private static final int TWO_FIBONACCI = 2;
    private static final int ZERO_FIBONACCI = 0;
    private static final int ONE_FIBONACCI = 1;
    private static final int PORT = 12345;

    @Override
    public void run() {
        try (ServerSocket servSocket = new ServerSocket(PORT);
             Socket socket = servSocket.accept();
             PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
            String input;
            while ((input = reader.readLine()) != null) {
                System.out.println("SERVER: обработка данных клиента...");
                Thread.sleep(500);
                writer.println(calculate(input));
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace(System.out);
        }
    }

    public long calculate(String input) {
        int n = Integer.parseInt(input);
        if (n < TWO_FIBONACCI) {
            return n;
        } else {
            long result = ZERO_FIBONACCI;
            long n1 = ZERO_FIBONACCI;
            long n2 = ONE_FIBONACCI;
            for (n--; n > ZERO_FIBONACCI; n--) {
                result = n1 + n2;
                n1 = n2;
                n2 = result;
            }
            return result;
        }
    }
}