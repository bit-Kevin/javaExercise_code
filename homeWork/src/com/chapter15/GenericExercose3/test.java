package com.chapter15.GenericExercose3;

import org.junit.jupiter.api.Test;

import java.util.*;

public class test {
    public static void main(String[] args) {
        DAO<User> u = new DAO<>();
//        u.save("003",new User(003,18,"jack"));
//        u.save("004",new User(004,18,"luci"));
//        u.save("005",new User(005,19,"tom"));
//        System.out.println(u.get("003"));
//        u.update("003",new User(888,888,"kevin"));
//        System.out.println(u.list());
//        u.delete("004");
//        System.out.println(u.list());
    }
    @Test
    public void TestList(){
        DAO<User> u = new DAO<>();
        u.save("003",new User(003,18,"jack"));
        u.save("004",new User(004,18,"luci"));
        u.save("005",new User(005,19,"tom"));
        System.out.println(u.get("003"));
        u.update("003",new User(888,888,"kevin"));
        System.out.println(u.list());
        u.delete("004");
        System.out.println(u.list());

    }
}
class DAO<T>{
    Map<String,T> map = new HashMap<>();
    @Test
    public  void save (String id,T entity){
        map.put(id,entity);
    }
    public T get(String id){
        return map.get(id);
    }
    public void update(String id,T entity){
        map.put(id,entity);
    }
    @Test
    public List<T> list(){
        List<T> arr = new ArrayList<>();
        Iterator<T> iterator= map.values().iterator();
        while (iterator.hasNext()) {
            T next =  iterator.next();
            arr.add(next);

        }
        return arr;
    }
    public void delete(String id){
        map.remove(id);
    }
}
class User{
    private int id,age;
    String name;

    public User(int id, int age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}