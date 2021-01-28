package com.objcat.playground.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {
    final int port = 5209;

    public static void main(String[] args) {
        SocketServer socketServer = new SocketServer();
        socketServer.start2();
    }

    /**
     * 异步客户端
     */
    public void start2() {
        try {
            ServerSocket server = null;
            try {
                //创建一个ServerSocket在端口5209监听客户请求
                server = new ServerSocket(this.port);
                System.out.println("服务器启动成功 127.0.0.1:" + this.port);
            } catch (Exception e) {
                System.out.println("没有启动监听：" + e);
            }
            Socket socket = null;

            while (true) {
                try {
                    //2、调用accept()方法开始监听，等待客户端的连接
                    //使用accept()阻塞等待客户请求，有客户
                    //请求到来则产生一个Socket对象，并继续执行
                    socket = server.accept();
                } catch (Exception e) {
                    System.out.println("Error." + e);
                }

                //由Socket对象得到输入流，并构造相应的BufferedReader对象
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String line = in.readLine();
                System.out.println(line);
            }

            //3、获取输入流，并读取客户端信息

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void start() {
        try {
            ServerSocket server = null;
            try {
                //创建一个ServerSocket在端口5209监听客户请求
                server = new ServerSocket(this.port);
                System.out.println("服务器启动成功 127.0.0.1:" + this.port);
            } catch (Exception e) {
                System.out.println("没有启动监听：" + e);
            }
            Socket socket = null;
            try {
                //2、调用accept()方法开始监听，等待客户端的连接
                //使用accept()阻塞等待客户请求，有客户
                //请求到来则产生一个Socket对象，并继续执行
                socket = server.accept();
            } catch (Exception e) {
                System.out.println("Error." + e);
            }
            //3、获取输入流，并读取客户端信息
            String line;
            //由Socket对象得到输入流，并构造相应的BufferedReader对象
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            //在标准输出上打印从客户端读入的字符串
            System.out.println("Client:" + in.readLine());
            //由Socket对象得到输出流，并构造PrintWriter对象
            PrintWriter out = new PrintWriter(socket.getOutputStream());
            //由系统标准输入设备构造BufferedReader对象
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            //从标准输入读入一字符串
            line = br.readLine();
            //4、获取输出流，响应客户端的请求
            while (!line.equals("end")) {
                out.println(line);
                out.flush();
                System.out.println("Server:" + line);
                System.out.println("Client:" + in.readLine());
                line = br.readLine();
            }
            in.close();
            out.close();
            socket.close();
            server.close();
        } catch (Exception e) {//出错，打印出错信息
            System.out.println("Error." + e);
        }
    }
}
