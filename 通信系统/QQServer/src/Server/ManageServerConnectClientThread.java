package Server;

import java.util.HashMap;
import java.util.Iterator;

public class ManageServerConnectClientThread {
    private static HashMap<String,ServerConnectClientThread> hm = new HashMap<>();

    public static HashMap<String, ServerConnectClientThread> getHm() {
        return hm;
    }

    //添加线程
    public static void AddServerConnectClientThread(String userID,ServerConnectClientThread thread){
        hm.put(userID,thread);
    }
    //获取线程
    public static  ServerConnectClientThread GetServerConnectClientThread(String userID){
        return hm.get(userID);
    }
    //获取在线用户
    public static String GetOnlineUser(){
        //通过KeySet 来获取用户名
        Iterator iterator = hm.keySet().iterator();
        String OnlineUser ="";
        //循环判断并获取用户名
        while(iterator.hasNext()){
            String next=(String) iterator.next();
            OnlineUser += next+" ";
        }
        return OnlineUser;
    }
    public static  void RemoveThread(String userID){hm.remove(userID);}
}
