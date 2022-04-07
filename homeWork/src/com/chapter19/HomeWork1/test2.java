package com.chapter19.HomeWork1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class test2 {
    public static void main(String[] args) {
        String FilePath = "G:\\test.txt";
        BufferedReader br = null;
        String line ="";
        int count=1;
        try {
             br = new BufferedReader(new FileReader(FilePath));
             while(br.readLine()!=null) {
                 line = br.readLine();
                 System.out.print(count+" "+line+"\n");
                 count++;
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
