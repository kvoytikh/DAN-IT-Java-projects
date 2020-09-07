package com.company;
import com.company.interfaces.Foul;

import java.util.HashSet;

public class RoboCat extends Pet implements Foul {
    public RoboCat(String nickname, int age, int trickLevel, HashSet<String> habits) {
        super(Species.ROBOCAT, nickname, age, trickLevel, habits);
    }

    @Override
    public void respond() {
        System.out.println("Привет, хозяин. Я - RoboCat. Я соскучился!");
    }

    @Override
    public void Foul() {
        System.out.println("Нужно хорошо замести следы...");
    }
}
