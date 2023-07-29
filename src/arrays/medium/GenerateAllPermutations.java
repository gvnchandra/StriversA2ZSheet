package arrays.medium;

import java.util.ArrayList;
import java.util.List;

public class GenerateAllPermutations {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        List<List<Integer>> ans = generatePermute(arr);
        System.out.println(ans);
        //other way by using swapping
        ans = new ArrayList<>();
        recurPermute(arr, 0, ans);
        System.out.println(ans);
    }

    private static List<List<Integer>> generatePermute(int[] arr) {
        boolean[] map = new boolean[arr.length];
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        method1(arr, map, ds, ans);
        //Time: O(n*n!)
        return ans;
    }

    private static void method1(int[] arr, boolean[] map, List<Integer> ds, List<List<Integer>> ans) {
        if (ds.size() == arr.length) {
            ans.add(new ArrayList<>(ds));
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if (!map[i]) {
                map[i] = true;
                ds.add(arr[i]);
                method1(arr, map, ds, ans);
                map[i] = false;
                ds.remove(ds.size() - 1);
            }
        }
    }


    private static void recurPermute(int[] arr, int ind, List<List<Integer>> ans) {
        if (ind == arr.length) {
            List<Integer> li = new ArrayList<>();
            for (int j : arr) {
                li.add(j);
            }
            ans.add(li);
            return;
        }
        for (int i = ind; i < arr.length; i++) {
            swap(arr, i, ind);
            recurPermute(arr, ind + 1, ans);
            swap(arr, i, ind);
        }
    }

    static void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
