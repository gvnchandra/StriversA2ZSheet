package basic;

import java.util.Scanner;

public class DeterminePositiveOrNegative {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        if (n>>31==0)
            System.out.println(n+" is positive");
        else
            System.out.println(n+" is negative");
    }
}
