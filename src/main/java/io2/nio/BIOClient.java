package io2.nio;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class BIOClient {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("127.0.0.1", 8888);
            Scanner sc = new Scanner(System.in);
            String next = sc.next();
            socket.getOutputStream().write(next.getBytes());
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
