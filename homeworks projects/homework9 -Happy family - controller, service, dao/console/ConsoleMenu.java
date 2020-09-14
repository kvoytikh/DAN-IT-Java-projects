package com.company.console;

import com.company.*;
import com.company.Dog;
import com.company.Family;
import com.company.Fish;
import com.company.Human;
import com.company.Man;
import com.company.Pet;
import com.company.Woman;
import com.company.controllers.FamilyController;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ConsoleMenu {
    public static void start() {
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

        Set<Pet> pet11 = new HashSet<>() {{
            add(pet1);
        }};


        Woman mother1 = new Woman("Tatiana1", "Popovich", 1987, 60);
        com.company.Man father1 = new Man("Sasha1", "Popovich", 1982, 40);
        List<Human> children1 = new ArrayList<>() {{
            add(mother1);
            add(father1);
        }};

        Woman mother2 = new Woman("Tatiana2", "Popovich", 1987, 60);
        Man father2 = new Man("Sasha2", "Popovich", 1982, 40);
        List<Human> children2 = new ArrayList<>() {{
            add(mother2);
        }};
        Family family = new Family(mother1, father1, children1, pet);
        Family family1 = new Family(mother2, father2, children2, pet11);
        Family family2 = new Family(mother2, father2, children2, pet);
        Family family3 = new Family(mother2, father2, children2, pet);


        HappyFamilyContext.familyController.saveFamily(family);
        HappyFamilyContext.familyController.saveFamily(family1);
        HappyFamilyContext.familyController.saveFamily(family2);
        HappyFamilyContext.familyController.saveFamily(family3);
        System.out.println("saveFamily: \n");
        HappyFamilyContext.familyController.displayAllFamilies();

        System.out.println("get family by index: " + HappyFamilyContext.familyController.getFamilyByIndex(2));

        System.out.println("delete by index: " + HappyFamilyContext.familyController.deleteFamily(4) +
                "  by object: " + HappyFamilyContext.familyController.deleteFamily(family));

        System.out.println("-------------------ANOTHER ALL IS TESTING IN TESTS------------------");

    }
}
