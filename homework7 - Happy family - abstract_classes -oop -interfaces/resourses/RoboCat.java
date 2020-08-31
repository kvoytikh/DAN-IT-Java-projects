package com.company;
import com.company.interfaces.Foul;

public class RoboCat extends Pet implements Foul {
    public RoboCat(String nickname, int age, int trickLevel, String[] habits) {
        super(nickname, age, trickLevel, habits);
    }
    RoboCat(){
        super(Species.ROBOCAT);
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
