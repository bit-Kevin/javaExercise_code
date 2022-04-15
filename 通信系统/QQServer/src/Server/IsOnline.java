package Server;

import General.Message;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class IsOnline  {
    //从dp中取出用户，然后对比现在运行的线程
    DP dp = new DP();
    String[] users;
    String[] OnlineUsers;
    ObjectOutputStream oos;
    ArrayList<Message> messages;


    public void UserIsHaveMessage(String user) {
        //用自己去匹配离线哭
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //获取在线用户
         OnlineUsers = ManageServerConnectClientThread.GetOnlineUser().split(" ");
        if (OnlineUsers.length>1){
            //判断是否有发送给自己的离线消息
            users = dp.GetUser().split(" ");
            if (users[0]!=""&& users.length > 0) {
                // 循环判断是否有自己的离线消息
                for (int i = 0; i <users.length; i++) {
                    if (users[i].equals(user)) {
                        //用户上线，发送消息
                        try {
                            messages = dp.GetMessage(users[i]);
                            for (int k = 0; k < messages.size(); k++) {
                                oos = new ObjectOutputStream(ManageServerConnectClientThread.GetServerConnectClientThread(users[i]).getSocket().getOutputStream());
                                oos.writeObject(messages.get(k));

                            }
                            dp.Delete(users[i]);
                            System.out.println("离线消息发送成功");
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }

                }
            }
        }

        //获取需要判断并发送消息的用户



        }

}
