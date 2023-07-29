package arrays.medium;

import java.util.Arrays;
import java.util.HashSet;

public class LongestConsecutiveSubsequenceInAnArray {
    public static void main(String[] args) {
        int[] a = {1, 2, 2, 1};
        int n = 4;
        System.out.println(method1(a));
        System.out.println(method2(a));
        System.out.println(longestConsecutive(a));
    }

    public static int longestConsecutive(int[] a) {
        if (a.length==0)
            return 0;
        int maxCount = 1;
        HashSet<Integer> has = new HashSet<>();
        for (int j : a) {
            has.add(j);
        }
        for (int ele : has) {
            if (!has.contains(ele - 1)) {
                int count = 1, x = ele;
                while (has.contains(x + 1)) {
                    x++;
                    count++;
                }
                maxCount = Math.max(maxCount, count);
            }
        }
        return maxCount;
    }

    public static int method1(int[] a) {
        // Write your code here.
        int maxCount = 1;
        for (int i = 0; i < a.length; i++) {
            int x = a[i];
            int count = 1;
            while (linearSearch(a, x + 1)) {
                count += 1;
                x += 1;
            }
            maxCount = Math.max(maxCount, count);
        }
        return maxCount;
    }

    public static int method2(int[] a) {
        //By using sorting
        Arrays.sort(a);
        int lastSmaller = Integer.MIN_VALUE, count = 0, maxCount = 1;
        for (int i = 0; i < a.length; i++) {
            if (a[i] - 1 == lastSmaller) {
                count++;
                lastSmaller = a[i];
            } else if (a[i] != lastSmaller) {
                maxCount = Math.max(maxCount, count);
                count = 1;
                lastSmaller = a[i];
            }
        }
        return Math.max(maxCount, count);
    }

    static boolean linearSearch(int[] a, int num) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == num)
                return true;
        }
        return false;
    }
}
