package Server;

import General.Message;
import General.MessageType;
import Utility.utility;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class SendNewsToAllServer extends Thread {
    //发送消息给全部用户
    Message message;
    ObjectOutputStream oos;
    @Override
    public void run() {
        while (true){
            message=new Message();
            message.setMesType(MessageType.MESSAGE_TO_ALL);
            message.setSender("服务器");
            System.out.print("请输入通知内容：");
            String s =utility.readString(100);
            if ("exit".equals(s)){
                break;
            }
            message.setContent(s);
            message.setSendTime(new Date().toString());

            //获取当前在线用户集合
            HashMap<String, ServerConnectClientThread> hm = ManageServerConnectClientThread.getHm();
            Set<String> users = hm.keySet();
            Iterator<String> iterator = users.iterator();
            while (iterator.hasNext()){
                String user = iterator.next();
                try {
                    oos=new ObjectOutputStream(ManageServerConnectClientThread.GetServerConnectClientThread(user).getSocket().getOutputStream());
                    oos.writeObject(message);
                    System.out.println("已向全部用户广播");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("退出广播");
    }
}
