package com.company;

public enum Species {
    DOG(false, 4, true),
    DOMESTICCAT(false, 4, true),
    FISH(false, 0, false),
    ROBOCAT(false, 4,false),
    UNKNOWN(false, 0, false);

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
