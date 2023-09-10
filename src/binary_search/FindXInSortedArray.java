package binary_search;

public class FindXInSortedArray {
    public static void main(String[] args) {
        int n = 7;
        int[] arr = {1, 3, 7, 9, 11, 12, 45};
        int target = 3;
        System.out.println(search(arr, target));
    }

    public static int search(int[] nums, int target) {
        //By using binary search
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target)
                return mid;
            else if (target < nums[mid])
                high = mid - 1;
            else
                low = mid + 1;
        }
        return -1;
    }
}
