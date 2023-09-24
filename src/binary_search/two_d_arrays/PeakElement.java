package binary_search.two_d_arrays;

import java.util.Arrays;

public class PeakElement {
    public static void main(String[] args) {
        int[][] g = {{8, 6}, {10, 1}};
        System.out.println(Arrays.toString(findPeakGrid(g)));
    }

    public static int[] findPeakGrid(int[][] g) {
        int low = 0, high = g[0].length;
        while (low <= high) {
            int col = (low + high) / 2;
            int row = maxEleInCol(g, col);
            int leftEle = col - 1 >= 0 ? g[row][col - 1] : -1;
            int rightEle = col + 1 < g[0].length ? g[row][col + 1] : -1;
            if (g[row][col] > leftEle && g[row][col] > rightEle)
                return new int[]{row, col};
            else if (g[row][col] < leftEle) {
                high = col - 1;
            } else
                low = col + 1;
        }
        return new int[]{-1, -1};
    }

    static int maxEleInCol(int[][] g, int col) {
        int row = -1, maxValue = -1;
        for (int i = 0; i < g.length; i++) {
            if (g[i][col] > maxValue) {
                maxValue = g[i][col];
                row = i;
            }
        }
        return row;
    }
}
