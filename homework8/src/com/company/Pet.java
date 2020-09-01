package com.company;

import java.util.Arrays;
import java.util.HashSet;

public abstract class Pet {
    private String nickname;
    private int age;
    private int trickLevel;
    private HashSet<String> habits;
    private Species species;

    public Species getSpecies() {
        return species;
    }

    public String getNickname() {
        return nickname;
    }

    public int getTrickLevel() {
        return trickLevel;
    }
    public int getAge() {
        return age;
    }
    {
        return habits;
    }
    public HashSet<String> getHabits()

    public Pet(Species species) {
        this.species = Species.UNKNOWN;
    }

    public Pet(String nickname, int age, int trickLevel, HashSet<String> habits) {
        this.age = age;

        if (this.trickLevel > 100 || this.trickLevel < 0) {
            throw new IllegalArgumentException("TrickLevel can be [0; 100]; -1 - error");
        } else {
            this.trickLevel = trickLevel;
        }

        this.habits = habits;
    }

    public static void eat() {
        System.out.println("Я кушаю!");
    }
    
    public abstract void respond();

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof Pet))
            return false;
        Pet pet = (Pet)obj;
        if (species == pet.getSpecies() && nickname == pet.getNickname() && age == pet.getAge()
                && trickLevel == pet.getTrickLevel()) {
            HashSet<> hab = pet.getHabits();

            for (int i = 0; i < hab.length; i++) {
                if (!(habits[i] == hab[i])) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    @Override
    public int hashCode(){
        return habits.hashCode();
    }

    @Override
    public String toString() {
        String pcanFly;
        String pHasFur;
        int legs = species.getNumberOfLegs();
        if(species.getCanFly()) {
            pcanFly = "yes";
        } else {
            pcanFly = "no";
        }
        if(species.getHasFur()) {
            pHasFur = "yes";
        } else {
            pHasFur = "no";
        }

        return species + "{nickname='" + nickname +"', age=" + age + ", trickLevel=" + trickLevel + ", habits="
                + Arrays.toString(habits) + ", can fly:" + pcanFly + ", number of legs: " + ", has fur: " + pHasFur + "}";
    }

    @Override
    protected void finalize() {
        System.out.println("Удаление животного!");
    }
}
