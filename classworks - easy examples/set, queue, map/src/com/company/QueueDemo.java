package com.company;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.DelayQueue;

public class QueueDemo {
    public static void main(String[] args) {
        Deque<Integer> deque = new ArrayDeque<>();
        deque.addFirst(5);
        deque.addFirst(7);

        deque.addLast(0);

        deque.peekFirst(); //смотрит, но НЕ удаляет
        deque.peekLast(); 
    }
}
