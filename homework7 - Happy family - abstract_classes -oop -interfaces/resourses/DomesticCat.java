package com.company;

import com.company.interfaces.Foul;

public class DomesticCat extends Pet implements Foul {

    public DomesticCat(String nickname, int age, int trickLevel, String[] habits) {
        super(nickname, age, trickLevel, habits);
    }
    DomesticCat(){
        super(Species.DOMESTICCAT);
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
