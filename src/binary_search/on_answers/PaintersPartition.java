package binary_search.on_answers;

import java.util.ArrayList;
import java.util.Arrays;

public class PaintersPartition {
    public static void main(String[] args) {
        ArrayList<Integer> boards = new ArrayList<>(Arrays.asList(2, 1, 5, 6, 2, 3));
        int k = 2;
        System.out.println(findLargestMinDistance(boards, k));
    }

    public static int findLargestMinDistance(ArrayList<Integer> boards, int k) {
        //By using binary search
        int max = Integer.MIN_VALUE, sum = 0;
        for (int i = 0; i < boards.size(); i++) {
            max = Math.max(max, boards.get(i));
            sum += boards.get(i);
        }
        int low = max, high = sum;
        while (low <= high) {
            int mid = (low + high) / 2;
            int count = f(boards, mid);
            if (count <= k) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    static int f(ArrayList<Integer> al, int mid) {
        int noOfPainters = 1, sum = 0;
        for (int i = 0; i < al.size(); i++) {
            if (al.get(i) + sum <= mid) {
                sum += al.get(i);
            } else {
                noOfPainters++;
                sum = al.get(i);
            }
        }
        return noOfPainters;
    }
}
