package qqClient.Server;

import General.Message;
import General.MessageType;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

public class ClientConnectServerThread extends Thread {
    boolean loop = true;

    String userID;

    //用构造器接收一个套接字
    Socket socket;

    public ClientConnectServerThread( Socket socket,String userID) {
        this.userID = userID;
        this.socket = socket;
    }

    //为了更方便地得到构造器
    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        //使用循环来保持和服务端一直保持联系
        while (loop){
            try {

                //!!!重点 如果管道内没有数据，读取流这个操作会一直堵塞在这。直到读取到一个对象流
                ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
                Message ms =(Message) objectInputStream.readObject();
                //判断接收到的消息类型
                //如果返回的是在线用户
                if (ms.getMesType().equals(MessageType.MESSAGE_RET_ONLINE_FRIEND)){
                    //把发来的用户名进行分割
                    String[] users = ms.getContent().split(" ");
                    System.out.println("=======当前在线好友=======");
                    for (int i =0;i<users.length;i++){
                        System.out.println("用户："+users[i]);
                    }
                }else if (ms.getMesType().equals(MessageType.MESSAGE_COMM_MES)){
                    //先判断是不是被打回的消息
                    if (ms.getSender().equals(userID)){
                        System.out.println("你所的好友"+ms.getReceiver()+"不在线");
                    }else {
                        System.out.println(ms.getSender()+":"+ms.getContent()+"\t"+ms.getSendTime());
                    }
                }else if (ms.getMesType().equals(MessageType.MESSAGE_TO_ALL)){
                    System.out.println(ms.getSender()+"对所有人说："+ms.getContent()+"\t"+ms.getSendTime());
                }else if (ms.getMesType().equals(MessageType.MESSAGE_FILE_MES)){
                    System.out.println(ms.getSender()+"发送文件"+ms.getSrc()+"到我的电脑"+ms.getDest()+"处");
                    FileOutputStream fos = new FileOutputStream(ms.getDest());
                    fos.write(ms.getData(),0, ms.getLen());
                    fos.close();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        //退出循环以后关闭所有资源
        try {

            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
