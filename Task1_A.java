import java.io.*;
import java.util.*;

public class Task1_A {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your first string");
        String A = sc.next();
        System.out.println("Enter your second string");
        String B = sc.next();

        int length = A.length() + B.length();
        String isAGreaterThanB = (A.compareTo(B) > 0) ? "Yes" : "No";
        String resultString = A.substring(0,1).toUpperCase() + A.substring(1) + " " + B.substring(0,1).toUpperCase() + B.substring(1);

        System.out.println(length);
        System.out.println(isAGreaterThanB);
        System.out.println(resultString);
    }
}