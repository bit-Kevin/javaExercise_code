package Server;

import General.Message;
import General.MessageType;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class ServerConnectClientThread  extends  Thread{
    private Socket socket;
    private String userID;//线程名字就是对接的用户id


    public ServerConnectClientThread(Socket socket, String userID) {
        this.socket = socket;
        this.userID = userID;
    }

    DP dp=new DP();
    public Socket getSocket() {
        return socket;
    }

    public String getUserID() {
        return userID;
    }

    ObjectInputStream ois;
    ObjectOutputStream oos;
    ServerConnectClientThread RThread;

    @Override
    public void run() {
        while (true){
            //用循环一直监听该用户
            System.out.println(userID+"服务线程正在运行...");
            //用一个读取流来读取收到的对象流，如果，没有会一直堵塞在这
            try {
                //每次读取都会拆封一次头部序列化信息
                ois = new ObjectInputStream(socket.getInputStream());
                 Message ms =(Message) ois.readObject();
                 //如果接收到消息就判断消息类型
                if (ms.getMesType().equals(MessageType.MESSAGE_GET_ONLINE_FRIEND)){
                    Message message = new Message();
                    //设置消息内容
                    message.setMesType(MessageType.MESSAGE_RET_ONLINE_FRIEND);
                    message.setContent(ManageServerConnectClientThread.GetOnlineUser());
                    message.setReceiver(ms.getSender());
                    //返回消息给客户端
                    oos=new ObjectOutputStream(socket.getOutputStream());
                    oos.writeObject(message);
                    System.out.println("服务端返回在线用户数据给"+userID);
                }else if (ms.getMesType().equals(MessageType.MESSAGE_CLIENT_EXIT)){
                    //如果消息是关闭服务的

                    //回一个空消息，让客户端线程退出
                    Message message = new Message();
                    oos=new ObjectOutputStream(socket.getOutputStream());
                    oos.writeObject(message);
                    ManageServerConnectClientThread.RemoveThread(userID);                    //释放线程资源
                    System.out.println(userID+"退出");
                    socket.close();
                    break;

                }else if (ms.getMesType().equals(MessageType.MESSAGE_COMM_MES)){
                    //如果是普通私聊消息
                    //判断接收者是谁，并判断是否在线
                   RThread = ManageServerConnectClientThread.GetServerConnectClientThread(ms.getReceiver());
                    if (RThread!=null){
                        //转发消息
                         oos=  new ObjectOutputStream(RThread.socket.getOutputStream());
                         oos.writeObject(ms);
                         System.out.println("服务器已经转发来自"+userID+"的私聊消息");
                    }else {
                        //判断是查无此人，还是离线
                        System.out.println("查无此人");
                        if (QQServer.CheckUser(ms.getReceiver())) {
                            //存入离线库
                            dp.Add(ms.getReceiver(), ms);
                            System.out.println("加入成功");
                        }else {
                            System.out.println("转发失败：" + ms.getReceiver() + "用户不存在");
                            oos =new ObjectOutputStream(socket.getOutputStream());
                            oos.writeObject(ms);
                            //消息打回
                        }
                    }

                }else if (ms.getMesType().equals(MessageType.MESSAGE_TO_ALL)){
                    //如果是群发消息类型
                    //获取当前所有用户线程的socket
                    HashMap<String, ServerConnectClientThread> hm = ManageServerConnectClientThread.getHm();
                    //遍历发送消息
                    Set<String> users= hm.keySet();
                    Iterator<String> iterator = users.iterator();
                    while (iterator.hasNext()){
                        String user = iterator.next();//next不能被调用两次
                        if (!user.equals(userID)){
                            oos = new ObjectOutputStream(ManageServerConnectClientThread.GetServerConnectClientThread(user).socket.getOutputStream());
                            oos.writeObject(ms);
                        }
                    }
                    System.out.println("转发了来自"+ms.getSender()+"的群消息");
                }else if (ms.getMesType().equals(MessageType.MESSAGE_FILE_MES)){
                    //文件消息
                    //获取接受者的线程
                    RThread = ManageServerConnectClientThread.GetServerConnectClientThread(ms.getReceiver());
                    oos = new ObjectOutputStream(RThread.socket.getOutputStream());
                    oos.writeObject(ms);
                    System.out.println(ms.getSender()+"发文佳到"+ms.getReceiver()+ms.getDest());
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
