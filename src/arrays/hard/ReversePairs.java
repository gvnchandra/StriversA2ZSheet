package arrays.hard;

public class ReversePairs {
    public static void main(String[] args) {
        int n = 6;
        int[] arr = {2147483647, 2147483647, -2147483647, -2147483647, -2147483647, 2147483647};
        System.out.println(team(arr, n));
    }

    static void merge(int[] arr, int l, int m, int r) {
        int n1 = m - l + 1, n2 = r - m;
        int[] lhalf = new int[n1];
        int[] rhalf = new int[n2];
        for (int i = 0; i < n1; i++) {
            lhalf[i] = arr[l + i];
        }
        for (int i = 0; i < n2; i++) {
            rhalf[i] = arr[m + 1 + i];
        }
        int i = 0, j = 0, k = l;
        while (i < n1 && j < n2) {
            if (lhalf[i] <= rhalf[j]) {
                arr[k++] = lhalf[i++];
            } else {
                arr[k++] = rhalf[j++];
            }
        }
        while (i < n1) {
            arr[k++] = lhalf[i++];
        }
        while (j < n2) {
            arr[k++] = rhalf[j++];
        }
    }

    static int countReversePairs(int[] arr, int low, int mid, int right) {
        int count = 0, rightStart = mid + 1;
        for (int i = low; i <= mid; i++) {
            while (rightStart <= right) {
                long val = 2L * arr[rightStart];
                if (arr[i] > val)
                    rightStart++;
                else
                    break;
            }
            count += (rightStart - (mid + 1));
        }
        return count;
    }

    static int mergeSort(int[] arr, int l, int r) {
        int count = 0;
        if (l < r) {
            int m = (l + r) / 2;
            count += mergeSort(arr, l, m);
            count += mergeSort(arr, m + 1, r);
            count += countReversePairs(arr, l, m, r);
            merge(arr, l, m, r);
        }
        return count;
    }

    public static int team(int[] skill, int n) {
        //By using merge sort
        return mergeSort(skill, 0, n - 1);
    }
}
