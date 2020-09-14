package ua.com.danit.fs.warmup;

public class UsingStringConc {
    public static void main(String[] args) {
        String result = "";

        long start = System.currentTimeMillis();
        for (int i = 0; i < 1000000l; i++) {
            result += i;
        }
        long end = System.currentTimeMillis();
        System.out.println(result);
        System.out.println(end-start);
    }
}
