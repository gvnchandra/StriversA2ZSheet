package binary_search;

import java.util.Arrays;

public class FloorAndCeil {
    public static void main(String[] args) {
        int x = 5;
        int[] arr = {4, 3, 8, 4, 7, 10};
        //System.out.println(ceilingInSortedArray(arr.length, x, arr));
        System.out.println(method2(arr.length, x, arr));
    }

    public static int method2(int n, int x, int[] arr) {
        Arrays.sort(arr);
        int ceil = Integer.MAX_VALUE, floor = -1;
        for (int i = 0; i < n; i++) {
            if (arr[i] <= x) {
                floor = Math.max(floor, arr[i]);
            }
            if (arr[i] >= x) {
                ceil = Math.min(ceil, arr[i]);
            }
        }
        System.out.print(floor + " ");
        return ceil != Integer.MAX_VALUE ? ceil : -1;
    }

    public static int ceilingInSortedArray(int n, int x, int[] arr) {
        Arrays.sort(arr);
        int ceil = -1, floor = -1;
        int low = 0, high = n - 1;
        while (low <= high) {
            int m = (low + high) / 2;
            if (arr[m] >= x) {
                high = m - 1;
                ceil = arr[m];
            } else {
                low = m + 1;
            }
        }

        low = 0;
        high = n - 1;
        while (low <= high) {
            int m = (low + high) / 2;
            if (arr[m] <= x) {
                floor = arr[m];
                low = m + 1;
            } else
                high = m - 1;
        }
        System.out.print(floor + " ");
        return ceil;
    }
}
