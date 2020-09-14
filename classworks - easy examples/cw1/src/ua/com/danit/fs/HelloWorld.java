package ua.com.danit.fs;

import java.util.Scanner;

public class HelloWorld {
    // psvm, main - tab click
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int intAge = 0;
        do {
            System.out.println("Please enter your age");
            String age = scanner.next();

            try {
                intAge = Integer.parseInt(age);
            } catch (Exception e) {
                System.out.println("Not");
            }
        } while(intAge == 0);

                System.out.println("Your age is " + intAge);
    }
}

