package com.chapter20.socket2;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
    public static void main(String[] args) throws Exception {
        //建立链接
        String s ="10.16.158.57";
        Socket socket = new Socket(s, 9999);
        String FilePath = "G:\\test2.png";
        //把文件数据导入
        BufferedInputStream bis= new BufferedInputStream(new FileInputStream(FilePath));
        //把文件数据存到字节数组里面
        byte[] bytes= StreamUtils.streamToByteArray(bis);
        //调用socket的输出流
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write(bytes);
        socket.shutdownOutput();//结束传输

        outputStream.close();
        bis.close();

    }
}
