package com.company;

public final class Man extends Human {
    public Man(String name, String surname, int year, int iq) {
        super(name, surname, year, iq);
    }

    @Override
    public void greetPet() {
        super.greetPet();
    }

    public void repairCar() {
        System.out.println("I should repair my car");
    }

}
