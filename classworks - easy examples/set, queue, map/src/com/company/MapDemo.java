package com.company;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapDemo {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        Map<String, Integer> treeMap = new TreeMap<>(); //ключи- по возрастанию
        Map<String, Integer> linkedHashMap = new LinkedHashMap<>();

        map.put("test", 5);
        map.put("test2", 10);

        Map<Integer, Human> employees = new HashMap<>();
        employees.put(11, new Human(11, "Andrew", 12, 500));
        employees.put(22, new Human(22, "Andr", 101, 5000));
        employees.put(33, new Human(33, "And", 12, 5000));

        employees.keySet(); //Set-collection with all keys
        employees.values();
        employees.entrySet(); //Set-collection набор пар

        for (int id : employees.keySet()) {
            System.out.println("Key: " + id + "Value: " + employees.get(id));
        }


    }
}
