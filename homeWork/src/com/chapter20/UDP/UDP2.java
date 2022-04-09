package com.chapter20.UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UDP2 {
    public static void main(String[] args) throws IOException {
        //确定端口
        DatagramSocket socket = new DatagramSocket(9999);
        //定义装数据包的容器
        byte[] bytes = new byte[1024];
        DatagramPacket dgp = new DatagramPacket(bytes,bytes.length);
        //调用接收方法
        socket.receive(dgp);
        //对数据包进行拆包
        int len = dgp.getLength();//获取实际的数据个数
        byte[] data = dgp.getData();//取出数据
        String s = new String(data, 0, len);
        System.out.println(s);
        //回复消息
        byte[] data2 = "好的，我知道了".getBytes();
        DatagramPacket datagramPacket = new DatagramPacket(data2, data2.length, InetAddress.getLocalHost(), 9998);//封装
        socket.send(datagramPacket);

        socket.close();
    }
}
