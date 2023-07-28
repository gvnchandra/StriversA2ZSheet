package arrays.easy;

public class LargestElementInArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println(largestElement(arr, arr.length));
    }

    static int largestElement(int[] arr, int n) {
        // Write your code here.
        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, arr[i]);
        }
        return max;
    }
}
