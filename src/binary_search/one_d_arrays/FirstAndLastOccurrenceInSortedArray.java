package binary_search.one_d_arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class FirstAndLastOccurrenceInSortedArray {


    public static void main(String[] args) {
        int n = 8, k = 2;
        ArrayList<Integer> al = new ArrayList<>(Arrays.asList(0, 0, 1, 1, 2, 2, 2, 2));
        System.out.println(Arrays.toString(firstAndLastPosition(al, n, k)));
    }

    static int lowerBound(ArrayList<Integer> arr, int k) {
        int low = 0, high = arr.size() - 1, ans = arr.size();
        while (low <= high) {
            int m = (low + high) / 2;
            if (arr.get(m) >= k) {
                ans = m;
                high = m - 1;
            } else {
                low = m + 1;
            }
        }
        return ans;
    }

    static int upperBound(ArrayList<Integer> arr, int k) {
        int low = 0, high = arr.size() - 1, ans = arr.size();
        while (low <= high) {
            int m = (low + high) / 2;
            if (arr.get(m) > k) {
                ans = m;
                high = m - 1;
            } else {
                low = m + 1;
            }
        }
        return ans;
    }

    public static int[] firstAndLastPosition(ArrayList<Integer> arr, int n, int k) {
        //By using binary search lower bound and upperbound
        int lb = lowerBound(arr, k);
        int ub = upperBound(arr, k);
        if (lb == arr.size() || arr.get(lb) != k)
            return new int[]{-1, -1};
        return new int[]{lb, ub - 1};
    }
}
