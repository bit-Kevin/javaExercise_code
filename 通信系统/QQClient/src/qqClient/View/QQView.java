package qqClient.View;

import qqClient.Server.FileServer;
import qqClient.Server.UserClientServer;
import qqClient.Utility.utility;

public class QQView {
    public static void main(String[] args) {
        QQView qqView = new QQView();
        qqView.MainView();
    }

    UserClientServer userClientServer = new UserClientServer(null);//用于检查登录和注册用户
    FileServer fileServer = new FileServer();
    boolean loop = true;
    String key;
    String userID;
    String content;

    //显示主界面
    public void MainView() {
        while (loop) {
            System.out.println("==========欢迎登录网络通信系统=========");
            System.out.println("\t\t1 登录系统");
            System.out.println("\t\t2 退出系统");
            System.out.println("请输入你的选择：");
            key = utility.readString(1);
            //2判断输入字符
            switch (key) {
                case "1":
                    System.out.println("请输入ID：");
                    userID = utility.readString(10);
                    System.out.println("请输入密码：");
                    String passWord = utility.readString(10);
                    if (userClientServer.CheckUser(userID, passWord)) {
                        //和服务器进行验证判定
                        System.out.println("========== "+userID+" 登录成功=========");
                        while (loop) {
                            System.out.println("==========网络通信系统二级菜单（用户 " + userID + "）=========");
                            System.out.println("\t\t1 显示在线用户");
                            System.out.println("\t\t2 群发消息");
                            System.out.println("\t\t3 私发消息");
                            System.out.println("\t\t4 发送文件");
                            System.out.println("\t\t9 退出系统");
                            System.out.println("请输入你的选择：");
                            key = utility.readString(1);
                            switch (key) {
                                case "1":
                                    System.out.println("显示人数");
                                    userClientServer.GetOnlineFriend();
                                    break;
                                case "2":
                                    System.out.print("内容：");
                                    content = utility.readString(100);
                                    System.out.println(userID+"对所有人说："+content);
                                    userClientServer.ToAllChat(content);
                                    break;
                                case "3":
                                    System.out.print("请输入私聊对象：");
                                    userID = utility.readString(10);
                                    System.out.print("内容：");
                                    content = utility.readString(100);
                                    userClientServer.PrivateChat(userID,content);
                                    break;
                                case "4":
                                    System.out.println("接收好友");
                                    String Receive = utility.readString(10);
                                    System.out.println("文件地址（格式 G:xx.txt");
                                    String src = utility.readString(30);
                                    System.out.println("目标地址（格式 G:yy.txt");
                                    String dest = utility.readString(30);
                                    fileServer.SendFile(userID,Receive,dest,src);
                                    break;
                                case "9":
                                    userClientServer.abandon();
                                    loop =false;
                                    break;
                            }
                            try {
                                Thread.sleep(500);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
            }
        }
    }
}
