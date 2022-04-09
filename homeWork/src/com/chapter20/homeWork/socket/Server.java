package com.chapter20.homeWork.socket;

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

        //定义输入流

        InputStream inputStream = socket.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String s= bufferedReader.readLine();
        String revert = "";
        if (s.equals("name")){
            revert = "我是俞凯文";
        }else if (s.equals("happy")){
            revert = "敲代码";
        }else {
            revert = "我不知道你在说什么";
        }

        //字符流发送
        OutputStream outputStream = socket.getOutputStream();
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
        bufferedWriter.write(revert);
        bufferedWriter.newLine();
        bufferedWriter.flush();


        serverSocket.close();
        socket.close();
        bufferedWriter.close();
        bufferedReader.close();

    }
}
