package com.chapter20.homeWork.downLoad;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        //用户输入要下载的文件名
        Scanner scanner = new Scanner(System.in);
        String FileName = scanner.next();
        //将用户的文件名发送给服务端
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write(FileName.getBytes());
        socket.shutdownOutput();
        //接收服务端返回的文件
        byte[] data = StreamUtils.streamToByteArray(socket.getInputStream());
        // 写入到本地文件里面
        String FilePath = "G:\\"+FileName+"2.mp3";
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(FilePath));
        bufferedOutputStream.write(data);
        System.out.println("传输结束，下载完成");

        //关闭资源
        socket.close();
        outputStream.close();
        bufferedOutputStream.close();
    }
}
