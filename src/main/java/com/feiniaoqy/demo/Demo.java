package com.feiniaoqy.demo;

/**
 * Created by asus on 2016/4/16.
 */
public class Demo {
    String s = "你确定创建我的对象了吗？";
    public void printNameAndAge(String name,int age){
        System.out.println(name+"============"+age);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    private String name;
    private int age;
    public Demo(){

    }
}
