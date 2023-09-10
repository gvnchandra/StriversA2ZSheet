package arrays.hard;

public class CountInversions {
    public static void main(String[] args) {
        int n = 5;
        int[] arr = {5, 3, 2, 1, 4};
        System.out.println(numberOfInversions(arr, n));
    }

    static int merge(int[] arr, int l, int m, int r) {
        int n1 = m - l + 1, n2 = r - m, count = 0;
        int[] left = new int[n1];
        int[] right = new int[n2];

        for (int i = 0; i < n1; i++) {
            left[i] = arr[l + i];
        }
        for (int j = 0; j < n2; j++) {
            right[j] = arr[m + 1 + j];
        }
        int i = 0, j = 0, k = l;
        while (i < n1 && j < n2) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                count += (n1 - i);
                arr[k++] = right[j++];
            }
        }
        while (i < n1) {
            arr[k++] = left[i++];
        }
        while (j < n2) {
            arr[k++] = right[j++];
        }
        return count;
    }

    static int countInversions(int[] arr, int l, int r) {
        int count = 0;
        if (l < r) {
            int m = (l + r) / 2;
            count += countInversions(arr, l, m);
            count += countInversions(arr, m + 1, r);
            count += merge(arr, l, m, r);
        }
        return count;
    }

    public static int numberOfInversions(int[] a, int n) {
        //By slight modification in merge sort
        return countInversions(a, 0, a.length - 1);
    }
}
