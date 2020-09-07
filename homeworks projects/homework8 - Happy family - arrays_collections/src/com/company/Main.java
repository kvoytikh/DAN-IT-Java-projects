package com.company;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Main {

    public static void main(String[] args) {
        String[] girlsNames = {"Kristina", "Milana", "Vlada"};
        String[] mansNames = {"Kiril", "Alex", "Vova"};

        HashSet<String> hab = new HashSet<>(){{
            add("gav");
            add("foul");
        }};
        Pet pet1 = new Dog("Bon", 3, 37, hab);
        Pet pet2 = new Fish("Nemo", 3, 37, hab);
        Set<Pet> pet = new HashSet<>() {{
            add(pet1);
            add(pet2);
        }};

        Woman mother = new Woman("Tatiana", "Popovich", 1987, 60);
        Man father = new Man("Sasha", "Popovich", 1982, 40);
        List<Human> children = new ArrayList<>() {{
            add(mother);
            add(father);
        }};
        Family family = new Family(mother, father, children, pet);

        family.bornChild(girlsNames, mansNames);
        System.out.println(family);

        System.out.println(pet.toString());

    }
}
