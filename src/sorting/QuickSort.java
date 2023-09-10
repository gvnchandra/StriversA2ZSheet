package sorting;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {2, 6, 8, 5, 4, 3};
        //quickSort(arr, 0, arr.length - 1);
        quickSort2(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    static int partition(int[] arr, int low, int high) {
        int i = low - 1, j = low;
        int pivot = arr[high];
        while (j <= high - 1) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
            j++;
        }
        swap(arr, i + 1, j);
        return i + 1;
    }

    static void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pInd = partition(arr, low, high);
            quickSort(arr, low, pInd - 1);
            quickSort(arr, pInd + 1, high);
        }
    }

    static int partition2(int[] arr, int low, int high) {
        int i = low, j = high;
        while (i < j) {
            while (arr[i] <= arr[low] && i < high) {
                i++;
            }
            while (arr[j] > arr[low] && j > low) {
                j--;
            }
            if (i < j) {
                swap(arr, i, j);
            }
        }
        swap(arr, low, j);
        return j;
    }

    public static void quickSort2(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition2(arr, low, high);
            quickSort2(arr, low, pi - 1);
            quickSort2(arr, pi + 1, high);
        }
    }
}
