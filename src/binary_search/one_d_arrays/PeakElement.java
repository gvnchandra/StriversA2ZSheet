package binary_search.one_d_arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class PeakElement {
    public static void main(String[] args) {
        ArrayList<Integer> al = new ArrayList<>(Arrays.asList(1, 8, 1, 5, 3));
        System.out.println(findPeakElement(al));
        System.out.println(findPeakElement(al.stream().mapToInt(Integer::intValue).toArray()));
    }

    public static int findPeakElement(ArrayList<Integer> arr) {
        int n = arr.size();
        if (n == 1)
            return 0;
        if (arr.get(0) > arr.get(1))
            return 0;
        if (arr.get(n - 1) > arr.get(n - 2))
            return n - 1;

        int low = 1, high = n - 2;
        while (low <= high) {
            int m = (low + high) / 2;
            if (arr.get(m) > arr.get(m + 1) && arr.get(m) > arr.get(m - 1))
                return m;
            if (arr.get(m) > arr.get(m - 1))
                low = m + 1;
            else
                high = m - 1;
        }
        return -1;
    }

    public static int findPeakElement(int[] arr) {
        int n = arr.length;
        if (n == 1)
            return 0;
        if (arr[0] > arr[1])
            return 0;
        if (arr[n - 1] > arr[n - 2])
            return n - 1;

        int low = 1, high = n - 2;
        while (low <= high) {
            int m = (low + high) / 2;
            if (arr[m] > arr[m + 1] && arr[m] > arr[m - 1])
                return m;
            if (arr[m] > arr[m - 1])
                low = m + 1;
            else
                high = m - 1;
        }
        return -1;
    }
}
