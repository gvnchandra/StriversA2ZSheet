package binary_search.one_d_arrays;

public class ArrayRotatedHowManyTimes {
    public static void main(String[] args) {
        int[] arr = {3, 4, 5, 1, 2};
        System.out.println(findKRotation(arr));
    }

    public static int findKRotation(int[] arr) {
        //finding min element in sorted array
        int low = 0, high = arr.length - 1, ans = Integer.MAX_VALUE, minInd = -1;
        while (low <= high) {
            if (arr[low] <= arr[high]) {
                if (arr[low] < ans) {
                    ans = arr[low];
                    minInd = low;
                }
                break;
            }
            int m = (low + high) / 2;
            if (arr[low] <= arr[m]) {
                if (arr[low] < ans) {
                    ans = arr[low];
                    minInd = low;
                }
                low = m + 1;
            } else {
                if (arr[m] < ans) {
                    ans = arr[m];
                    minInd = m;
                }
                high = m - 1;
            }
        }
        return minInd;
    }
}
