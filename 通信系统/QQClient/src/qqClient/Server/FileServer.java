package qqClient.Server;

import General.Message;
import General.MessageType;

import java.io.*;

public class FileServer {

    public void SendFile(String sender, String receiver, String dest, String src) {

        Message message = new Message();
        message.setSender(sender);
        message.setMesType(MessageType.MESSAGE_FILE_MES);
        message.setReceiver(receiver);
        message.setSrc(src);
        message.setDest(dest);
        //创建文件流
        FileInputStream fileInputStream=null;
        byte[] Data = new byte[(int) new File(src).length()];
        try {
            fileInputStream = new FileInputStream(src);
            int len= fileInputStream.read(Data);
            message.setLen(len);
            message.setData(Data);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fileInputStream!=null){
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        System.out.println(sender+"将文件 "+src+"发送给了："+receiver+"的"+dest+"路径下");

        try {
            ObjectOutputStream oos = new ObjectOutputStream(ManageClientConnectServerThread.GetClientConnectServerThread(sender).socket.getOutputStream());
            oos.writeObject(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
