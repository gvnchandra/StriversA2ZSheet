package arrays.easy;

import java.util.ArrayList;
import java.util.List;

public class UnionOfTwoSortedArrays {
    public static void main(String[] args) {
        int[] a1 = {1, 2, 3, 4, 6};
        int[] a2 = {2, 3, 5};
        System.out.println(sortedArray(a1, a2));
    }

    public static List<Integer> sortedArray(int[] a, int[] b) {
        List<Integer> ans = new ArrayList<>();
        int i = 0, j = 0, m = a.length, n = b.length;
        while (i < m && j < n) {
            if (a[i] <= b[j]) {
                if (ans.isEmpty() || !ans.get(ans.size() - 1).equals(a[i])) {
                    ans.add(a[i]);
                }
                i++;
            } else {
                if (ans.isEmpty() || !ans.get(ans.size() - 1).equals(b[j])) {
                    ans.add(b[j]);
                }
                j++;
            }
        }
        while (i < m) {
            if (ans.size() == 0 || ans.get(ans.size() - 1) != a[i])
                ans.add(a[i]);
            i++;
        }
        while (j < n) {
            if (ans.size() == 0 || ans.get(ans.size() - 1) != b[j])
                ans.add(b[j]);
            j++;
        }
        return ans;
    }
}
