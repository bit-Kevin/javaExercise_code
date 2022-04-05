package com.chapter19.IOBuffered01;

import java.io.*;

public class copy {
    public static void main(String[] args) {
        //定义路径
        String FilePath = "G:\\学成网首页.psd";
        String toFilePath = "G:\\学成网首页copy.psd";
        BufferedInputStream bis = null ;
        BufferedOutputStream bos = null ;
        byte[] bytes = new byte[1024];
        int CopyLen=0;
        try {
            bis =new BufferedInputStream(new FileInputStream(FilePath));
            bos = new BufferedOutputStream(new FileOutputStream(toFilePath));
            while ((CopyLen=bis.read(bytes))!=-1){
                bos.write(bytes,0,CopyLen);
            }
            System.out.println("拷贝完成");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (bis!=null)
                    bis.close();
                if (bos!=null)
                    bos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
