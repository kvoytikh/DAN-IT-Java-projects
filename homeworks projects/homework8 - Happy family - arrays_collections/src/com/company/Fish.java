package com.company;

import java.util.HashSet;

public class Fish extends Pet {
    public Fish(String nickname, int age, int trickLevel, HashSet<String> habits) {
        super(Species.FISH, nickname, age, trickLevel, habits);
    }

    @Override
    public void respond() {
        System.out.println("Привет, хозяин. Я - Fish. Я соскучился!");
    }
}
