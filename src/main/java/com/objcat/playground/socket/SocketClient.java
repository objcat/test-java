package com.objcat.playground.socket;

import java.io.*;
import java.net.Socket;

/**
 * description: SocketClient <br>
 * date: 2021/1/28 20:39 <br>
 * author: objcat <br>
 * version: 1.0 <br>
 */
public class SocketClient {
    public static void main(String[] args) {
        SocketClient socketClient = new SocketClient();
        socketClient.start();
    }

    public void start() {
        try {

            while (true) {
                Socket socket = new Socket("127.0.0.1", 5209);
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                String line = reader.readLine();
                System.out.println("发送" + line);
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                bufferedWriter.write(line + "\n");
                bufferedWriter.flush();
                socket.close();
            }


        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
