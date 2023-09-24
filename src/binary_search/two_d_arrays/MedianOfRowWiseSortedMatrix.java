package binary_search.two_d_arrays;

public class MedianOfRowWiseSortedMatrix {
    public static void main(String[] args) {
        int[][] mat = {{1, 3, 5}, {2, 6, 9}, {3, 6, 9}};
        System.out.println(findMedian(mat, mat.length, mat[0].length));
    }

    public static int findMedian(int[][] matrix, int m, int n) {
        //By using binary search
        int low = Integer.MAX_VALUE, high = -1;
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] < low)
                low = matrix[i][0];
            if (matrix[i][n - 1] > high)
                high = matrix[i][n - 1];
        }

        while (low <= high) {
            int mid = (low + high) / 2;
            int countOfEle = f(matrix, mid);
            if (countOfEle <= m * n / 2)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return low;
    }

    static int f(int[][] mat, int median) {
        int count = 0;
        for (int i = 0; i < mat.length; i++) {
            count += upperBound(mat[i], median, mat[i].length);
        }
        return count;
    }

    public static int upperBound(int[] arr, int x, int n) {
        int low = 0, high = n - 1;
        while (low <= high) {
            int m = (low + high) / 2;
            if (arr[m] > x) {
                high = m - 1;
            } else {
                low = m + 1;
            }
        }
        return low;
    }
}
