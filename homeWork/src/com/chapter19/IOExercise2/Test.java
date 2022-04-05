package com.chapter19.IOExercise2;

import java.io.FileReader;
import java.io.IOException;

public class Test {
    public static void main(String[] args) {
        //创建字符流，不写入文件，直接打印 减少时间
        String FilePath = "G:\\test.txt";
        FileReader fr = null;
        char[] chars = new char[10];
        int len = 0;
        try {
            fr = new FileReader(FilePath);
            //reader 会返回读取到的个数
            while ((len=fr.read(chars))!=-1){
                System.out.print(new String(chars,0,len) );
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
