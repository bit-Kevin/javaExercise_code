package com.chapter20.homeWork.downLoad;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws Exception {
        //1监视端口
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("正在监听...");
        Socket socket = serverSocket.accept();


        //2判断接收的值
        InputStream inputStream = socket.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String FileName= bufferedReader.readLine();
        String answer ="";
        if (FileName.equals("高山流水")){
            answer = "G:\\高山流水.mp3";
        }else {
            answer = "G:\\无名.mp3";
        }
        System.out.println("用户想要的文件是："+FileName+" 实际返回的文件名："+answer);
        //3载入文件流
        FileInputStream fileInputStream = new FileInputStream(answer);
        byte[] data = StreamUtils.streamToByteArray(fileInputStream);

        //4发送数据流
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write(data);
        socket.shutdownOutput();

        //5关闭资源
        socket.close();
        serverSocket.close();
        bufferedReader.close();
        fileInputStream.close();
        outputStream.close();
    }
}
