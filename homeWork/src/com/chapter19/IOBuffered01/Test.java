package com.chapter19.IOBuffered01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Test {
    public static void main(String[] args) {
        String FilePath ="G:\\test.txt";
        BufferedReader br = null;
        String line="";
        try {
           br = new BufferedReader(new FileReader(FilePath));
           //循环读取
            while ((line=br.readLine())!=null){
                System.out.println(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
