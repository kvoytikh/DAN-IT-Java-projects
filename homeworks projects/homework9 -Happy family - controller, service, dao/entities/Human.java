package com.company;

import java.util.Map;
import java.util.Random;

public class Human{
        private String name;
        private String surname;
        private int year;
        private int iq;
        private Map<String, String> schedule;

        private Family family;

        Random random = new Random();

        public String getName() {
            return name;
        }

        public String getSurname() {
            return surname;
        }

        public int getYear() {
            return year;
        }

        public int getIq() { return iq; }


        public Map<String, String> getSchedule() {
            return schedule;
        }

        public Family getFamily() {
            return family;
        }

        public void setFamily(Family family) {
            this.family = family;
        }

        public Human(String name, String surname, int year, int iq) {
                this.name = name;
                this.surname = surname;
                this.year = year;
            if (this.iq > 100 || this.iq < 0) {
                throw new IllegalArgumentException("IQ can be [0; 100]; -1 - error");
            } else {
                this.iq = iq;
            }
        }
        public Human(String name, String surname, int year, int iq, Family family,
                     Map<String, String> schedule) {
            this(name, surname, year, iq);
            this.family = family;
            this.schedule = schedule;
        }


    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof Human))
            return false;
        Human human = (Human) obj;
        if (name == human.getName() && surname == human.getSurname() &&  year == human.getYear()
            && family == human.getFamily() && schedule == human.getSchedule()) {
            return true;
        }
        return false;
    }

    @Override
    public int hashCode(){
        return surname.hashCode();
    }

    @Override
    public String toString() {
            return "Human{name='" + name + "', surname=" + surname + "', year=" + year + ", iq=" + iq + " schedule = "
                    + schedule;
        }

    @Override
    protected void finalize() {
            System.out.println("Удаление обьекта человека!");
    }

}
