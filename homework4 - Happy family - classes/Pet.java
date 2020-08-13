package com.company;

import java.util.Arrays;

public class Pet {
    String species;
    String nickname;
    int age;
    int trickLevel;
    String[] habits;

    public Pet() {

    }
    public Pet(String species, String nickname) {
        this.species = species;
        this.nickname = nickname;
    }
    public Pet(String species, String nickname, int age, int trickLevel, String[] habits) {
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

    public String toString() {
        String joinedString = Arrays.toString(habits);
        return species + "{nickname='" + nickname +"', age=" + age + ", trickLevel=" + trickLevel + ", habits=["
                + joinedString +"]}";
    }
}
