package com.company;

import java.util.Random;

public class Human {
        String name;
        String surname;
        int year;
        int iq;
        Pet pet;
        Human mother;
        Human father;
        String[][] schedule;

        public Human() {

        }

        public Human(String name, String surname, int year) {
            this.name = name;
            this.surname = surname;
            this.year = year;
        }

        public Human(String name, String surname, int year, Human mother, Human father) {
            this(name, surname, year);
            this.mother = mother;
            this.father = father;
        }
        public Human(String name, String surname, int year, Human mother, Human father, int iq, Pet pet, String[][] schedule) {
            this(name, surname, year, mother, father);

            if (this.iq > 100 || this.iq < 0) {
                throw new IllegalArgumentException("IQ can be [0; 100]; -1 - error");
            } else {
                this.iq = iq;
            }

            this.pet = pet;
            this.schedule = schedule;
        }

        public void greetPet () {
            System.out.println("Привет, " + pet.nickname);
        }

        public void describePet() {
            System.out.print( "У меня есть " + pet.species + ", ему " + pet.age + " лет, он ");
            if (pet.trickLevel > 50) {
                System.out.println("очень хитрый");
            } else if (pet.trickLevel < 50) {
                System.out.println("почти не хитрый");
            }
        }

        public boolean feedPet(boolean flag) {
            if(flag) {
                System.out.println("Хм... покормлю ка я " + pet.nickname);
                return true;
            }

            Random random = new Random();
            int num = random.nextInt(101);
            if(pet.trickLevel > num) {
                System.out.println("Хм... покормлю ка я " + pet.nickname + "a");
            }
            System.out.println("Думаю," + pet.nickname + " не голоден.");

            return false;
        }

        public String toString(){
            return "Human{name='" + name + "', surname=" + surname + "', year=" + year +", iq=" + iq
                    + ",\n mother=" + mother + ",\n father=" + father +", pet=" + pet;
        }

}
