package com.company;

public class StaticDemo {
    public static void main(String[] args) {
        staticSayHello();
        StaticDemo.staticSayHello();

    }

    public static void staticSayHello() {
        System.out.println("static Hello");
    }
    public void sayHello() {
        System.out.println("Hello");
    }
}
