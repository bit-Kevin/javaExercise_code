package com.chapter19.IOExercise1;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class Test2{
    public static void main(String[] args) {
        //创建文件的路径
        String FilePath = "G:\\test.txt";
        FileOutputStream fos = null;
        String s = "ykw,hello";
        try {
            fos = new FileOutputStream(FilePath,true);
            fos.write(s.getBytes(StandardCharsets.UTF_8),0,3);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
