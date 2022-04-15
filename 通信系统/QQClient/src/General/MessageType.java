package General;

public interface MessageType {
    String MESSAGE_LOGIN_SUCCEED ="1";//表示登录成功
    String MESSAGE_LOGIN_FAIL = "2";//表示登录失败
    String MESSAGE_COMM_MES = "3";//普通消息
    String MESSAGE_GET_ONLINE_FRIEND = "4";//获取在线好友人数
    String MESSAGE_RET_ONLINE_FRIEND = "5";//返回在线好友人数
    String MESSAGE_TO_ALL= "6";//群发消息类型
    String MESSAGE_FILE_MES = "7";//文件传输类型
    String MESSAGE_CLIENT_EXIT = "9"; //退出客户端

}
