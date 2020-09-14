package ua.com.danit.fs.warmup;

public class EnvelopeApp {
    public static void main(String[] args) {
        for(int i = 0; i <= 10; i++) {
            for (int j = 0; j <= 20; j++) {
                if (i == 0 || i == 10 || j == 0 || j == 20 || i * 2 == j || i * 2 == 20 - j) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
