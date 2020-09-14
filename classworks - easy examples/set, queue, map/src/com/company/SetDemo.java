package com.company;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetDemo {
    public static void main(String[] args) {
        Set<Integer> hashSet = new HashSet<>();
        Set<Integer> treeSet = new TreeSet<>();
        Set<Integer> linkedHashSet = new LinkedHashSet<>();

        hashSet.add(1);
        hashSet.add(6);
        hashSet.add(4);
        hashSet.add(-1);

        treeSet.add(1);
        treeSet.add(-1);
        treeSet.add(6);
        treeSet.add(4);

        linkedHashSet.add(1);
        linkedHashSet.add(-1);
        linkedHashSet.add(6);
        linkedHashSet.add(4);

        System.out.println(hashSet.contains(2));
        System.out.print(hashSet.contains(-1));

        System.out.println(hashSet);
        System.out.println(treeSet);
        System.out.println(linkedHashSet);
    }
}
