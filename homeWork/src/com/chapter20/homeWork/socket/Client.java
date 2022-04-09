package com.chapter20.homeWork.socket;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        //建立本地客户机.链接目标域名或者是ip地址，再加端口号
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        //定义端口输出流
        OutputStream outputStream = socket.getOutputStream();
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
        bufferedWriter.write("happy");
        //加入回车符和刷新
        bufferedWriter.newLine();//可以表示发送结束
        bufferedWriter.flush();

        InputStream inputStream = socket.getInputStream();

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        System.out.println(bufferedReader.readLine());

        bufferedReader.close();
        bufferedWriter.close();
        socket.close();



    }
}
