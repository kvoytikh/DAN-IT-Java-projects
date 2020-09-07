package com.company;

import com.company.interfaces.Foul;

import java.util.HashSet;

public class DomesticCat extends Pet implements Foul {

    public DomesticCat(String nickname, int age, int trickLevel, HashSet<String> habits) {
        super(Species.DOMESTICCAT, nickname, age, trickLevel, habits);
    }

    @Override
    public void respond() {
        System.out.println("Привет, хозяин. Я - DomesticCat. Я соскучился!");
    }

    @Override
    public void Foul() {
        System.out.println("Нужно хорошо замести следы...");
    }
}
