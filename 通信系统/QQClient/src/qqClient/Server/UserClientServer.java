package qqClient.Server;

import General.Message;
import General.MessageType;
import General.User;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Date;

public class UserClientServer {
    Socket socket;
    User u ;
    boolean b ;
    ObjectOutputStream oos;
    ObjectInputStream ois;
    public UserClientServer(User u) {
        this.u = u;
    }

    //验证用户是否存在
    public boolean CheckUser(String UserID, String PassWord) {
        //把传进来的的Id和密码写入user对象
        // 创建套接字
        u = new User(UserID, PassWord);
        //把对象序列化
        try {
            //发送对象进行验证
            System.out.println("发送验证信息");
            socket = new Socket(InetAddress.getLocalHost(), 9999);
            oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(u);
            //socket.shutdownOutput();

            //接收服务端返回的信息
            System.out.println("接收验证结果");
            ois = new ObjectInputStream(socket.getInputStream());
            Message ms =(Message) ois.readObject();
            //进行消息类型判断
            if (ms.getMesType().equals(MessageType.MESSAGE_LOGIN_SUCCEED)){
                //如果是存在的就创建一个与服务器保持链接的线程
                ClientConnectServerThread ccst  = new ClientConnectServerThread(socket,u.getUserID());
                ccst.start();
                ManageClientConnectServerThread.AddClientConnectServerThread(UserID,ccst);
                b=true;
                }
            else if (ms.getMesType().equals(MessageType.MESSAGE_LOGIN_FAIL)){
                //如果登录失败，关闭套接字
                System.out.println("验证失败");
                socket.close();
                b= false; }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  b;
    }
    public void GetOnlineFriend(){
        //用户名已经在上一个方法传进来了，每个客户端只创建一个UserClientServer 所以现在这个类的user属性可以通用
        //创建消息类,并设置消息类型
        Message message =new Message();
        message.setMesType("4");
        message.setSender(u.getUserID());
        //通过当前用户id 从线程管理集合获取对应的对接线程
        try {
            //每次需要重新封装对象流的头部信息
            oos = new ObjectOutputStream(socket.getOutputStream());
            //发送消息
            oos.writeObject(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //退出客户端，终止线程。并通知服务端也终止对应的线程
    public void abandon(){
        //向服务端发送终止信息
        Message message = new Message();
        message.setSender(u.getUserID());
        message.setMesType(MessageType.MESSAGE_CLIENT_EXIT);
        try {
            //重新封装头部序列化信息
            oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(message);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("已退出系统");
        System.exit(0); //终止所有线程（终止虚拟机）
    }

    //实现给其他客户端发送消息
    public void PrivateChat(String receiver,String content){
        Message message = new Message();
        message.setMesType(MessageType.MESSAGE_COMM_MES);
        message.setSender(u.getUserID());
        message.setReceiver(receiver);
        message.setContent(content);
        message.setSendTime(new Date().toString());
        try {
            //重新封装头部序列化信息,并发送消息
            oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //实现给所有用户发送消息
    public void ToAllChat(String content){
        Message message = new Message();
        message.setSendTime(new Date().toString());
        message.setMesType(MessageType.MESSAGE_TO_ALL);
        message.setContent(content);
        message.setSender(u.getUserID());
        try {
            oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
