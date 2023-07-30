package arrays.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrintSpiralMatrix {
    public static void main(String[] args) {
        int[][] mat = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        int[] ans1 = method1(mat);
        int[] ans = spiralMatrix(mat);
        System.out.println(Arrays.toString(ans1));
        System.out.println(Arrays.toString(ans));
    }

    public static int[] spiralMatrix(int[][] mat) {
        // Write your code here.
        List<Integer> ans = new ArrayList<>();
        int n = mat.length, m = mat[0].length;
        int left = 0, right = m - 1, top = 0, down = n - 1;
        while (left <= right && top <= down) {
            for (int i = left; i <= right; i++) {
                ans.add(mat[top][i]);
            }
            top++;
            for (int i = top; i <= down; i++) {
                ans.add(mat[i][right]);
            }
            right--;
            if (top <= down) {
                for (int i = right; i >= left; i--) {
                    ans.add(mat[down][i]);
                }
                down--;
            }
            if (left <= right) {
                for (int i = down; i >= top; i--) {
                    ans.add(mat[i][left]);
                }
                left++;
            }
        }
        return ans.stream().mapToInt(i -> i).toArray();
    }

    static int[] method1(int[][] mat) {
        List<Integer> ans = new ArrayList<>();
        int n = mat.length, m = mat[0].length;
        int left = 0, right = m - 1, top = 0, down = n - 1, dir = 0;
        while (left <= right && top <= down) {
            if (dir == 0) {
                for (int i = left; i <= right; i++) {
                    ans.add(mat[top][i]);
                }
                top++;
            } else if (dir == 1) {
                for (int i = top; i <= down; i++) {
                    ans.add(mat[i][right]);
                }
                right--;
            } else if (dir == 2) {
                for (int i = right; i >= left; i--) {
                    ans.add(mat[down][i]);
                }
                down--;
            } else if (dir == 3) {
                for (int i = down; i >= top; i--) {
                    ans.add(mat[i][left]);
                }
                left++;
            }
            dir = (dir + 1) % 4;
        }
        return ans.stream().mapToInt(i -> i).toArray();
    }
}
