package Server;

import General.Message;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class DP {
    public static HashMap<String, ArrayList<Message>> hm = new HashMap<>();
    public ArrayList<Message> al;

    public void Add(String user, Message message){
        if ((al=hm.get(user))==null){
            al = new ArrayList<>();
        }
        al.add(message);
        hm.put(user,al);
    }

    public void Delete(String user){
        hm.remove(user);
    }
    public ArrayList<Message> GetMessage(String user){
       return hm.get(user);
    }

    public String GetUser(){
        Iterator<String> iterator = hm.keySet().iterator();
        String users = "";
        while (iterator.hasNext()){
            String next=(String) iterator.next();
            users+= next+" ";
        }
        return users;
    }
}
