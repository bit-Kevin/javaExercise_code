package Server;

import General.Message;
import General.MessageType;
import General.User;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ConcurrentHashMap;

public class QQServer {
    //创建套接字
    IsOnline isOnline = null;
    ServerSocket ss = null;
    //创建一个用户集合，充当数据库
    private static ConcurrentHashMap<String,User> Users = new ConcurrentHashMap<>();
    static {
        Users.put("菩提老祖",new User("菩提老祖","123456"));
        Users.put("至尊宝",new User("至尊宝","123456"));
        Users.put("紫霞仙子",new User("紫霞仙子","123456"));
        Users.put("牛魔王",new User("牛魔王","123456"));
        Users.put("铁扇公主",new User("铁扇公主","123456"));
        Users.put("111",new User("111","123"));
        Users.put("222",new User("222","123"));
    }


    Socket socket;

    //检测用户是否存在
    public   boolean CheckUser(String userID,String PassWord){
        //从数据库里匹配用户
        User user = Users.get(userID);
        //如果返回的是null就是返回假
        if (user ==null){
            return false;
        }
        //如果有就判定密码是否匹配
        if (!PassWord.equals(user.getPassWord())){
            return false;
        }
        return true;
    }
    //检测用户是否存在
    public static   boolean CheckUser(String userID){
        //从数据库里匹配用户
        User user = Users.get(userID);
        //如果返回的是null就是返回假
        if (user ==null){
            return false;
        }

        return true;
    }
    public QQServer(){

        //打开广播线程
        new SendNewsToAllServer().start();
        isOnline = new IsOnline();
        //监听端口，接收对象
        try {
            ss = new ServerSocket(9999);
            //循环监听
            while (true){
                System.out.println("服务端正在监听9999号端口...");
                socket = ss.accept();
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                User user = (User) ois.readObject();
                Message message=new Message();
                ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                //判断用户是否存在
                if (CheckUser(user.getUserID(), user.getPassWord())){
                    //返回验证信息
                    message.setMesType(MessageType.MESSAGE_LOGIN_SUCCEED);
                    oos.writeObject(message);
                    //socket.shutdownOutput();
                    //创建对接的线程socket
                    ServerConnectClientThread thread = new ServerConnectClientThread(socket,user.getUserID());
                    thread.start();
                    //把线程加入到线程管理结集合里面去
                    ManageServerConnectClientThread.AddServerConnectClientThread(user.getUserID(), thread);
                    //判断是否有离线消息
                    isOnline.UserIsHaveMessage(user.getUserID());

                }else {
                    //返回验证登入失败的消息
                    message.setMesType(MessageType.MESSAGE_LOGIN_FAIL);
                    oos.writeObject(message);
                    //socket.shutdownOutput();
                }
            }
        } catch (Exception e) {
                e.printStackTrace();
        } finally {
            try {
                ss.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }



    }

}
