package binary_search.on_answers;

import java.util.Arrays;

public class KokoEatingBananas {
    public static void main(String[] args) {
        int n = 4, h = 8;
        int[] arr = {7, 15, 6, 3};
        System.out.println(minimumRateToEatBananas1(arr, h));
        System.out.println(minimumRateToEatBananas(arr, h));
    }

    public static int minimumRateToEatBananas(int[] v, int h) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < v.length; i++) {
            max = Math.max(max, v[i]);
        }

        int low = 1, high = max;
        while (low <= high) {
            int mid = (low + high) / 2;
            int reqTime = f(v, mid);
            if (reqTime <= h) {
                high = mid - 1;
            } else
                low = mid + 1;
        }
        return low;
    }

    public static int minimumRateToEatBananas1(int[] v, int h) {
        //By using Linear search
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < v.length; i++) {
            max = Math.max(max, v[i]);
        }

        for (int i = 1; i <= max; i++) {
            int reqTime = f(v, i);
            if (reqTime <= h)
                return i;
        }
        return -1;
    }

    static int f(int[] v, int bananasPerHour) {
        int total = 0;
        for (int i = 0; i < v.length; i++) {
            total += Math.ceil((double) v[i] / bananasPerHour);
        }
        return total;
    }
}
