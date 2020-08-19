package com.company;

public class Main {

    public static void main(String[] args) {
        String[] hab = {"gav", "foul"};
        Pet pet1 = new Pet("Dog", "Bon", 3, 37, hab);
        Pet pet2 = new Pet("Cat", "Bon", 3, 37, hab);

        String[][] sch = {{"Mon", "play"},
                {"Tue", "me"}};
        Human pMother = new Human("Kristina", "Voytikh", 1988);
        Human pFather = new Human("Sasha", "Melnik", 1979);
        Human pChildren1 = new Human("Child1", "Surn1", 1991);
        Human pChildren2 = new Human("Child2", "Surn2", 1991);


        Human pChildForAdd = new Human("AddChild", "3SurName", 2001);

        Family family = new Family(pMother, pFather, new Human[] {pChildren1, pChildren2}, pet1);
        System.out.println(family.toString());

        System.out.println("Count of family: " + family.countFamily());

        Human person = new Human("Vlada", "Lila", 2001, 19, family, sch);
        //System.out.println(person.toString());
        Human person1 = new Human("Vlada", "Lila", 2001, 19, family, sch);

        // ----equals() for Family------
        Family family1 = new Family(pMother, pFather, new Human[] {pChildren1, pChildren2}, pet1);
        Family family2 = new Family(pMother, pFather, new Human[] {pMother}, pet1);

        System.out.println(family.equals(family));
        System.out.println(family1.equals(family));
        System.out.println(family.equals(family2));

        //----equals() for human -----
        System.out.println(person.equals(person1));

        //---equals() for pet----
        System.out.println(pet1.equals(pet2));

        //System.out.println(person.hashCode());
        //System.out.println(person1.hashCode());


        /*------for adding child-------*/
        family.addChild(pChildForAdd);
        System.out.println(family.toString());

        /*-----for deletting by index-----*/
        //family.deleteChild(0);
        //System.out.println(family.toString());

        /*-----for deletting by object----*/
        family.deleteChildByName(pChildren1);
        System.out.println(family.toString());

        person.greetPet();
        person.describePet();

        Pet.eat();
        pet1.respond();
        Pet.foul();

        person.feedPet(false);
    }
}
