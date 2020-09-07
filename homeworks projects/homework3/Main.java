package com.company;

import java.util.Scanner;

public class Main {

    public static void printTask(String month, String task) {
        System.out.println("Your tasks for " + month + ": " + task);
    }

    public static void switchTask(String userMonth, String scedule[][]) {
        switch(userMonth) {
            case "monday" :
                printTask(scedule[1][0], scedule[1][1]);
                break;
            case "sunday" :
                printTask(scedule[0][0], scedule[0][1]);
                break;
            case "tuesday" :
                printTask(scedule[2][0], scedule[2][1]);
                break;
            case "wednesday" :
                printTask(scedule[3][0], scedule[3][1]);
                break;
            case "thursday" :
                printTask(scedule[4][0], scedule[4][1]);
                break;
            case "friday" :
                printTask(scedule[5][0], scedule[5][1]);
                break;
            case "saturday" :
                printTask(scedule[6][0], scedule[6][1]);
                break;
            default :
                System.out.println("Sorry, I don't understand you, please try again.");
                break;
        }
    }

    public static String[][] ourMas(String[][] scedule) {
        scedule[0][0] = "Sunday";
        scedule[0][1] = "do home work";
        scedule[1][0] = "Monday";
        scedule[1][1] = "go to courses; watch a film";
        scedule[2][0] = "Tuesday";
        scedule[2][1] = "play football";
        scedule[3][0] = "Wednesday";
        scedule[3][1] = "watch TV";
        scedule[4][0] = "Thursday";
        scedule[4][1] = "do homework";
        scedule[5][0] = "Friday";
        scedule[5][1] = "go to courses;";
        scedule[6][0] = "Saturday";
        scedule[6][1] = "play tennis";

        return scedule;
    }
    public static void main(String[] args) {
        String[][] shcedule = new String[7][2];

        String[][] scedule = ourMas(shcedule);
        while(true) {
            Scanner userInput = new Scanner(System.in);
            System.out.println("Please, input the day of the week: ");
            String userMonth = userInput.nextLine().toLowerCase();

            if(userMonth.contains(" ")) {
                userMonth = userMonth.trim();
            }
            if (userMonth.equals("exit")) {
                break;
            }

            if(userMonth.contains("change") || userMonth.contains("reschedule")) {
                int indexofTask = -1;
                for(int i = 0; i < scedule.length; i++) {
                    if(userMonth.contains(scedule[i][0].toLowerCase())) indexofTask = i;
                }
                if (indexofTask == -1) System.out.println("You forgot to specify a day");
                else {
                    System.out.printf("Please, input new tasks for %s\n", scedule[indexofTask][0]);
                    scedule[indexofTask][1] = userInput.nextLine();
                }

            } else switchTask(userMonth, scedule);
        }


    }
}
