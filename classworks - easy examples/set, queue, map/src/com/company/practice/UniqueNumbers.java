package com.company.practice;

import java.util.*;

public class UniqueNumbers {
    public static void main(String[] args) {
        Random random = new Random();
        Set<Integer> numbers = new HashSet<>();

        while(numbers.size() < 20) {
            numbers.add(random.nextInt(31));
        }
        System.out.println(numbers);
    }
}
