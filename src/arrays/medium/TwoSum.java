package arrays.medium;

import java.util.HashMap;

public class TwoSum {
    public static void main(String[] args) {
        int n = 5, target = 5;
        int[] book = {4, 1, 2, 3, 1};
        System.out.println(read(n, book, target));
    }

    public static String read(int n, int[] book, int target) {
        HashMap<Integer, Integer> has = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int ele = book[i];
            if (has.containsKey(target - ele)) {
                return "YES";
            } else {
                has.put(ele, i);
            }
        }
        return "NO";
    }
}
