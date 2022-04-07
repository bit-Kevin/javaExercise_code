package com.chapter19.HomeWork1;

import java.io.*;

public class Test {
    public static void main(String[] args) {
        String FilePath = "G:\\hello.txt";
        //创建文件类
        File file = new File(FilePath);
        //创建写入文件流
        FileOutputStream fos = null;
        //测试转换流
        OutputStreamWriter osw = null;
        //判断绑定的路径文件是否存在
        if (!file.exists()) {
            try {
                //创建文件
                file.createNewFile();
                //绑定流
                fos = new FileOutputStream(FilePath);
                //转换流
//                osw = new OutputStreamWriter(fos, "gbk");
//                osw.write(new String("我是俞凯文"));
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (osw != null)
                        osw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }


            }
        } else {
            try {
                //绑定流
                fos = new FileOutputStream(FilePath);
                fos.write(new String("先去吃饭").getBytes());
                //转换流
//                osw = new OutputStreamWriter(fos, "gbk");
//                osw.write(new String("我是俞凯文"));
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    //转换流会自动关闭他底层的流。所以只要关闭最外面的流就可以了
                    if (fos != null)
                        fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
    }
}
