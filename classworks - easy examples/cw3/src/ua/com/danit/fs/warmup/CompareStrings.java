package ua.com.danit.fs.warmup;

public class CompareStrings {
    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "abc";
        String s3 = new String("abc");
        System.out.println(s1.equals(s2));
        System.out.println(s1.equals(s3));
    }
}
