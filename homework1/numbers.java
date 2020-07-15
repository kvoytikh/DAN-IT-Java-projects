package ua.kvoytikh.danit.hw1;

import java.util.Random;
import java.util.Scanner;

public class numbers {
    public static void BubbleSort(int[] array, int i) {
        for (i = 0; i < array.length - 1; i++) {
            for (int j = array.length - 1; j > i; j--) {
                if (array[j - 1] > array[j]) {
                    int tmp = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = tmp;
                }
            }
        }

    }
    public static boolean isDigit(String s) throws NumberFormatException {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    public static int randomNumber(int len) {
        Random random = new Random();
        int RandomNum = random.nextInt(len);
        return RandomNum;
    }


    public static void main(String[] args) {
        System.out.println("Let the game begin!");

        Scanner name = new Scanner(System.in);
        System.out.println("Enter your name: ");
        String UserName = name.nextLine();

        Scanner level = new Scanner(System.in);
        System.out.println("Change the level (easy[1] or history-game[2])");
        int UserLevel = level.nextInt();

        if (UserLevel == 1) {
            int[] UserNumArray = new int[1000];
            int i = 0;

            int RandomNumber = randomNumber(101);
            while (true) {
                Scanner number = new Scanner(System.in);
                System.out.println("Enter your number [0; 100]");
                String UserNumber;
                while (true) {
                    UserNumber = number.nextLine();
                    boolean valid = isDigit(UserNumber);
                    if (!valid) {
                        System.out.println("It is not digit! Try again!");
                    } else {
                        break;
                    }
                }
                UserNumArray[i] = Integer.parseInt(UserNumber);
                i++;

                if (Integer.parseInt(UserNumber) < RandomNumber) {
                    System.out.println("Your number is too small. Please, try again.");

                } else if (Integer.parseInt(UserNumber) > RandomNumber) {
                    System.out.println("Your number is too big. Please, try again.");
                } else {
                    System.out.println("Congratulations, " + UserName + "!");
                    break;
                }

            }
            BubbleSort(UserNumArray, i);

            System.out.print("Your numbers: ");
            for (int k = 1000 - i; k < 1000; k++) {
                System.out.print(UserNumArray[k]);
                System.out.print(" ");
            }
        } else if (UserLevel == 2) {
            String[][] historyArray = {
                    {"1917", "the World War I begin"},
                    {"1939", "the World War II begin"},
                    {"1932", "the famine"},
                    {"1922", "the creation of the USSR"},
                    {"1986", "the Accident at the Chernobyl nuclear power plant."},
            };

            int RandomHistoryNumber = randomNumber(5);

            Scanner when = new Scanner(System.in);
            String whenDid;
            while (true) {
                Scanner whenD = new Scanner(System.in);
                System.out.print("When did ");
                System.out.println(historyArray[RandomHistoryNumber][1]);
                while (true) {
                    whenDid = whenD.nextLine();
                    boolean valid = isDigit(whenDid);
                    if (!valid) {
                        System.out.println("It is not digit! Try again!");
                    } else {
                        break;
                    }
                }
                if (Integer.parseInt(whenDid) < Integer.parseInt(historyArray[RandomHistoryNumber][0])) {
                    System.out.println("Your number is too small. Please, try again.");

                } else if (Integer.parseInt(whenDid) > Integer.parseInt(historyArray[RandomHistoryNumber][0])) {
                    System.out.println("Your number is too big. Please, try again.");
                } else {
                    System.out.println("Congratulations, " + UserName + "!");
                    break;
                }
            }
        }

    }
}

