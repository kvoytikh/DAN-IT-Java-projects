package com.company;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class CompareListSpeed {
    public static void main(String[] args) {
        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();

        Random random = new Random();

        for(int i = 0; i < 10000000; i++) {
            int num = random.nextInt();
            arrayList.add(num);
            linkedList.add(num);
        }

        long start = System.currentTimeMillis();
        for(int i = 0; i < 1000000; i++) {
            int rnd = random.nextInt(arrayList.size());
            arrayList.get(rnd);
        }
        long end = System.currentTimeMillis();
        System.out.println(end-start);

        start = System.currentTimeMillis();
        for(int i = 0; i < 1000; i++) {
            int rnd = random.nextInt(linkedList.size());
            arrayList.get(rnd) ;
        }
        end = System.currentTimeMillis();
        System.out.print(end - start);

    }
}
