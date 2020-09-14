package ua.com.danit.fs.warmup;

public class UsingStringBuilder {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();

        long start = System.currentTimeMillis();
        for (int i = 0; i < 10000000l; i++) {
            sb.append(i);
        }
        long end = System.currentTimeMillis();
        System.out.println(end-start);
    }

}
