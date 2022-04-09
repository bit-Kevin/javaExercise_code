package com.chapter20.UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UDP1 {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new  DatagramSocket(9998);

        byte[] data = "明天吃火锅".getBytes();
        //把要发的数据封装到数据包里面去
        DatagramPacket toPacket = new DatagramPacket(data, 0, data.length, InetAddress.getLocalHost(),9999);
        socket.send(toPacket);

        //接收回复消息
        byte[] data2 = new byte[1024];
        DatagramPacket rsPacket =new DatagramPacket(data2,data2.length);
        socket.receive(rsPacket);
        //拆封数据包
        int len =rsPacket.getLength();
        byte[] temp = rsPacket.getData();
        String s = new String(temp,0,len);
        System.out.println(s);

        socket.close();



    }
}
