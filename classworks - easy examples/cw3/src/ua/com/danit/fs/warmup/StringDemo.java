package ua.com.danit.fs.warmup;


import java.util.Scanner;

public class StringDemo {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("type something");
        String typed = scan.nextLine();
        String output = typed.substring(0, 1).toUpperCase() + typed.substring(1).toLowerCase();

        System.out.println(output);
    }
}
