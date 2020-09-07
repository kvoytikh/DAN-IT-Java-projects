package com.company;

public class Human{
        private String name;
        private String surname;
        private int year;
        private int iq;
        private String[][] schedule;

        private Family family;

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

    public String[][] getSchedule() {
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
        public Human(String name, String surname, int year, int iq, Family family, String[][] schedule) {
            this(name, surname, year, iq);
            this.family = family;
            this.schedule = schedule;
        }

        public void greetPet () {
            System.out.println("Привет, " + family.getPet().getNickname());
        }

        public void describePet() {
            System.out.print( "У меня есть " + family.getPet().getSpecies() + ", ему " + family.getPet().getAge() + " лет, он ");
            if (family.getPet().getTrickLevel() > 50) {
                System.out.println("очень хитрый");
            } else if (family.getPet().getTrickLevel() < 50) {
                System.out.println("почти не хитрый");
            }
        }

        public boolean feedPet(boolean flag) {
            if(flag) {
                System.out.println("Хм... покормлю ка я " + family.getPet().getNickname());
                return true;
            }

            Random random = new Random();
            int num = random.nextInt(101);
            if(family.getPet().getTrickLevel() > num) {
                System.out.println("Хм... покормлю ка я " + family.getPet().getNickname() + "a");
            }
            System.out.println("Думаю," + family.getPet().getNickname() + " не голоден.");

            return false;
        }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof Human))
            return false;
        Human human = (Human) obj;
        if (name == human.getName() && surname == human.getSurname() &&  year == human.getYear()
            && family == human.getFamily()) {
            String[][] sched = human.getSchedule();

            for (int i = 0; i < sched.length; i++) {
                for(int j = 0; j < sched[0].length; j++ )
                if (!(schedule[i][j] == sched[i][j])) {
                    return false;
                }
            }
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
                    + Arrays.deepToString(schedule);
        }

    @Override
    protected void finalize() {
            System.out.println("Удаление обьекта человека!");
    }

}
