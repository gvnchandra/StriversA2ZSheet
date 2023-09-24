package binary_search.on_answers;

import java.util.Arrays;

public class AggressiveCows {
    public static void main(String[] args) {
        int[] arr = {0, 3, 4, 7, 10, 9};
        int k = 4;
        System.out.println(aggressiveCows(arr, k));
    }

    public static int aggressiveCows(int[] stalls, int k) {
        //By using binary search
        Arrays.sort(stalls);
        int min = stalls[0], max = stalls[stalls.length - 1];

        int low = 1, high = max - min;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (isPossibleToPlaceCow(stalls, mid, k)) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return high;
    }

    static boolean isPossibleToPlaceCow(int[] stalls, int minDistance, int cows) {
        int countOfCowsPlaced = 1, last = stalls[0];
        for (int i = 1; i < stalls.length; i++) {
            if (stalls[i] - last >= minDistance) {
                countOfCowsPlaced++;
                last = stalls[i];
            }
        }
        return countOfCowsPlaced >= cows;
    }
}
