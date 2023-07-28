package arrays.easy;

public class LinearSearch {
    public static void main(String[] args) {
        int[] arr = {6, 7, 8, 4, 1};
        int n = arr.length, num = 4;
        System.out.println(linearSearch(n, num, arr));
    }

    public static int linearSearch(int n, int num, int[] arr) {
        // Write your code here.
        for (int i = 0; i < n; i++) {
            if (arr[i] == num)
                return i;
        }
        return -1;
    }
}
