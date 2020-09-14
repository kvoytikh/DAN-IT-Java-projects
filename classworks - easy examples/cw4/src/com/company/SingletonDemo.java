package com.company;

public class SingletonDemo {
    private static int count = 0;
        public SingletonDemo() throws Exception{
            if(count >= 1) {
                throw new Exception("only one");
            } else {
                count++;
                System.out.println(count);
            }
        }
}
