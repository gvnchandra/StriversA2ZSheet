package binary_search.two_d_arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class RowWithMaxOnes {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> mat = new ArrayList<>();
        mat.add(new ArrayList<>(Arrays.asList(1, 1, 1)));
        mat.add(new ArrayList<>(Arrays.asList(0, 0, 1)));
        mat.add(new ArrayList<>(Arrays.asList(0, 0, 0)));
        System.out.println(maximumOnesRow(mat, mat.size(), mat.get(0).size()));
    }

    static int lowerBound(ArrayList<Integer> al) {
        int low = 0, high = al.size() - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (al.get(mid) >= 1) {
                high = mid - 1;
            } else
                low = mid + 1;
        }
        return low;
    }

    public static int maximumOnesRow(ArrayList<ArrayList<Integer>> matrix, int n, int m) {
        int countMax = 0, ind = -1;
        for (int i = 0; i < n; i++) {
            int cnt = m - lowerBound(matrix.get(i));
            if (cnt > countMax) {
                countMax = cnt;
                ind = i;
            }
        }
        return ind;
    }
}
