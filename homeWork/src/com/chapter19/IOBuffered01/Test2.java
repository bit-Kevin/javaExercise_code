package com.chapter19.IOBuffered01;

import java.io.*;

public class Test2 {

        public static void main(String[] args) {
            String FilePath ="G:\\test.txt";
            BufferedWriter br = null;
            String line="";
            String date = "俞凯文java通天路";
            try {
                br = new BufferedWriter(new FileWriter(FilePath,true));
                br.write(date);
                br.newLine();
                br.write(date);
                br.newLine();
                br.write(date);
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

