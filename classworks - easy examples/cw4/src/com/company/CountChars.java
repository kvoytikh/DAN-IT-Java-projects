package com.company;

import java.util.Scanner;

public class CountChars {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter string: ");
        String userString = input.nextLine();

        //hasNextLine() - если уже введена строка, оно проверяет строка ли это

        System.out.println("Enter symbol: ");
        String userSymbol = input.next();

        int count = 0;
        // ------   1   ------
        /*for (int i = 0; i < userString.length(); i++) {
            if((userString.charAt(i)) == userSymbol.charAt(0))) {
                count++;
            }
        }*/

        int lastSymbolIndex = 0;
        while (lastSymbolIndex != -1) {
            lastSymbolIndex = userString.indexOf(userSymbol, lastSymbolIndex);

            if (lastSymbolIndex != -1) {
                count++;
                lastSymbolIndex++;
            }
        }

        System.out.println(count);

    }
}
