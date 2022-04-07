package com.chapter19.HomeWork1;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.Properties;

public class test3 {
    public static void main(String[] args) throws IOException {
        //对象流是一个包装流，可以包装字节
        String FilePath = "G:\\IDEAcode\\javaExercise_code\\homeWork\\src\\dog.properties";
        Properties properties=new Properties();
        String ToFilePath="G:\\dog.dat";

            properties.load(new FileReader(FilePath));
             String name= properties.get("name")+"";
             int age = Integer.parseInt(properties.get("age")+"");
             String color = properties.get("color")+"";
            dog dog = new dog(name, age, color);
            System.out.println(dog.toString());

            //序列化保存dog类
            ObjectOutputStream oot = new ObjectOutputStream( new FileOutputStream(ToFilePath));
            oot.writeObject(dog);
            oot.close();






    }
    @Test
    public void m1() throws IOException, ClassNotFoundException {
        String FilePath2 = "G:\\dog.dat";
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FilePath2));
        dog d =(dog) ois.readObject();
        System.out.println(d);
        ois.close();
    }
}
class dog  implements Serializable{
    String name ;
    int age ;
    String color ;
    //dog 序列化测试类


    public dog(String name, int age, String color) {
        this.name = name;
        this.age = age;
        this.color = color;
    }

    @Override
    public String toString() {
        return "dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", color='" + color + '\'' +
                '}';
    }
}
