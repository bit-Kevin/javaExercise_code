package com.chapter20.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        //监听9999 端口
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("正在监听9999端口。。。");
        //如果有客户机链接，把接收的值赋给socket
        Socket socket = serverSocket.accept();
        System.out.println(socket.getClass());

        //定义输入流
        int len;
        byte[] bytes= new byte[1024] ;
        InputStream inputStream = socket.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        OutputStream outputStream = socket.getOutputStream();
        System.out.println(bufferedReader.readLine());

        //字符流发送
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
        bufferedWriter.write("你好客户机");
        bufferedWriter.newLine();
        bufferedWriter.flush();


        serverSocket.close();
        socket.close();
        bufferedWriter.close();
        bufferedReader.close();

    }
}
