package com.chapter12;
//自定义异常处理
public class  exception2 {
    public static void main(String[] args) {
        int a  = 101;
        if (!(a>0&&a<100)){
            throw new AException("你输入的数有误");
        }
        System.out.println("执行完毕");
    }
}
//继承然后改写父类错误信息
class AException extends RuntimeException{

    public AException(String message) {
        super(message);
    }
}