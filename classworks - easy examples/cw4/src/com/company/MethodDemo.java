package com.company;

public class MethodDemo {
    public static void main(String[] args) {
        int sum = sum(2, 4);
        sumAndPrint(2, 3 );
    }
    public static int sum(int a, int b) {
        System.out.println(a + b);

        return a + b;
    }
    public static void sumAndPrint(int a, int b) {
        System.out.println(a + b);
    }
}
