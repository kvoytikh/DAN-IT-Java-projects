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

    public HashSet<String> getHabits() {
        return habits;
    }


    public Pet(Species species, String nickname, int age, int trickLevel, HashSet<String> habits) {
        this.age = age;

        if (this.trickLevel > 100 || this.trickLevel < 0) {
            throw new IllegalArgumentException("TrickLevel can be [0; 100]; -1 - error");
        } else {
            this.trickLevel = trickLevel;
        }
        if(species != Species.DOG && species != Species.DOMESTICCAT && species != Species.FISH && species != Species.ROBOCAT) {
            this.species = Species.UNKNOWN;
        } else {
            this.species = species;
        }
        this.nickname = nickname;
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
                && trickLevel == pet.getTrickLevel() && habits.equals(pet.getHabits())) {
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
                + Arrays.toString(habits.toArray()) + ", can fly:" + pcanFly + ", number of legs: " + legs + ", has fur: " + pHasFur + "}";
    }

    @Override
    protected void finalize() {
        System.out.println("Удаление животного!");
    }
}
