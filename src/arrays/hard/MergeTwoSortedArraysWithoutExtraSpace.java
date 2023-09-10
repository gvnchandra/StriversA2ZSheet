package arrays.hard;

import java.util.Arrays;

public class MergeTwoSortedArraysWithoutExtraSpace {
    public static void main(String[] args) {
        long[] a1 = {1, 8, 8};
        long[] a2 = {2, 3, 4, 5};
        mergeTwoSortedArraysWithoutExtraSpace(a1, a2);

        //leetcode method
        int[] arr1 = {1, 8, 8, 0, 0, 0, 0};
        int[] arr2 = {2, 3, 4, 5};
        merge(arr1, arr1.length - arr2.length, arr2, arr2.length);
    }

    public static void mergeTwoSortedArraysWithoutExtraSpace(long[] a, long[] b) {
        // Write your code here.
        int m = a.length, n = b.length, left = m - 1, right = 0;
        while (left >= 0 && right < n) {
            if (a[left] > b[right]) {
                long t = a[left];
                a[left] = b[right];
                b[right] = t;
                left--;
                right++;
            } else break;
        }
        Arrays.sort(a);
        Arrays.sort(b);
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));
    }

    public static void merge(int[] a, int m, int[] b, int n) {
        int left = m - 1, right = 0;
        while (left >= 0 && right < n) {
            if (a[left] > b[right]) {
                int t = a[left];
                a[left] = b[right];
                b[right] = t;
                left--;
                right++;
            } else break;
        }
        for (int i = m; i < m + n; i++) {
            a[i] = b[i - m];
        }
        Arrays.sort(a);
        System.out.println(Arrays.toString(a));
    }

    static void swapIfGreater(long[] a, int ind1, long[] b, int ind2) {
        if (a[ind1] > b[ind2]) {
            long t = a[ind1];
            a[ind1] = b[ind2];
            b[ind2] = t;
        }
    }

    public static void method2(long[] a, long[] b) {
        //By using Gap method
        int m = a.length, n = b.length;
        int len = m + n;
        int gap = len / 2 + len % 2;
        while (gap > 0) {
            int left = 0, right = left + gap;
            while (right < len) {
                if (left < m && right >= m) {
                    swapIfGreater(a, left, b, right - m);
                } else if (left >= m) {
                    swapIfGreater(b, left - m, b, right - m);
                } else {
                    swapIfGreater(a, left, a, right);
                }
                left++;
                right++;
            }
            if (gap == 1)
                break;
            gap = gap / 2 + gap % 2;
        }
    }
}
