package com.chapter20.socket2;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws Exception {
        //监听9999号端口
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("正在监听...");
        //创建一个socket 用来接收请求
        Socket socket = serverSocket.accept();
        //接收图片
        InputStream inputStream = socket.getInputStream();
        byte[] bytes = StreamUtils.streamToByteArray(inputStream);
        //把数据写入指定位置
        String FilePath ="G:\\back.png";
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(FilePath));
        bos.write(bytes);

        bos.close();
        inputStream.close();
        serverSocket.close();
        socket.close();
    }
}
