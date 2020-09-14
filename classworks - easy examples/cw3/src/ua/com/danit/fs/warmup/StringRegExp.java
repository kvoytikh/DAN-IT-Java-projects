package ua.com.danit.fs.warmup;

public class StringRegExp {
    public static void main(String[] args) {
        // ^ - beginning of string
        // $ - end of string
        // .+ - one character (excluding whitespace)
        // .* - any number of character
        // () - rule

        // FOR VALIDATION
        System.out.println("aaaBBBccc".matches("^aaa.*с$"));
    }
}
