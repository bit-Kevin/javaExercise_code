package qqClient.Server;

import java.util.HashMap;

public class ManageClientConnectServerThread {
    //管理线程
    private static HashMap<String,ClientConnectServerThread> hm = new HashMap<>();
    //添加线程
    public static void AddClientConnectServerThread(String userID,ClientConnectServerThread thread){
        hm.put(userID,thread);
    }
    //获取线程
    public static  ClientConnectServerThread GetClientConnectServerThread(String userID){
       return hm.get(userID);
    }
    public static  void RemoveThread(String userID){hm.remove(userID);}
}
