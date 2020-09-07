package com.company;

public enum Species {
    DOG(false, 4, true),
    CAT(false, 4, true),
    DUCK(true, 2, false),
    PET(false, 4,false),
    PARROT(true, 2, true);
    private boolean canFly;
    private int numberOfLegs;
    private boolean hasFur;

    Species(boolean canFly, int numberOfLegs, boolean hasFur) {
        this.canFly = canFly;
        this.numberOfLegs = numberOfLegs;
        this.hasFur = hasFur;
    }

    public boolean getCanFly() {
        return canFly;
    }

    public int getNumberOfLegs() {
        return numberOfLegs;
    }
    public boolean getHasFur() {
        return hasFur;
    }
}
