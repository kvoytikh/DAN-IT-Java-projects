package com.company;

import com.company.interfaces.Foul;

import java.util.Arrays;
import java.util.HashSet;

public class Dog extends Pet implements Foul {

    public Dog(String nickname, int age, int trickLevel, HashSet<String> habits) {
        super(Species.DOG, nickname, age, trickLevel, habits);
    }

    @Override
    public void respond() {
        System.out.println("Привет, хозяин. Я - Dog. Я соскучился!");
    }

    @Override
    public void Foul() {
        System.out.println("Нужно хорошо замести следы...");
    }

}
