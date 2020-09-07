package com.company;

public class Main {

    public static void main(String[] args) {

        /*Создайте в классе Main в цикле столько объектов типа Human, чтобы сборщик мусора начал удалять старые объекты*/
        for(int i = 0; i < 100000; i++) {
            new Human();
        }

    }
}
