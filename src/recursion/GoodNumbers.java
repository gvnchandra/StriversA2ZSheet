package recursion;

import java.util.ArrayList;
import java.util.List;

public class GoodNumbers {
    public static void main(String[] args) {
        int a = 840, b = 850, digit = 6;
        System.out.println(goodNumbers(a, b, digit));
    }

    public static List<Integer> goodNumbers(int a, int b, int digit) {
        List<Integer> ans = new ArrayList<>();
        for (int no = a; no <= b; no++) {
            int rightSum = -1;
            boolean valid = true;
            int n = no;
            while (n != 0) {
                int lastDigit = n % 10;
                if (lastDigit == digit || lastDigit <= rightSum) {
                    valid = false;
                    break;
                }
                if (rightSum == -1) rightSum = 0;
                rightSum += lastDigit;
                n /= 10;
            }
            if (valid) ans.add(no);
        }
        return ans;
    }

//    private static boolean isValidGoodNumber(int i, int lastDigit, int digit) {
//        if (isValidGoodNumber(number, number % 10, digit)) {
//            ans.add(number);
//        }
//    }
}
