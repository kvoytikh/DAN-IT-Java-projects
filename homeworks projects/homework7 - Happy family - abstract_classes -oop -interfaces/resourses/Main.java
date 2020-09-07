package com.company;

public class Main {

    public static void main(String[] args) {
        String[] girlsNames = {"Kristina", "Milana", "Vlada"};
        String[] mansNames = {"Kiril", "Alex", "Vova"};
        Pet pet = new Dog();

        Woman mother = new Woman("Tatiana", "Popovich", 1987, 60);
        Man father = new Man("Sasha", "Popovich", 1982, 40);
        Family family = new Family(mother, father, new Human[]{mother, father}, pet);

        family.bornChild(girlsNames, mansNames);
        System.out.println(family);
    }
}
