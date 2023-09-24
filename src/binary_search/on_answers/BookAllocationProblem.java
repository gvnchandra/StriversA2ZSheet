package binary_search.on_answers;

import java.util.ArrayList;
import java.util.Arrays;

public class BookAllocationProblem {
    public static void main(String[] args) {
        //int[] arr = {12, 34, 67, 90};
        int m = 2;
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(12, 34, 67, 90));
        System.out.println(findPages(arr, arr.size(), m));
    }

    public static int findPages(ArrayList<Integer> arr, int n, int m) {
        if (m > n)
            return -1;
        int min = Integer.MIN_VALUE, max = 0;
        for (int i = 0; i < arr.size(); i++) {
            min = Math.max(min, arr.get(i));
            max += arr.get(i);
        }
        int low = min, high = max;
        while (low <= high) {
            int mid = (low + high) / 2;
            int count = f(arr, mid);
            if (count <= m) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    static int f(ArrayList<Integer> al, int mid) {
        int stu = 1, pages = 0;
        for (int i = 0; i < al.size(); i++) {
            if (al.get(i) + pages <= mid) {
                pages += al.get(i);
            } else {
                stu++;
                pages = al.get(i);
            }
        }
        return stu;
    }
}
