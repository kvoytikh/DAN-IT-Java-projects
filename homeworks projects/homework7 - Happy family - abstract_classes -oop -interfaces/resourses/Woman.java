package com.company;

public final class Woman extends Human {
    public Woman(String name, String surname, int year, int iq) {
        super(name, surname, year, iq);
    }

    @Override
    public void greetPet() {
        super.greetPet();
    }

    public void makeup() {
        System.out.println("I should make up my eyes");
    }
}
