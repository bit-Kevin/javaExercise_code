package com.chapter19.IOExercise1;

import java.io.FileInputStream;
import java.io.IOException;

public class Test {
    public static void main(String[] args) {
        //创建流对象
        String FilePath = "G:\\hello.txt";//填写路径
        FileInputStream fis = null;
        byte[] b = new byte[8];
        int len ;//用于检查读取的个数
        try {
            fis = new FileInputStream(FilePath);
            while((len=fis.read(b))!=-1){
                //将字符打印,字节数组转为字符串
                System.out.print(new String(b,0,len));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //释放文件流
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
