package bit_manipulation.adavanced;

import java.util.ArrayList;
import java.util.List;

public class AllDivisors {
    public static void main(String[] args) {
        int n = 5;
        System.out.println(printDivisors(n));
    }

    public static List<Integer> printDivisors(int n) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            if (n % i == 0)
                ans.add(i);
        }
        return ans;
    }
}
