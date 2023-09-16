package binary_search.one_d_arrays;

public class SearchInARotatedSortedArrayII {
    public static void main(String[] args) {
        int[] arr = {6, 10, 1, 2, 5};
        int key = 3;
        System.out.println(searchInARotatedSortedArrayII(arr, key));
    }

    public static boolean searchInARotatedSortedArrayII(int[] arr, int key) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int m = (low + high) / 2;
            if (arr[m] == key)
                return true;
            if (arr[m] == arr[low] && arr[m] == arr[high]) {
                low += 1;
                high -= 1;
                continue;
            }
            if (arr[low] <= arr[m]) {
                if (arr[low] <= key && key <= arr[m])
                    high = m - 1;
                else
                    low = m + 1;
            } else {
                if (arr[m] <= key && key <= arr[high])
                    low = m + 1;
                else
                    high = m - 1;
            }
        }
        return false;
    }
}
