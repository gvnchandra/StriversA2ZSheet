package arrays.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeOverlappingSubIntervals {
    public static void main(String[] args) {

    }

    public static List<List<Integer>> mergeOverlappingIntervals(int[][] arr) {
        //Arrays.sort(arr, (a, b)->a[0]-b[0]);
        Arrays.sort(arr, Comparator.comparingInt(a -> a[0]));
        List<List<Integer>> ans = new ArrayList<>();
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if (ans.isEmpty() || ans.get(ans.size() - 1).get(1) < arr[i][0]) {
                ans.add(Arrays.asList(arr[i][0], arr[i][1]));
            } else {
                List<Integer> lastEle = ans.get(ans.size() - 1);
                lastEle.set(1, Math.max(lastEle.get(1), arr[i][1]));
            }
        }
        return ans;
    }

    public int[][] merge(int[][] arr) {
        List<int[]> ans = new ArrayList<>();
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if (ans.isEmpty() || ans.get(ans.size() - 1)[1] < arr[i][0]) {
                ans.add(new int[]{arr[i][0], arr[i][1]});
            } else {
                int[] lastEle = ans.get(ans.size() - 1);
                lastEle[1] = Math.max(lastEle[1], arr[i][1]);
            }
        }
        return ans.toArray(new int[ans.size()][2]);
    }
}
