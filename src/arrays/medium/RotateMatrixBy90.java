package arrays.medium;

import java.util.Arrays;
import java.util.Objects;

public class RotateMatrixBy90 {
    public static void main(String[] args) {
        int[][] mat = {{1, 2}, {3, 4}};
        int[][] ans = method1(mat);
        System.out.println(Arrays.deepToString(ans));
        rotateMatrix(mat);
        System.out.println(Arrays.deepToString(mat));
    }

    public static int[][] method1(int[][] mat) {
        //By using extra space
        int[][] ans = new int[mat.length][mat[0].length];
        int m = ans.length, n = ans[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans[j][n - 1 - i] = mat[i][j];
            }
        }
        return ans;
    }

    public static void rotateMatrix(int[][] mat) {
        //Rotating 90 can be done by transposing the matrix and reversing each array
        //Transposing the matrix
        for (int i = 0; i < mat.length - 1; i++) {
            for (int j = i + 1; j < mat[0].length; j++) {
                int t = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = t;
            }
        }
        //reversing each array
        for (int[] ar : mat) {
            int l = 0, r = ar.length - 1;
            while (l < r) {
                int t = ar[l];
                ar[l] = ar[r];
                ar[r] = t;
                l++;
                r--;
            }
        }
    }
}
