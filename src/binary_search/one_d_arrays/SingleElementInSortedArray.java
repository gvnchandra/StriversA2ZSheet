package binary_search.one_d_arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class SingleElementInSortedArray {
    public static void main(String[] args) {
        ArrayList<Integer> al = new ArrayList<>(Arrays.asList(10, 10, 14, 16, 16, 25, 25, 28, 28, 36, 36, 44, 44));
        System.out.println(singleNonDuplicate(al));
        System.out.println(singleNonDuplicate(al.stream().mapToInt(Integer::intValue).toArray()));
    }

    public static int singleNonDuplicate(ArrayList<Integer> arr) {
        int n = arr.size();
        if (n == 1)
            return arr.get(0);
        if (!arr.get(0).equals(arr.get(1)))
            return arr.get(0);
        if (!arr.get(n - 1).equals(arr.get(n - 2)))
            return arr.get(n - 1);
        int low = 1, high = n - 2;
        while (low <= high) {
            int m = (low + high) / 2;
            if (!arr.get(m).equals(arr.get(m + 1)) &&
                    !arr.get(m).equals(arr.get(m - 1)))
                return arr.get(m);
            if (((m & 1) == 0 && arr.get(m).equals(arr.get(m + 1))) ||
                    ((m & 1) != 0 && arr.get(m).equals(arr.get(m - 1)))) {
                low = m + 1;
            } else {
                high = m - 1;
            }
        }
        return -1;
    }

    public static int singleNonDuplicate(int[] arr) {
        int n = arr.length;
        if (n == 1)
            return arr[0];
        if (arr[0] != (arr[1]))
            return arr[0];
        if (arr[n - 1] != (arr[n - 2]))
            return arr[n - 1];
        int low = 1, high = n - 2;
        while (low <= high) {
            int m = (low + high) / 2;
            if (arr[m] != arr[m + 1] &&
                    arr[m] != arr[m - 1])
                return arr[m];
            if (((m & 1) == 0 && arr[m] == arr[m + 1]) ||
                    ((m & 1) != 0 && arr[m] == arr[m - 1])) {
                low = m + 1;
            } else {
                high = m - 1;
            }
        }
        return -1;
    }
}
