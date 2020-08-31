package com.company;

import com.company.interfaces.Foul;

public class Dog extends Pet implements Foul {

    public Dog(String nickname, int age, int trickLevel, String[] habits) {
        super(nickname, age, trickLevel, habits);
    }
    Dog(){
        super(Species.DOG);
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
