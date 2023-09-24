package binary_search.two_d_arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class SearchInA2dMatrix {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> mat = new ArrayList<>();
        mat.add(new ArrayList<>(Arrays.asList(1, 2, 3, 4)));
        mat.add(new ArrayList<>(Arrays.asList(5, 6, 7, 8)));
        mat.add(new ArrayList<>(Arrays.asList(9, 10, 11, 12)));
        int target = 8;
        System.out.println(searchMatrix(mat, target));
    }

    static boolean searchMatrix(ArrayList<ArrayList<Integer>> mat, int target) {
        int n = mat.size(), m = mat.get(0).size(), low = 0, high = n * m - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int row = mid / m, col = mid % m;
            if (mat.get(row).get(col) == target)
                return true;
            else if (mat.get(row).get(col) < target)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return false;
    }

    public boolean searchMatrix(int[][] mat, int target) {
        int n = mat.length, m = mat[0].length, low = 0, high = n * m - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int row = mid / m, col = mid % m;
            if (mat[row][col] == target)
                return true;
            else if (mat[row][col] < target)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return false;
    }
}
