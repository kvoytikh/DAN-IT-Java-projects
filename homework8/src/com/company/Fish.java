package com.company;

public class Fish extends Pet {
    private Fish(String nickname, int age, int trickLevel, String[] habits) {
        super(nickname, age, trickLevel, habits);
    }
    Fish(){
        super(Species.FISH);
    }
    @Override
    public void respond() {
        System.out.println("Привет, хозяин. Я - Fish. Я соскучился!");
    }
}
