package io2.nio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class BIOServer {
    static byte[] msg = new byte[1024];
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8888);
            while (true){

                System.out.println("wait conn ...");
                // 可能产生阻塞
                Socket clientSocket = serverSocket.accept();

                System.out.println("conn success");

                System.out.println("wait msg ...");
                // 可能产生阻塞
                // 如果一个用户在这里发生了阻塞，其他用户就无法连接
                clientSocket.getInputStream().read(msg);
                System.out.println(new String(msg));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
