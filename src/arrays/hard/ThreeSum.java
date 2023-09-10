package arrays.hard;

import java.util.*;

public class ThreeSum {
    public static void main(String[] args) {
//           Set<List<Integer>> ans = new HashSet<>();
//        ans.add(new ArrayList<>(Arrays.asList(1,2,3)));
//        ans.add(new ArrayList<>(Arrays.asList(1,2,3)));
        int[] arr = {-175, 0, 298, 0, -480, 0, -331, -265, -395, -38, -165, -292, -16, -465, 0, 327, -239, -34, -7, -421, 0, -326, 0, -425, 281, -445, -1, -132, -169, -468, 0, -359, 0, 0, -169, -336, -303, -34, -385, -414, 0, -267, 154, -165, -207, -282, -349, -289, -160, -498, -292, 0, -89, -225, -418, -289, -200, -396, -247, -272, 0, -310, -420, -58, -402, -129, -34, 0, -170, -420, 0, 0, -400, -159, -250, -68, -228, -274,};
        System.out.println(triplet(arr.length, arr));
    }

    public static List<List<Integer>> triplet(int n, int[] arr) {
        // Write your code here.
        //By using two pointers approach
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(arr);
        for (int k = n - 1; k >= 2; k--) {
            if (k == n - 1 || (k < n - 1 && arr[k] != arr[k + 1])) {
                int i = 0, j = k - 1;
                while (i < j) {
                    if (arr[i] + arr[j] + arr[k] == 0) {
                        ans.add(new ArrayList<>(Arrays.asList(arr[i], arr[j], arr[k])));
                        while (i < j && arr[i] == arr[i + 1]) i++;
                        while (i < j && arr[j] == arr[j - 1]) j--;
                        i++;
                        j--;
                    } else if (arr[i] + arr[j] + arr[k] > 0) {
                        while (i < j && arr[j] == arr[j - 1]) j--;
                        j--;
                    } else {
                        while (i < j && arr[i] == arr[i + 1]) i++;
                        i++;
                    }
                }
            }
        }
        ans.sort(Comparator.comparingInt(a -> a.get(0)));
        return ans;
    }
}
