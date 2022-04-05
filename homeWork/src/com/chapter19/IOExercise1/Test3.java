package com.chapter19.IOExercise1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test3 {
    public static void main(String[] args) {
        //创建输入流
        String FilePath= "F:\\back.png";
        FileInputStream fis =null;
        //创建输出流
        String ToFilePath="G:\\test2.png";
        FileOutputStream fos = null;
        byte[] bytes = new byte[1024];
        int len=0;

        try {
            //给流关联实体文件
            fis = new FileInputStream(FilePath);
            fos = new FileOutputStream(ToFilePath);
            //循环拷贝
            while((len=fis.read(bytes))!=-1){
                //把取出的数据写入到目标文件
                fos.write(bytes,0,len);
            }
            System.out.println("拷贝完成");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //关闭文件流
            try {
                fis.close();
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
