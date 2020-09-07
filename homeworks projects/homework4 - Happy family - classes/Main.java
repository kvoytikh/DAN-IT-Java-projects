package com.company;

public class Main {

    public static void main(String[] args) {
        Pet pet1 = new Pet();
        String[] hab = {"gav", "foul"};
        Pet pet2 = new Pet("Dog", "Bon", 3, 37, hab);

        Human person1 = new Human();
        String[][] sch = {{"Mon", "Tue"},
                        {"play", "me"}};


        Human pMother = new Human("Kristina", "Voytikh", 1988);
        Human pFather = new Human("Sasha", "Melnik", 1979);
        Human person3 = new Human("Vlada", "Lila", 2001, pMother, pFather);

        Human person = new Human("Vlada", "Lila", 2001, pMother, pFather, 19, pet2, sch);
        String infPer = person.toString();
        System.out.println(infPer);


        person.greetPet();
        person.describePet();

        Pet.eat();
        pet2.respond();
        Pet.foul();

        person.feedPet(false);
    }
}
