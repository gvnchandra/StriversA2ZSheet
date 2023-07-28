package arrays.medium;

public class SortAnArray0s1s2s {
    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 1, 2, 1, 2};
        sort012(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void sort012(int[] arr) {
        //Write your code here
        //By using Dutch national flag algorithm
        int l = 0, m = 0, r = arr.length - 1;
        while (m <= r) {
            if (arr[m] == 0) {
                swap(arr, l, m);
                l++;
                m++;
            } else if (arr[m] == 1) {
                m++;
            } else {
                swap(arr, m, r);
                r--;
            }
        }
    }

    static void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
