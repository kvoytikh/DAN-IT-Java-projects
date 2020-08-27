package com.company;

import java.util.Arrays;

public class Pet {
    private Species species;
    private String nickname;
    private int age;
    private int trickLevel;
    private String[] habits;


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

    public String[] getHabits() {
        return habits;
    }

    static {
        System.out.println("Загружается новый класс " + Pet.class.getSimpleName());
    }
    { System.out.println("Coздается новый обьект");}

    public Pet(Species species, String nickname) {
        this.species = species;
        this.nickname = nickname;
    }
    public Pet(Species species, String nickname, int age, int trickLevel, String[] habits) {
        this(species, nickname);
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
    
    public void respond() {
        System.out.println("Привет, хозяин. Я - " + nickname + " . Я соскучился!!");
    }

    public static void foul() {
        System.out.println("Нужно хорошо замести следы...");
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof Pet))
            return false;
        Pet pet = (Pet)obj;
        if (species == pet.getSpecies() && nickname == pet.getNickname() && age == pet.getAge()
                && trickLevel == pet.getTrickLevel()) {
            String[] hab = pet.getHabits();

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
