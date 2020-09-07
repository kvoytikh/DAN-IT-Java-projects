package com.company;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static int randomNumber(int len) {
        Random random = new Random();
        int RandomNum = random.nextInt(len);
        return RandomNum;
    }
    public static boolean isDigit(String s) throws NumberFormatException {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    public static int isDigitfunc(Scanner in) {
        String num;
        while (true) {
            num = in.nextLine();
            boolean valid = isDigit(num);
            if (!valid) {
                System.out.println("It is not digit! Try again!");
                continue;
            } else {
                if (Integer.parseInt(num) < 1 || Integer.parseInt(num) > 5){
                    System.out.println("It should be number in [1; 5]! Try again!");
                    continue;
                }
                break;
            }
        }
        return Integer.parseInt(num);
    }

    public static void printField(char[][] square) {
        for (int i = 0; i < square.length + 1; i++) {
            for (int j = 0; j < square.length + 1; j++) {
                if (i == 0 && j < 6) {
                    System.out.print(j);
                    System.out.print("|");
                    continue;
                }
                if (j == 0 && i < 6) {
                    System.out.print(i);
                    System.out.print("|");
                    continue;
                }

                System.out.print(square[i - 1][j - 1]);
                System.out.print("|");

            }
            System.out.println();

        }
    }
    public static void main(String[] args) {
            char[][] square = {
                    {'-', '-', '-', '-', '-'},
                    {'-', '-', '-', '-', '-'},
                    {'-', '-', '-', '-', '-'},
                    {'-', '-', '-', '-', '-'},
                    {'-', '-', '-', '-', '-'}
            };

            int randomRow = randomNumber(5) + 1;
            int randomColumn = randomNumber(5) + 1;
            System.out.println(randomRow);
            System.out.println(randomColumn);
            System.out.println("All set. Get ready to rumble!");


            while(true) {
                Scanner in = new Scanner(System.in);
                System.out.println("Enter a row: ");
                int row = isDigitfunc(in);

                System.out.println("Enter a column: ");
                int column = isDigitfunc(in);

                if (randomRow == row && randomColumn == column) {
                    square[row - 1][column - 1] = 'x';
                    printField(square);
                    System.out.println("You have won!");
                    break;
                } else {
                    square[row - 1][column - 1] = '*';
                }
                printField(square);
            }
    }
}
